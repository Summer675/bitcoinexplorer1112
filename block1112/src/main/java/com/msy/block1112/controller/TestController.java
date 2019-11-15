package com.msy.block1112.controller;

import com.alibaba.fastjson.JSONObject;
import com.msy.block1112.client.BitJsonRpcImpl;
import com.msy.block1112.client.BitcoinRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private BitJsonRpcImpl bitJsonRpc;
    @Autowired
    private BitcoinRest bitcoinRest;

    @GetMapping("/hi")
    public String hi() throws  Throwable{
        JSONObject chainInfo = bitcoinRest.getChainInfo();
        JSONObject jsonObject = bitJsonRpc.getTrans("df53a7893a26f245c62905984d6cab8fcf6df3eeac24aa450b0b4928a7181453");


        return null;
    }
}
