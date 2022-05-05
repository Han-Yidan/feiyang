package com.example.feiyang.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private Long userId;

    private String username;

    private String qqNumber;

    private String phoneNumber;

    private Integer isVip;

    private Integer isBan;

    private String sessionId;

    private String code;

    private String email;

    private Long vipId;

    private Integer init;

    private Date createTime;

    private String avatarUrl;

    private Integer restRepairChance;

    private Integer isStaff;

    private static final long serialVersionUID = 1L;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getQqNumber() {
        return qqNumber;
    }

    public void setQqNumber(String qqNumber) {
        this.qqNumber = qqNumber == null ? null : qqNumber.trim();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    public Integer getIsVip() {
        return isVip;
    }

    public void setIsVip(Integer isVip) {
        this.isVip = isVip;
    }

    public Integer getIsBan() {
        return isBan;
    }

    public void setIsBan(Integer isBan) {
        this.isBan = isBan;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId == null ? null : sessionId.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Long getVipId() {
        return vipId;
    }

    public void setVipId(Long vipId) {
        this.vipId = vipId;
    }

    public Integer getInit() {
        return init;
    }

    public void setInit(Integer init) {
        this.init = init;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl == null ? null : avatarUrl.trim();
    }

    public Integer getRestRepairChance() {
        return restRepairChance;
    }

    public void setRestRepairChance(Integer restRepairChance) {
        this.restRepairChance = restRepairChance;
    }

    public Integer getIsStaff() {
        return isStaff;
    }

    public void setIsStaff(Integer isStaff) {
        this.isStaff = isStaff;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", username=").append(username);
        sb.append(", qqNumber=").append(qqNumber);
        sb.append(", phoneNumber=").append(phoneNumber);
        sb.append(", isVip=").append(isVip);
        sb.append(", isBan=").append(isBan);
        sb.append(", sessionId=").append(sessionId);
        sb.append(", code=").append(code);
        sb.append(", email=").append(email);
        sb.append(", vipId=").append(vipId);
        sb.append(", init=").append(init);
        sb.append(", createTime=").append(createTime);
        sb.append(", avatarUrl=").append(avatarUrl);
        sb.append(", restRepairChance=").append(restRepairChance);
        sb.append(", isStaff=").append(isStaff);
        sb.append("]");
        return sb.toString();
    }
}