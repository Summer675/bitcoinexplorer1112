package com.msy.block1112.scheduler;

import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;


@Component
public class BitcoinScheduler {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Scheduled(cron = "${bitcoin.sync.interval}")
    public void sDate(){
        logger.info("sync bitcoin date");
    }
}
