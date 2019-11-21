package com.msy.block1112.scheduler;

import com.alibaba.fastjson.JSONObject;
import com.msy.block1112.client.BitcoinRest;
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
    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BitcoinRest bitcoinRest;

    private JSONObject originMempoolTx = new JSONObject();

    private List<JSONObject> deltaTxes = new LinkedList<>();
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;
/*
    @Scheduled(cron = "${bitcoin.sync.interval}")
    public void sDate(){
        logger.info("sync bitcoin date");
    }
*/

    @Scheduled(cron = "${bitcoin.syncMempoolTx.interval}")
    public void syncMempoolTx(){
        logger.info("begin sync mempool tx");

        JSONObject newMempoolTx = bitcoinRest.getMempoolContents();

        int originSize = originMempoolTx.size();
        int newSize = newMempoolTx.size();
        if (newSize <= originSize){
            return;
        }

        for (Map.Entry<String, Object> entry : newMempoolTx.entrySet()) {
            String key = entry.getKey();
            if (!originMempoolTx.containsKey(key)){
                JSONObject addJson = newMempoolTx.getJSONObject(key);
                addJson.put("txid", key);
                deltaTxes.add(addJson);
            }
        }
        logger.info("delta tx: {}", deltaTxes);
        logger.info("delta size: {}", deltaTxes.size());

        List<JSONObject> deltaTxesJsons = deltaTxes.stream().map(t -> {
            JSONObject tJson = new JSONObject();
            tJson.put("txid", t.getString("txid"));
            tJson.put("wtxid", t.getString("wtxid"));
            tJson.put("time", t.getLong("time"));
          

            return tJson;
        }).collect(Collectors.toList());
        List<JSONObject> sortedDeltaTxesJsons = deltaTxesJsons.stream().sorted(Comparator.comparingLong(t -> t.getLong("time"))).collect(Collectors.toList());
        simpMessagingTemplate.convertAndSend("/bitcoin/deltaTx", sortedDeltaTxesJsons);

        deltaTxes = new LinkedList<>();
        originMempoolTx = newMempoolTx;

        logger.info("end sync mempool tx");
    }
}
