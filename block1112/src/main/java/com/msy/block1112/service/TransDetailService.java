package com.msy.block1112.service;

import com.alibaba.fastjson.JSONObject;
import com.msy.block1112.po.TransDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TransDetailService {
    void sTransDetailVout(JSONObject vout, Integer transactionId);

    void sTransDetailVin(JSONObject vin, Integer transactionId);

    //
    List<TransDetail> getTransDetailId(Integer txDetailId);
    Integer getTotalByAddress(String address);

    Double getByAddress(String address);

    Double getSendByAddress(String address);
}
