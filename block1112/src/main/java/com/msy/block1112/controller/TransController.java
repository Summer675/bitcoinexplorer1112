package com.msy.block1112.controller;

import com.msy.block1112.dao.TransMapper;
import com.msy.block1112.dto.TransListDto;
import com.msy.block1112.po.Trans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@EnableAutoConfiguration
@RequestMapping("/trans")
public class TransController {

    @Autowired
    private TransMapper transMapper;

    @GetMapping("/list")
    public List<Trans> list(){
        return transMapper.list();
    }
    @GetMapping("/getTransByTxhash")
    public TransListDto getTransByTxhash(@RequestParam String txhash){
        return transMapper.getTransByTxhash(txhash);
    }

}
