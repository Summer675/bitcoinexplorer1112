package com.msy.block1112.service;

import com.github.pagehelper.Page;
import com.msy.block1112.po.Trans;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TransService {
    void sTrans(String txid, Integer blockId, Long time) throws Throwable;
    List<Trans> selectAllByBlockhash( Integer block_id);
    Page<Trans> selectByBlockIdWithPage(Integer block_id,Integer page);
    Trans getByTxId(String txId);

}
