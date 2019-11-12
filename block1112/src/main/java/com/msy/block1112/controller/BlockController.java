package com.msy.block1112.controller;

import com.msy.block1112.dao.BlockMapper;
import com.msy.block1112.dto.BlockDetali;
import com.msy.block1112.po.Block;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@EnableAutoConfiguration
@RequestMapping("/block")
public class BlockController {
    @Autowired
    private BlockMapper blockMapper;

    @GetMapping("/list")
    public List<Block> list(){
       return blockMapper.list();
    }

    @GetMapping("/getBlockByHash")
    public List<Block> getBlockByHash(@RequestParam String blockHash){
        List<Block> blocks = blockMapper.getblockDetailByHash(blockHash);
       return blocks;
    }

    @GetMapping("/getBlockByHeight")
    public List<Block> getBlockByHeight(@RequestParam Integer height){
        return blockMapper.getblockDetailByHeight(height);

    }
}
