package com.example.feiyang.entity;

//import javafx.geometry.Pos;

import java.util.Date;

/**
 * @author 望舒
 * @date 2022/5/25 20:38
 */

public class PostAndQuestion {
    private Long postId;
    private String postContent;
    private Date createTime;
    private Integer viewCount;
    private String questionContent;
    private String username;
    private String avatarUrl;

    public PostAndQuestion() {

    }

    public PostAndQuestion(Long postId, String postContent, Date createTime, Integer viewCount, String questionContent, String username, String avatarUrl) {
        this.postId = postId;
        this.postContent = postContent;
        this.createTime = createTime;
        this.viewCount = viewCount;
        this.questionContent = questionContent;
        this.username = username;
        this.avatarUrl = avatarUrl;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
}
