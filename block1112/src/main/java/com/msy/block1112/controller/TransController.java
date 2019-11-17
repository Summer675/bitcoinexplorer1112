package com.msy.block1112.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.msy.block1112.changliang.ChangLiang;
import com.msy.block1112.dao.TransMapper;
import com.msy.block1112.dto.PageDto;
import com.msy.block1112.dto.TransListDto;
import com.msy.block1112.po.Block;
import com.msy.block1112.po.Trans;
import com.msy.block1112.po.TransDetail;
import com.msy.block1112.service.BlockService;
import com.msy.block1112.service.TransDetailService;
import com.msy.block1112.service.TransService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@EnableAutoConfiguration
@RequestMapping("/trans")
public class TransController {
    @Autowired
    private BlockService blockService;

    @Autowired
    private TransService transService;
    @Autowired
    private TransMapper transMapper;
    @Autowired
    private TransDetailService transDetailService;
    @GetMapping("/getConfirmed")
    public List<JSONObject> list(@RequestParam(required = false,defaultValue = "20") Integer sizeOndisk){
        return transMapper.list(sizeOndisk);
    }
    @GetMapping("/getTransByTxhash")
    public JSONObject getTransByTxhash(@RequestParam String txhash){
        return transMapper.getTransByTxhash(txhash);
    }

    public PageDto<JSONObject> getAllbyhashWithPAge(@RequestParam String blockhash,
                                                    @RequestParam(defaultValue = "1",required = false) Integer page){
        Block block = blockService.getblockDetailByHash(blockhash);
        Integer blockid = block.getBlockid();
        Page<Trans> pageinfo = transService.selectByBlockIdWithPage(blockid, page);

        List<JSONObject> TxJsons = pageinfo.stream().map(trans1 -> {
            JSONObject jsonObject1 = new JSONObject();
            jsonObject1.put("txId", trans1.getTxId());
            jsonObject1.put("txHash", trans1.getTxHash());
            jsonObject1.put("time", trans1.getTime());
            jsonObject1.put("fee", trans1.getFee());

            jsonObject1.put("total_output", trans1.getTotal_output());
            //
            List<TransDetail> TransDetails = transDetailService.getTransDetailId(trans1.getTransId());
            List<JSONObject> txjson = TransDetails.stream().map(transDetail -> {
                JSONObject TDjson = new JSONObject();
                TDjson.put("address", transDetail.getAddress());
                TDjson.put("amount", transDetail.getAmount());
                TDjson.put("type", Math.abs(transDetail.getType()));
                return TDjson;
            }).collect(Collectors.toList());

            jsonObject1.put("TransDetails",txjson);
            return jsonObject1;
        }).collect(Collectors.toList());

        PageDto<JSONObject> objectPageDto = new PageDto<>();
        objectPageDto.setTotal(pageinfo.getTotal());
        objectPageDto.setPageSize(ChangLiang.PAGE_SIZE);
        objectPageDto.setCurrentPage(pageinfo.getPageNum());
        objectPageDto.setList(TxJsons);
    return objectPageDto;
    }


    @GetMapping("/getBytxId")
    public JSONObject getByTxid(@RequestParam String txid){
        Trans byTxId = transService.getByTxId(txid);
        JSONObject jsonObject = new JSONObject();
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("txId", byTxId.getTxId());
        jsonObject1.put("txHash", byTxId.getTxHash());
        jsonObject1.put("time", byTxId.getTime());
        jsonObject1.put("fee", byTxId.getFee());
        jsonObject1.put("total_output", byTxId.getTotal_output());
        List<TransDetail> TransDetails = transDetailService.getTransDetailId(byTxId.getTransId());
        List<JSONObject> txjson = TransDetails.stream().map(transDetail -> {
            JSONObject TDjson = new JSONObject();
            TDjson.put("address", transDetail.getAddress());
            TDjson.put("amount", transDetail.getAmount());
            TDjson.put("type", Math.abs(transDetail.getType()));
            return TDjson;
        }).collect(Collectors.toList());

        jsonObject1.put("TransDetails",txjson);
        return jsonObject;
    }
}
