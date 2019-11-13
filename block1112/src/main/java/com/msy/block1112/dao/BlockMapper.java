package com.msy.block1112.dao;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.msy.block1112.po.Block;
import org.apache.ibatis.annotations.Param;
import org.w3c.dom.ls.LSInput;

import java.util.List;

public interface BlockMapper {
    int insert(Block record);

    int insertSelective(Block record);

    Page<JSONObject> list();



    JSONObject getblockDetailByHash(@Param("blockhash") String blockhash);

    JSONObject getblockDetailByHeight(Integer height);
}