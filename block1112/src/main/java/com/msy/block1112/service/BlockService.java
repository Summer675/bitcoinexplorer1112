package com.msy.block1112.service;

import org.springframework.scheduling.annotation.Async;

public interface BlockService {

    String syncBlock(String blockhash);

    @Async
    void sBlocks(String fromBlockhash);
}
