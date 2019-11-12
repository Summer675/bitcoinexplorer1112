package com.msy.block1112.dao;

import com.msy.block1112.po.Block;

public interface BlockMapper {
    int insert(Block record);

    int insertSelective(Block record);
}