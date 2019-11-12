package com.msy.block1112.dto;

import java.util.Date;

public class TransListDto {
    private Integer txid;
    private String txhash;

    private Date time;

    private Double amount;

    public Integer getTxid() {
        return txid;
    }

    public void setTxid(Integer txid) {
        this.txid = txid;
    }

    public String getTxhash() {
        return txhash;
    }

    public void setTxhash(String txhash) {
        this.txhash = txhash;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
