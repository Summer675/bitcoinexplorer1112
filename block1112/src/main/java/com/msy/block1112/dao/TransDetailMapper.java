package com.msy.block1112.dao;

import com.alibaba.fastjson.JSONObject;
import com.msy.block1112.po.Trans;
import com.msy.block1112.po.TransDetail;
import org.apache.ibatis.annotations.Param;

import javax.annotation.security.PermitAll;
import java.util.List;

public interface TransDetailMapper {
    int deleteByPrimaryKey(Long txDetailId);

    int insert(TransDetail record);

    int insertSelective(TransDetail record);

    TransDetail selectByPrimaryKey(Long txDetailId);

    int updateByPrimaryKeySelective(TransDetail record);

    int updateByPrimaryKey(TransDetail record);

    List<TransDetail> list();

    JSONObject getAddress(@Param("address") String address);
}