package com.example.feiyang.entity;

//import javafx.geometry.Pos;

import java.util.Date;

/**
 * @author 望舒
 * @date 2022/5/25 20:38
 */

public class PostAndQuestion {
    private Long post_id;
    private String post_content;
    private Date create_time;
    private Integer visit_count;
    private String question_content;
    private String username;
    private String avatar_url;

    public PostAndQuestion() {

    }

    public PostAndQuestion(Long post_id, String post_content, Date create_time, Integer visit_count, String question_content, String username, String avatar_url) {
        this.post_id = post_id;
        this.post_content = post_content;
        this.create_time = create_time;
        this.visit_count = visit_count;
        this.question_content = question_content;
        this.username = username;
        this.avatar_url = avatar_url;
    }

    public Long getPost_id() {
        return post_id;
    }

    public void setPost_id(Long post_id) {
        this.post_id = post_id;
    }

    public String getPost_content() {
        return post_content;
    }

    public void setPost_content(String post_content) {
        this.post_content = post_content;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Integer getVisit_count() {
        return visit_count;
    }

    public void setVisit_count(Integer visit_count) {
        this.visit_count = visit_count;
    }

    public String getQuestion_content() {
        return question_content;
    }

    public void setQuestion_content(String question_content) {
        this.question_content = question_content;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    @Override
    public String toString() {
        return "PostAndQuestion{" +
                "post_id=" + post_id +
                ", post_content='" + post_content + '\'' +
                ", create_time=" + create_time +
                ", visit_count=" + visit_count +
                ", question_content='" + question_content + '\'' +
                ", username='" + username + '\'' +
                ", avatar_url='" + avatar_url + '\'' +
                '}';
    }
}
