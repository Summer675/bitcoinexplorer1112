package com.msy.block1112.service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.msy.block1112.po.Block;
import org.apache.ibatis.annotations.Param;
import org.springframework.scheduling.annotation.Async;

import java.util.List;

public interface BlockService {

    String syncBlock(String blockhash);

    @Async
    void sBlocks(String fromBlockhash);
    Page<Block> getPage(Integer page);

    List<Block> select();
    Block getblockDetailByHash(@Param("blockhash") String blockhash);

    Block getblockDetailByHeight(Integer height);

    String getBlockhashByHeight(Integer height);

}
