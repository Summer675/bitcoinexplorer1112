package com.msy.block1112.scheduler;

import com.alibaba.fastjson.JSONObject;
import com.msy.block1112.client.BitcoinRest;
import com.msy.block1112.service.TransService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Component
public class BitcoinScheduler {
    @Autowired
    private TransService transService;


/*
    @Scheduled(cron = "${bitcoin.sync.interval}")
    public void sDate(){
        logger.info("sync bitcoin date");
    }
*/

    @Scheduled(cron = "${bitcoin.syncMempoolTx.interval}")
    public void syncMempoolTx(){
        transService.pushNewMempoolTxes();
    }
}
