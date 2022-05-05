package com.example.feiyang.entity;

import java.io.Serializable;
import java.util.Date;

public class Post implements Serializable {
    private Integer postId;

    private Integer userId;

    private Long relatedQuestionId;

    private Date createTime;

    private Integer likeCount;

    private Integer status;

    private String postContent;

    private static final long serialVersionUID = 1L;

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
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

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
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
        sb.append(", likeCount=").append(likeCount);
        sb.append(", status=").append(status);
        sb.append(", postContent=").append(postContent);
        sb.append("]");
        return sb.toString();
    }
}