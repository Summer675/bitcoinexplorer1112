package com.msy.block1112.po;

public class Trans {
    private Integer transId;

    private Integer block_id;

    private String txHash;

    private Double amount;



    private Double total_input;

    private Double total_output;

    private Long time;

    private Integer confirmations;

    private Byte status;

    private Integer weight;

    private Double fee;

    private Double fee_per_weight;

    private Double fee_per_byte;

    private Integer sizeOndisk;

    public Integer getTransId() {
        return transId;
    }

    public void setTransId(Integer transId) {
        this.transId = transId;
    }

    public Integer getBlock_id() {
        return block_id;
    }

    public void setBlock_id(Integer block_id) {
        this.block_id = block_id;
    }

    public String getTxHash() {
        return txHash;
    }

    public void setTxHash(String txHash) {
        this.txHash = txHash;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getTotal_input() {
        return total_input;
    }

    public void setTotal_input(Double total_input) {
        this.total_input = total_input;
    }

    public Double getTotal_output() {
        return total_output;
    }

    public void setTotal_output(Double total_output) {
        this.total_output = total_output;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Integer getConfirmations() {
        return confirmations;
    }

    public void setConfirmations(Integer confirmations) {
        this.confirmations = confirmations;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public Double getFee_per_weight() {
        return fee_per_weight;
    }

    public void setFee_per_weight(Double fee_per_weight) {
        this.fee_per_weight = fee_per_weight;
    }

    public Double getFee_per_byte() {
        return fee_per_byte;
    }

    public void setFee_per_byte(Double fee_per_byte) {
        this.fee_per_byte = fee_per_byte;
    }

    public Integer getSizeOndisk() {
        return sizeOndisk;
    }

    public void setSizeOndisk(Integer sizeOndisk) {
        this.sizeOndisk = sizeOndisk;
    }
}