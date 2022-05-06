package com.example.feiyang.entity;

import java.io.Serializable;
import java.util.Date;

public class Conf implements Serializable {
    private Integer globalFlag;

    private Integer globalYear;

    private Integer globalDay;

    private Integer globalWeek;

    private Integer globalMonth;

    private Date globalTime;

    private Integer limitDay;

    private Integer limitWeek;

    private String globalTips;

    private static final long serialVersionUID = 1L;

    public Integer getGlobalFlag() {
        return globalFlag;
    }

    public void setGlobalFlag(Integer globalFlag) {
        this.globalFlag = globalFlag;
    }

    public Integer getGlobalYear() {
        return globalYear;
    }

    public void setGlobalYear(Integer globalYear) {
        this.globalYear = globalYear;
    }

    public Integer getGlobalDay() {
        return globalDay;
    }

    public void setGlobalDay(Integer globalDay) {
        this.globalDay = globalDay;
    }

    public Integer getGlobalWeek() {
        return globalWeek;
    }

    public void setGlobalWeek(Integer globalWeek) {
        this.globalWeek = globalWeek;
    }

    public Integer getGlobalMonth() {
        return globalMonth;
    }

    public void setGlobalMonth(Integer globalMonth) {
        this.globalMonth = globalMonth;
    }

    public Date getGlobalTime() {
        return globalTime;
    }

    public void setGlobalTime(Date globalTime) {
        this.globalTime = globalTime;
    }

    public Integer getLimitDay() {
        return limitDay;
    }

    public void setLimitDay(Integer limitDay) {
        this.limitDay = limitDay;
    }

    public Integer getLimitWeek() {
        return limitWeek;
    }

    public void setLimitWeek(Integer limitWeek) {
        this.limitWeek = limitWeek;
    }

    public String getGlobalTips() {
        return globalTips;
    }

    public void setGlobalTips(String globalTips) {
        this.globalTips = globalTips == null ? null : globalTips.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", globalFlag=").append(globalFlag);
        sb.append(", globalYear=").append(globalYear);
        sb.append(", globalDay=").append(globalDay);
        sb.append(", globalWeek=").append(globalWeek);
        sb.append(", globalMonth=").append(globalMonth);
        sb.append(", globalTime=").append(globalTime);
        sb.append(", limitDay=").append(limitDay);
        sb.append(", limitWeek=").append(limitWeek);
        sb.append(", globalTips=").append(globalTips);
        sb.append("]");
        return sb.toString();
    }
}