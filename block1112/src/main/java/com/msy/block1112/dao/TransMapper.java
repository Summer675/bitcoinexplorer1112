package com.msy.block1112.dao;


import com.msy.block1112.dto.TransListDto;
import com.msy.block1112.po.Trans;

import java.util.List;

public interface TransMapper {
    int insert(Trans record);

    int insertSelective(Trans record);

    List<Trans> list();

    TransListDto getTransByTxhash(String txhash);
}