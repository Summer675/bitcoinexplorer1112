package com.msy.block1112.controller;

import com.msy.block1112.dao.TransDetailMapper;
import com.msy.block1112.po.TransDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
