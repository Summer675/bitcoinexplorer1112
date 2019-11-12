package com.msy.block1112.po;

public class Trans {
    private Integer txid;

    private String blkid;

    private String txhash;

    private Integer version;

    private Long inputcount;

    private Long outputcount;

    private Long totaloutamount;

    private Long totalinamount;

    private Long transfee;

    private Boolean iscoinbase;

    private Boolean isheightlock;

    private Boolean istimelock;

    private Integer locktimevalue;

    public Integer getTxid() {
        return txid;
    }

    public void setTxid(Integer txid) {
        this.txid = txid;
    }

    public String getBlkid() {
        return blkid;
    }

    public void setBlkid(String blkid) {
        this.blkid = blkid == null ? null : blkid.trim();
    }

    public String getTxhash() {
        return txhash;
    }

    public void setTxhash(String txhash) {
        this.txhash = txhash == null ? null : txhash.trim();
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Long getInputcount() {
        return inputcount;
    }

    public void setInputcount(Long inputcount) {
        this.inputcount = inputcount;
    }

    public Long getOutputcount() {
        return outputcount;
    }

    public void setOutputcount(Long outputcount) {
        this.outputcount = outputcount;
    }

    public Long getTotaloutamount() {
        return totaloutamount;
    }

    public void setTotaloutamount(Long totaloutamount) {
        this.totaloutamount = totaloutamount;
    }

    public Long getTotalinamount() {
        return totalinamount;
    }

    public void setTotalinamount(Long totalinamount) {
        this.totalinamount = totalinamount;
    }

    public Long getTransfee() {
        return transfee;
    }

    public void setTransfee(Long transfee) {
        this.transfee = transfee;
    }

    public Boolean getIscoinbase() {
        return iscoinbase;
    }

    public void setIscoinbase(Boolean iscoinbase) {
        this.iscoinbase = iscoinbase;
    }

    public Boolean getIsheightlock() {
        return isheightlock;
    }

    public void setIsheightlock(Boolean isheightlock) {
        this.isheightlock = isheightlock;
    }

    public Boolean getIstimelock() {
        return istimelock;
    }

    public void setIstimelock(Boolean istimelock) {
        this.istimelock = istimelock;
    }

    public Integer getLocktimevalue() {
        return locktimevalue;
    }

    public void setLocktimevalue(Integer locktimevalue) {
        this.locktimevalue = locktimevalue;
    }
}