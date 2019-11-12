package com.msy.block1112.dao;

import com.msy.block1112.po.Trans;

public interface TransMapper {
    int insert(Trans record);

    int insertSelective(Trans record);
}