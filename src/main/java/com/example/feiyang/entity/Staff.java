package com.example.feiyang.entity;

import java.io.Serializable;
import java.util.Date;

public class Staff implements Serializable {
    private Long userId;

    private Integer repairCount;

    private Integer postCount;

    private Integer isAllow;

    private Date lastTime;

    private Integer receiveInterval;

    private Integer orderTransfer;

    private String tips;

    private static final long serialVersionUID = 1L;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getRepairCount() {
        return repairCount;
    }

    public void setRepairCount(Integer repairCount) {
        this.repairCount = repairCount;
    }

    public Integer getPostCount() {
        return postCount;
    }

    public void setPostCount(Integer postCount) {
        this.postCount = postCount;
    }

    public Integer getIsAllow() {
        return isAllow;
    }

    public void setIsAllow(Integer isAllow) {
        this.isAllow = isAllow;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    public Integer getReceiveInterval() {
        return receiveInterval;
    }

    public void setReceiveInterval(Integer receiveInterval) {
        this.receiveInterval = receiveInterval;
    }

    public Integer getOrderTransfer() {
        return orderTransfer;
    }

    public void setOrderTransfer(Integer orderTransfer) {
        this.orderTransfer = orderTransfer;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips == null ? null : tips.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", repairCount=").append(repairCount);
        sb.append(", postCount=").append(postCount);
        sb.append(", isAllow=").append(isAllow);
        sb.append(", lastTime=").append(lastTime);
        sb.append(", receiveInterval=").append(receiveInterval);
        sb.append(", orderTransfer=").append(orderTransfer);
        sb.append(", tips=").append(tips);
        sb.append("]");
        return sb.toString();
    }
}