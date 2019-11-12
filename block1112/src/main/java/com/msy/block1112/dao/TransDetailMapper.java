package com.msy.block1112.dao;

import com.msy.block1112.po.TransDetail;

public interface TransDetailMapper {
    int deleteByPrimaryKey(Long txDetailId);

    int insert(TransDetail record);

    int insertSelective(TransDetail record);

    TransDetail selectByPrimaryKey(Long txDetailId);

    int updateByPrimaryKeySelective(TransDetail record);

    int updateByPrimaryKey(TransDetail record);
}