package com.example.feiyang.entity;

import java.io.Serializable;

public class Tips implements Serializable {
    private Integer isPop;

    private String title;

    private String tips;

    private static final long serialVersionUID = 1L;

    public Integer getIsPop() {
        return isPop;
    }

    public void setIsPop(Integer isPop) {
        this.isPop = isPop;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
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
        sb.append(", isPop=").append(isPop);
        sb.append(", title=").append(title);
        sb.append(", tips=").append(tips);
        sb.append("]");
        return sb.toString();
    }
}