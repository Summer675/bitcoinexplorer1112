package com.msy.block1112.dao;


import com.alibaba.fastjson.JSONObject;
import com.msy.block1112.dto.TransListDto;
import com.msy.block1112.po.Trans;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.security.PermitAll;
import java.util.List;

public interface TransMapper {
    int insert(Trans record);

    int insertSelective(Trans record);

    List<JSONObject> list(Integer sizeOndisk);

    JSONObject getTransByTxhash(String txhash);

    //拿某个区块下的所有交易  外键
    List<Trans> selectAllByBlockhash(@Param("block_id") Integer block_id);
}