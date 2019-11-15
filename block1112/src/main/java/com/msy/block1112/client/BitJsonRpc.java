package com.msy.block1112.client;

import com.alibaba.fastjson.JSONObject;

public interface BitJsonRpc {
    JSONObject getTrans(String txId) throws Throwable;
}
