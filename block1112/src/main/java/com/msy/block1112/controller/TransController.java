package com.msy.block1112.controller;

import com.alibaba.fastjson.JSONObject;
import com.msy.block1112.dao.TransMapper;
import com.msy.block1112.dto.TransListDto;
import com.msy.block1112.po.Trans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@EnableAutoConfiguration
@RequestMapping("/trans")
public class TransController {

    @Autowired
    private TransMapper transMapper;

    @GetMapping("/getConfirmed")
    public List<JSONObject> list(@RequestParam(required = false,defaultValue = "20") Integer sizeOndisk){
        return transMapper.list(sizeOndisk);
    }
    @GetMapping("/getTransByTxhash")
    public JSONObject getTransByTxhash(@RequestParam String txhash){
        return transMapper.getTransByTxhash(txhash);
    }



}
