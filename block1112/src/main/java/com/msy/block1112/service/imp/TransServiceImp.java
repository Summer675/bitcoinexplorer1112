package com.msy.block1112.service.imp;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.msy.block1112.changliang.ChangLiang;
import com.msy.block1112.client.BitcoinRest;
import com.msy.block1112.dao.TransMapper;
import com.msy.block1112.po.Trans;
import com.msy.block1112.service.TransDetailService;
import com.msy.block1112.service.TransService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;


import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class TransServiceImp implements TransService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    private JSONObject originMempoolTx = new JSONObject();

    private List<JSONObject> deltaTxes = new LinkedList<>();
    @Autowired
    private BitcoinRest bitcoinRest;

    @Autowired
    private TransMapper transMapper;

    @Autowired
    private TransDetailService transDetailService;

    @Override
    public void sTrans(String txId, Integer blockId, Long time)  {
        JSONObject transactionJson = bitcoinRest.getTx(txId);
        Trans trans = new Trans();
        trans.setBlock_id(blockId);
        trans.setSizeOndisk(transactionJson.getInteger("size"));
        trans.setStatus((byte)0);
        trans.setTime(time);
        trans.setTxHash(transactionJson.getString("hash"));
        trans.setTransId(transactionJson.getInteger("transId"));
        trans.setWeight(transactionJson.getInteger("weight"));
        transMapper.insert(trans);
        Integer transactionId = trans.getTransId();
        List<JSONObject> vouts = transactionJson.getJSONArray("vout").toJavaList(JSONObject.class);
        for (JSONObject vout : vouts) {
            transDetailService.sTransDetailVout(vout, transactionId);
        }
        List<JSONObject> vins = transactionJson.getJSONArray("vin").toJavaList(JSONObject.class);
        for (JSONObject vin : vins) {
            transDetailService.sTransDetailVin(vin, transactionId);
        }
    }

    @Override
    public List<Trans> selectAllByBlockhash(Integer block_id) {
        List<Trans> trans = transMapper.selectAllByBlockhash(block_id);
        return trans;
    }

    @Override
    public Page<Trans> selectByBlockIdWithPage(Integer block_id, Integer page) {
        PageHelper.startPage(page, ChangLiang.PAGE_SIZE);
        Page<Trans> trans = transMapper.selectByBlockIdWithPage(block_id);
        return trans;


    }

    @Override
    public Trans getByTxId(String txId) {

        return transMapper.getByTxId(txId);
    }

    @Override
    public Page<Trans> getTransByAddress(String address, Integer page) {
        PageHelper.startPage(page, ChangLiang.PAGE_SIZE);
        Page<Trans> trans = transMapper.getTransByAddressPage(address);
        return trans;
    }

    @Override
    public void pushNewMempoolTxes() {
        logger.info("begin sync mempool tx");

        JSONObject newMempoolTx = bitcoinRest.getMempoolContents();

        int originSize = originMempoolTx.size();
        int newSize = newMempoolTx.size();
        if (newSize <= originSize){
            return  ;
        }

        for (Map.Entry<String, Object> entry : newMempoolTx.entrySet()) {
            String key = entry.getKey();
            if (!originMempoolTx.containsKey(key)){
                JSONObject addJson = newMempoolTx.getJSONObject(key);
                addJson.put("txid", key);
                deltaTxes.add(addJson);
            }
        }
        logger.info("delta tx: {}", deltaTxes);
        logger.info("delta size: {}", deltaTxes.size());

        List<JSONObject> deltaTxesJsons = deltaTxes.stream().map(t -> {
            JSONObject tJson = new JSONObject();
            tJson.put("txid", t.getString("txid"));
            tJson.put("wtxid", t.getString("wtxid"));
            tJson.put("time", t.getLong("time"));


            return tJson;
        }).collect(Collectors.toList());
        List<JSONObject> sortedDeltaTxesJsons = deltaTxesJsons.stream().sorted((t1,t2)->{
            return (int)(t2.getLong("time")-t1.getLong("time"));
        }).collect(Collectors.toList());
        simpMessagingTemplate.convertAndSend("/bitcoin/deltaTx", sortedDeltaTxesJsons);

        deltaTxes = new LinkedList<>();
        originMempoolTx = newMempoolTx;

        logger.info("end sync mempool tx");

    }
    }




