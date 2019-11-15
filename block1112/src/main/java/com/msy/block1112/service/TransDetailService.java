package com.msy.block1112.service;

import com.alibaba.fastjson.JSONObject;

public interface TransDetailService {
    void sTransDetailVout(JSONObject vout, Integer transactionId);

    void sTransDetailVin(JSONObject vin, Integer transactionId);
}
