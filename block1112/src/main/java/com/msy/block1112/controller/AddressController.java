package com.msy.block1112.controller;

import com.alibaba.fastjson.JSONObject;
import com.msy.block1112.service.TransDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private TransDetailService transDetailService;


    @GetMapping("/getInfoByAddress")
    public JSONObject getInfoByAddress(@RequestParam String address){

        Integer txTotal = transDetailService.getTotalByAddress(address);
        Double receiveAmount = transDetailService.getByAddress(address);
        Double sendAmount = transDetailService.getSendByAddress(address);
        Double balance= receiveAmount + sendAmount;
        JSONObject addressInfojson = new JSONObject();
        addressInfojson.put("address",address);
        addressInfojson.put("txSize",txTotal);
        addressInfojson.put("totalReceived",receiveAmount);
        addressInfojson.put("totalSend",Math.abs(sendAmount));
        addressInfojson.put("balance",balance);
        return addressInfojson;
    }
}
