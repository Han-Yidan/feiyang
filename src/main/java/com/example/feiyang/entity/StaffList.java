package com.example.feiyang.entity;

public class StaffList {
    private Long userId;
    private Integer score;
    private String username;
    private String avatarUrl;

    public StaffList(Long userId, String username, String avatarUrl, Integer score) {
        this.userId = userId;
        this.score = score;
        this.username = username;
        this.avatarUrl = avatarUrl;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
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

    @Override
    public String toString() {
        return "StaffList{" +
                "userId=" + userId +
                ", score=" + score +
                ", username='" + username + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                '}';
    }
}
