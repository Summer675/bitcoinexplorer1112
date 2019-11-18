package com.msy.block1112.controller;

import com.alibaba.fastjson.JSONObject;
import com.msy.block1112.client.BitJsonRpcImpl;
import com.msy.block1112.client.BitcoinRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
      //  JSONObject jsonObject = bitJsonRpc.getTrans("df53a7893a26f245c62905984d6cab8fcf6df3eeac24aa450b0b4928a7181453");
        JSONObject blockhashByHeight = bitcoinRest.getBlockhashByHeight(10);
        List<JSONObject> blockHeaders = bitcoinRest.getBlockHeaders(5, "00000000000005e4b66870f5c31829abfbd667c7dc2e96f98ab5bad2989463e1");
        JSONObject jsonObject = bitcoinRest.getblockNotxDetail("0000000000003f3a41014cdc9a3c7b1fdfcf8a4be509da437ca6c492cf992c9d");
        JSONObject chainInfo1 = bitcoinRest.getBlockInfo("0000000000003f3a41014cdc9a3c7b1fdfcf8a4be509da437ca6c492cf992c9d");
        JSONObject tx = bitcoinRest.getTx("f39bb64199bbbbab33ad45ede802f6dada0f2aea704cb180742afe2e2a69e044");
        JSONObject mempoolInfo = bitcoinRest.getMempoolInfo();
        JSONObject mempoolContents = bitcoinRest.getMempoolContents();
        JSONObject utxo = bitcoinRest.getUTXO("f39bb64199bbbbab33ad45ede802f6dada0f2aea704cb180742afe2e2a69e044", 0);
        return null;
    }
}
