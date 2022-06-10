package com.example.feiyang.entity;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {
    private Long orderId;

    private Long userId;

    private Long staffId;

    private Date createTime;

    private Date receiveTime;

    private Date closeTime;

    private String buyTime;

    private String deviceType;

    private String deviceBrand;

    private String deviceVersion;

    private String repairType;

    private String repairInstruction;

    private String repairImage;

    private String guaranteeStatus;

    private String cancelReason;

    private Integer status;

    private static final long serialVersionUID = 1L;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getStaffId() {
        return staffId;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }

    public Date getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
    }

    public String getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(String buyTime) {
        this.buyTime = buyTime;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType == null ? null : deviceType.trim();
    }

    public String getDeviceBrand() {
        return deviceBrand;
    }

    public void setDeviceBrand(String deviceBrand) {
        this.deviceBrand = deviceBrand == null ? null : deviceBrand.trim();
    }

    public String getDeviceVersion() {
        return deviceVersion;
    }

    public void setDeviceVersion(String deviceVersion) {
        this.deviceVersion = deviceVersion == null ? null : deviceVersion.trim();
    }

    public String getRepairType() {
        return repairType;
    }

    public void setRepairType(String repairType) {
        this.repairType = repairType == null ? null : repairType.trim();
    }

    public String getRepairInstruction() {
        return repairInstruction;
    }

    public void setRepairInstruction(String repairInstruction) {
        this.repairInstruction = repairInstruction == null ? null : repairInstruction.trim();
    }

    public String getRepairImage() {
        return repairImage;
    }

    public void setRepairImage(String repairImage) {
        this.repairImage = repairImage == null ? null : repairImage.trim();
    }

    public String getGuaranteeStatus() {
        return guaranteeStatus;
    }

    public void setGuaranteeStatus(String guaranteeStatus) {
        this.guaranteeStatus = guaranteeStatus == null ? null : guaranteeStatus.trim();
    }

    public String getCancelReason() {
        return cancelReason;
    }

    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason == null ? null : cancelReason.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", orderId=").append(orderId);
        sb.append(", userId=").append(userId);
        sb.append(", staffId=").append(staffId);
        sb.append(", createTime=").append(createTime);
        sb.append(", receiveTime=").append(receiveTime);
        sb.append(", closeTime=").append(closeTime);
        sb.append(", buyTime=").append(buyTime);
        sb.append(", deviceType=").append(deviceType);
        sb.append(", deviceBrand=").append(deviceBrand);
        sb.append(", deviceVersion=").append(deviceVersion);
        sb.append(", repairType=").append(repairType);
        sb.append(", repairInstruction=").append(repairInstruction);
        sb.append(", repairImage=").append(repairImage);
        sb.append(", guaranteeStatus=").append(guaranteeStatus);
        sb.append(", cancelReason=").append(cancelReason);
        sb.append(", status=").append(status);
        sb.append("]");
        return sb.toString();
    }
}