package com.msy.block1112.client;

import com.alibaba.fastjson.JSONObject;
import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;
import java.util.HashMap;

@Service
public class BitJsonRpcImpl implements BitJsonRpc{

    private JsonRpcHttpClient jsonRpcHttpClient;

    public BitJsonRpcImpl (@Value("${bitcoin.jsonrpc.url}") String url,
                           @Value("${bitcoin.jsonrpc.username}") String username,
                           @Value("${bitcoin.jsonrpc.password}") String password)throws MalformedURLException {
      jsonRpcHttpClient=new JsonRpcHttpClient(new URL(url));
        HashMap<String,String> hashMap=new HashMap<>();
        String str=username+":"+password;
        String s = Base64.getEncoder().encodeToString(str.getBytes());
        hashMap.put("Authorization","Basic "+s);
        jsonRpcHttpClient.setHeaders(hashMap);
    }
    @Override
    public JSONObject getTrans(String txId) throws Throwable {
        JSONObject jsonObject = jsonRpcHttpClient.invoke("getrawtransaction", new Object[] { txId, true }, JSONObject.class);
        return jsonObject;

    }
}
