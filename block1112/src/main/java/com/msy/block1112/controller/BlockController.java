package com.msy.block1112.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.msy.block1112.dao.BlockMapper;
import com.msy.block1112.dto.BlockDetali;
import com.msy.block1112.po.Block;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.ls.LSInput;

import java.util.List;

@RestController
@CrossOrigin
@EnableAutoConfiguration
@RequestMapping("/block")
public class BlockController {
    @Autowired
    private BlockMapper blockMapper;

    @GetMapping("/list")
    public List<JSONObject> list(){
       return blockMapper.list();
    }


    @GetMapping("/getPage")
    public PageInfo<JSONObject> getPage(@RequestParam(required = false,defaultValue = "1")Integer page){
        PageHelper.startPage(page,3);
        Page<JSONObject> list = blockMapper.list();
        PageInfo<JSONObject> jsonObjectPageInfo = list.toPageInfo();
        return jsonObjectPageInfo;
    }
    @GetMapping("/getBlockByHash")
    public JSONObject getBlockByHash(@RequestParam String blockhash){

        return blockMapper.getblockDetailByHash(blockhash);
    }

    @GetMapping("/getBlockByHeight")
    public JSONObject getBlockByHeight(@RequestParam Integer height){
        return blockMapper.getblockDetailByHeight(height);

    }
}
