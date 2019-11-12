package com.msy.block1112.po;

public class TransDetail {
    private Long txDetailId;

    private Integer transid;

    private String address;

    private Double amount;

    private Byte type;

    public Long getTxDetailId() {
        return txDetailId;
    }

    public void setTxDetailId(Long txDetailId) {
        this.txDetailId = txDetailId;
    }

    public Integer getTransid() {
        return transid;
    }

    public void setTransid(Integer transid) {
        this.transid = transid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }
}