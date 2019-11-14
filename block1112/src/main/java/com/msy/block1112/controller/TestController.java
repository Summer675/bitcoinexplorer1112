package com.msy.block1112.controller;

import com.alibaba.fastjson.JSONObject;
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
    private BitcoinRest bitcoinRest;

    @GetMapping("/hi")
    public String hi(){
        JSONObject chainInfo = bitcoinRest.getChainInfo();
        return null;
    }
}
