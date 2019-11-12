package com.msy.block1112.dao;

import com.msy.block1112.po.Block;
import org.apache.ibatis.annotations.Param;
import org.w3c.dom.ls.LSInput;

import java.util.List;

public interface BlockMapper {
    int insert(Block record);

    int insertSelective(Block record);

    List<Block> list();

    List<Block> getblockDetailByHash(@Param("blockHash") String blockHash);

    List<Block> getblockDetailByHeight(Integer height);
}