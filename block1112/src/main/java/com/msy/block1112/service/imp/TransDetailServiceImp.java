package com.msy.block1112.service.imp;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.msy.block1112.client.BitJsonRpcImpl;
import com.msy.block1112.client.BitcoinRest;
import com.msy.block1112.dao.TransDetailMapper;
import com.msy.block1112.meiju.TxDetailType;
import com.msy.block1112.po.TransDetail;
import com.msy.block1112.service.TransDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransDetailServiceImp implements TransDetailService  {
    @Autowired
    private TransDetailMapper transDetailMapper;
    @Autowired
    private BitcoinRest bitcoinRest;
    @Autowired
    private BitJsonRpcImpl bitJsonRpc;

    @Override
    public void sTransDetailVout(JSONObject vout, Integer transid) {
        TransDetail transDetail = new TransDetail();
        JSONObject scriptPubKey = vout.getJSONObject("scriptPubKey");
        JSONArray address = scriptPubKey.getJSONArray("address");
        if (address!=null){
            String addr = (String) address.get(0);
            transDetail.setAddress(addr);
            transDetail.setAmount(vout.getDouble("value"));
            transDetail.setType((byte) TxDetailType.Receive.ordinal());
            transDetail.setTransid(transid);
            transDetailMapper.insert(transDetail);

        }
    }

    @Override
    public void sTransDetailVin(JSONObject vin, Integer transid) throws Throwable {
        TransDetail transDetail = new TransDetail();
        transDetail.setTransid(transid);
        transDetail.setType((byte) TxDetailType.Send.ordinal());
        String txIdVin = vin.getString("txId");
        Integer n = vin.getInteger("vout");
        if (txIdVin!=null && n!=null){
            JSONObject trans = bitJsonRpc.getTrans(txIdVin);
            JSONArray vout = trans.getJSONArray("vout");
            JSONObject jsonObject = vout.getJSONObject(n);
            Double amount = jsonObject.getDouble("value");
            transDetail.setAmount(-amount);
            JSONObject scriptPubKey = jsonObject.getJSONObject("scriptPubKey");
            JSONArray address = scriptPubKey.getJSONArray("address");
            if (address!=null){
                String addr = address.getString(0);
                transDetail.setAddress(addr);
                transDetailMapper.insert(transDetail);

            }
        }

    }
}
