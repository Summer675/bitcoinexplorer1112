package com.msy.block1112.controller;

import com.msy.block1112.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sdate")
@EnableAutoConfiguration
public class SDateController {
    @Autowired
    private BlockService blockService;

    @PostMapping("/fullImport")//创世区块
    public void fullImport(@RequestParam(required = false, defaultValue = "00000000adde5256150e514644c5ec4f81bda990faec90230a2c80a929cae027") String blockhash){
        blockService.sBlocks(blockhash);
    }
}
