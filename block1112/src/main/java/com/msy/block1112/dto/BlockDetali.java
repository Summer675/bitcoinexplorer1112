package com.msy.block1112.dto;

public class BlockDetali {
    private Integer height;



    private String blockHash;

    private String mined;

    private Integer size;

    private Long time;

    private Integer confirmations;

    private Double difficulty;

    private Integer bits;

    private Integer weight;

    private String markleRoot;

    private String nonce;

    private String version;

    private Integer txsize;

    private Integer sizeondisk;

    private Double feereword;

    private Double blockreword;

    private Double transactionvolume;

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }



    public String getBlockHash() {
        return blockHash;
    }

    public void setBlockHash(String blockHash) {
        this.blockHash = blockHash == null ? null : blockHash.trim();
    }

    public String getMined() {
        return mined;
    }

    public void setMined(String mined) {
        this.mined = mined == null ? null : mined.trim();
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
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

    public Double getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Double difficulty) {
        this.difficulty = difficulty;
    }

    public Integer getBits() {
        return bits;
    }

    public void setBits(Integer bits) {
        this.bits = bits;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getMarkleRoot() {
        return markleRoot;
    }

    public void setMarkleRoot(String markleRoot) {
        this.markleRoot = markleRoot == null ? null : markleRoot.trim();
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce == null ? null : nonce.trim();
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    public Integer getTxsize() {
        return txsize;
    }

    public void setTxsize(Integer txsize) {
        this.txsize = txsize;
    }

    public Integer getSizeondisk() {
        return sizeondisk;
    }

    public void setSizeondisk(Integer sizeondisk) {
        this.sizeondisk = sizeondisk;
    }

    public Double getFeereword() {
        return feereword;
    }

    public void setFeereword(Double feereword) {
        this.feereword = feereword;
    }

    public Double getBlockreword() {
        return blockreword;
    }

    public void setBlockreword(Double blockreword) {
        this.blockreword = blockreword;
    }

    public Double getTransactionvolume() {
        return transactionvolume;
    }

    public void setTransactionvolume(Double transactionvolume) {
        this.transactionvolume = transactionvolume;
    }

}
