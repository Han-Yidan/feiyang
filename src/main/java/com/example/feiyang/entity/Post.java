package com.example.feiyang.entity;

import java.io.Serializable;
import java.util.Date;

public class Post implements Serializable {
    private Long postId;

    private Long userId;

    private Long relatedQuestionId;

    private Date createTime;

    private Integer visitCount;

    private Integer status;

    private String postContent;

    private static final long serialVersionUID = 1L;

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRelatedQuestionId() {
        return relatedQuestionId;
    }

    public void setRelatedQuestionId(Long relatedQuestionId) {
        this.relatedQuestionId = relatedQuestionId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(Integer visitCount) {
        this.visitCount = visitCount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent == null ? null : postContent.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", postId=").append(postId);
        sb.append(", userId=").append(userId);
        sb.append(", relatedQuestionId=").append(relatedQuestionId);
        sb.append(", createTime=").append(createTime);
        sb.append(", visitCount=").append(visitCount);
        sb.append(", status=").append(status);
        sb.append(", postContent=").append(postContent);
        sb.append("]");
        return sb.toString();
    }
}