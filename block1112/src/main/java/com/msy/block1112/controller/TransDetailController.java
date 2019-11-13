package com.msy.block1112.controller;

import com.alibaba.fastjson.JSONObject;
import com.msy.block1112.dao.TransDetailMapper;
import com.msy.block1112.po.TransDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@EnableAutoConfiguration
@RequestMapping("/transDetail")
public class TransDetailController {
    @Autowired
    private TransDetailMapper transDetailMapper;

    @GetMapping("/list")
    public List<TransDetail> list(){
        return transDetailMapper.list();
    }

    @GetMapping("/address")
    public JSONObject getaddress(@RequestParam String address){
        return transDetailMapper.getAddress(address);
    }
}
