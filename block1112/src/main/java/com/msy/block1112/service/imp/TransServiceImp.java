package com.msy.block1112.service.imp;

import com.alibaba.fastjson.JSONObject;
import com.msy.block1112.client.BitcoinRest;
import com.msy.block1112.dao.TransMapper;
import com.msy.block1112.po.Trans;
import com.msy.block1112.service.TransDetailService;
import com.msy.block1112.service.TransService;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

public class TransServiceImp implements TransService {

    @Autowired
    private BitcoinRest bitcoinRest;

    @Autowired
    private TransMapper transMapper;

    @Autowired
    private TransDetailService transDetailService;

    @Override
    public void sTrans(String txid, Integer blockId, Long time) {
        JSONObject transactionJson = bitcoinRest.getTx(txid);
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
    }

