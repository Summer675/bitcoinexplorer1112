package com.msy.block1112.service.imp;

import com.alibaba.fastjson.JSONObject;
import com.msy.block1112.client.BitcoinRest;
import com.msy.block1112.dao.BlockMapper;
import com.msy.block1112.po.Block;
import com.msy.block1112.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlockServiceImp implements BlockService {

    @Autowired
    private BlockMapper blockMapper;

    @Autowired
    private BitcoinRest bitcoinRest;

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
        String tempBlockhash = fromBlockhash;
        while (tempBlockhash != null){
            tempBlockhash = syncBlock(tempBlockhash);
        }
    }

}
