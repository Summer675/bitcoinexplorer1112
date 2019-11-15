package com.msy.block1112.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.msy.block1112.dao.BlockMapper;
import com.msy.block1112.dto.BlockDetali;
import com.msy.block1112.dto.PageDto;
import com.msy.block1112.po.Block;
import com.msy.block1112.po.Trans;
import com.msy.block1112.po.TransDetail;
import com.msy.block1112.service.BlockService;
import com.msy.block1112.service.TransDetailService;
import com.msy.block1112.service.TransService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.ls.LSInput;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@EnableAutoConfiguration
@RequestMapping("/block")
public class BlockController {
    @Autowired
    private BlockMapper blockMapper;
    @Autowired
    private BlockService blockService;

    @Autowired
    private TransService transService;

    @Autowired
    private TransDetailService transDetailService;


    @GetMapping("/list")
    public List<JSONObject> select(){
        List<Block> blocks = blockService.select();
        List<JSONObject> collect = blocks.stream().map(block -> {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("height", block.getHeight());
            jsonObject.put("blockhash", block.getBlockhash());
            jsonObject.put("time", block.getTime());
            jsonObject.put("miner", block.getMined());
            jsonObject.put("size", block.getSize());
            return jsonObject;
        }).collect(Collectors.toList());
        return collect;
    }


    @GetMapping("/getPage")
    public PageDto<JSONObject> getPage(@RequestParam(required = false,defaultValue = "1")Integer page){
        Page<Block> blocks = blockService.getPage(page);
        List<JSONObject> collect = blocks.stream().map(block -> {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("height",block.getHeight());
            jsonObject.put("blockhash",block.getBlockhash());
            jsonObject.put("mined",block.getMined());
            jsonObject.put("time",block.getTime());
            jsonObject.put("size",block.getSizeOndisk());
            return jsonObject;
        }).collect(Collectors.toList());
        PageDto<JSONObject> objectPageDto = new PageDto<>();
        objectPageDto.setList(collect);
        objectPageDto.setTotal(blocks.getTotal());
        objectPageDto.setPageSize(blocks.getPageSize());
        objectPageDto.setCurrentPage(blocks.getPageNum());

        return objectPageDto;
    }
    @GetMapping("/getBlockByHash")
    public JSONObject getBlockByHash(@RequestParam String blockhash){
        JSONObject jsonObject = new JSONObject();
        Block block = blockService.getblockDetailByHash(blockhash);
        jsonObject.put("blockhash",block.getBlockhash());
        jsonObject.put("confirmations",null);
        jsonObject.put("time",block.getTime());
        jsonObject.put("height",block.getHeight());
        jsonObject.put("mined",block.getMined());
        jsonObject.put("txSize",block.getTxSize());
        jsonObject.put("difficulty",block.getDifficulty());
        jsonObject.put("bits",block.getBits());
        jsonObject.put("weight",block.getWeight());

        jsonObject.put("markle_root",block.getMarkle_root());
        jsonObject.put("nonce",block.getNonce());
        jsonObject.put("version",block.getVersion());
        jsonObject.put("txSize",block.getTxSize());
        jsonObject.put("sizeOndisk",block.getSizeOndisk());
        jsonObject.put("feereword",block.getFeereword());
        jsonObject.put("blockreword",block.getBlockreword());


        List<Trans> trans = transService.selectAllByBlockhash(block.getBlockid());
        List<JSONObject> collect = trans.stream().map(trans1 -> {
            JSONObject jsonObject1 = new JSONObject();
            jsonObject1.put("txId", trans1.getTxId());
            jsonObject1.put("txHash", trans1.getTxHash());
            jsonObject1.put("time", trans1.getTime());
            jsonObject1.put("fee", trans1.getFee());

            jsonObject1.put("total_output", trans1.getTotal_output());


            //
            List<TransDetail> TransDetails = transDetailService.getTransDetailId(trans1.getTransId());
            TransDetails.stream().map(transDetail -> {
                JSONObject TDjson = new JSONObject();
                TDjson.put("address",transDetail.getAddress());
                TDjson.put("amount",transDetail.getAmount());
                TDjson.put("type",Math.abs(transDetail.getType()) );
                return TDjson;
            }).collect(Collectors.toList());
            return jsonObject1;
        }).collect(Collectors.toList());
        return jsonObject;
    }

    @GetMapping("/getBlockByHeight")
    public Block getBlockByHeight(@RequestParam Integer height){
        return blockMapper.getblockDetailByHeight(height);

    }
}
