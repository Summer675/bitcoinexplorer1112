package com.msy.block1112.service.imp;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.msy.block1112.client.BitcoinRest;
import com.msy.block1112.dao.BlockMapper;
import com.msy.block1112.po.Block;
import com.msy.block1112.service.BlockService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;

import java.util.List;

@Service
public class BlockServiceImp implements BlockService {

    @Autowired
    private BlockMapper blockMapper;

    @Autowired
    private BitcoinRest bitcoinRest;
    public Logger logger=  LoggerFactory.getLogger(this.getClass());
    @Override
    public String syncBlock(String blockhash) {
        JSONObject blockJson = bitcoinRest.getblockNotxDetail(blockhash);
        Block block = new Block();
        block.setBlockhash(blockJson.getString("hash"));
        block.setConfirmations(blockJson.getInteger("confirmations"));
        block.setHeight(blockJson.getInteger("height"));
        block.setTime(blockJson.getLong("time"));
        block.setDifficulty(blockJson.getDouble("difficulty"));
        block.setSizeOndisk(blockJson.getInteger("size"));
        block.setMarkle_root(blockJson.getString("merkleroot"));
        block.setTxSize(blockJson.getInteger("nTx"));
        block.setVersion(blockJson.getString("versionHex"));
        block.setNonce(blockJson.getInteger("nonce").toString());
        block.setWeight(blockJson.getInteger("weight"));
        blockMapper.insert(block);
        String nextblockhash = blockJson.getString("nextblockhash");
        return nextblockhash;
    }

    @Override
    public void sBlocks(String fromBlockhash) {
        logger.info("开始 sysn block");
        String tempBlockhash = fromBlockhash;
        while (tempBlockhash != null){
            tempBlockhash = syncBlock(tempBlockhash);
        }
        logger.info("结束 sysn block");
    }

    @Override
    public Page<Block> getPage(Integer page) {
        PageHelper.startPage(page,20);
        Page<Block> blocks = blockMapper.getpage();

        return blocks;
    }

    @Override
    public List<Block> select() {
        List<Block> select = blockMapper.select();
        return select;
    }

    @Override
    public Block getblockDetailByHash(String blockhash) {
        Block block = blockMapper.getblockDetailByHash(blockhash);
        return block;
    }

    @Override
    public Block getblockDetailByHeight(Integer height) {
        return null;
    }

}
