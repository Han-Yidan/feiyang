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
    private Long post_user;
    private Integer visit_count;
    private Date post_time;
    private Integer score;
    private Long question_id;
    private String question_content;
    private String question_image;
    private Long question_user;
    private Date question_time;
    private String post_username;
    private String post_avatar;
    private String question_username;
    private String question_avatar;

    public PostAndQuestion() {

    }

    public PostAndQuestion(Long post_id, String post_content, Long post_user, Integer visit_count, Date post_time, Integer score, Long question_id, String question_content, String question_image, Long question_user, Date question_time, String post_username, String post_avatar, String question_username, String question_avatar) {
        this.post_id = post_id;
        this.post_content = post_content;
        this.post_user = post_user;
        this.visit_count = visit_count;
        this.post_time = post_time;
        this.score = score;
        this.question_id = question_id;
        this.question_content = question_content;
        this.question_image = question_image;
        this.question_user = question_user;
        this.question_time = question_time;
        this.post_username = post_username;
        this.post_avatar = post_avatar;
        this.question_username = question_username;
        this.question_avatar = question_avatar;
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

    public Long getPost_user() {
        return post_user;
    }

    public void setPost_user(Long post_user) {
        this.post_user = post_user;
    }

    public Integer getVisit_count() {
        return visit_count;
    }

    public void setVisit_count(Integer visit_count) {
        this.visit_count = visit_count;
    }

    public Date getPost_time() {
        return post_time;
    }

    public void setPost_time(Date post_time) {
        this.post_time = post_time;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Long getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(Long question_id) {
        this.question_id = question_id;
    }

    public String getQuestion_content() {
        return question_content;
    }

    public void setQuestion_content(String question_content) {
        this.question_content = question_content;
    }

    public String getQuestion_image() {
        return question_image;
    }

    public void setQuestion_image(String question_image) {
        this.question_image = question_image;
    }

    public Long getQuestion_user() {
        return question_user;
    }

    public void setQuestion_user(Long question_user) {
        this.question_user = question_user;
    }

    public Date getQuestion_time() {
        return question_time;
    }

    public void setQuestion_time(Date question_time) {
        this.question_time = question_time;
    }

    public String getPost_username() {
        return post_username;
    }

    public void setPost_username(String post_username) {
        this.post_username = post_username;
    }

    public String getPost_avatar() {
        return post_avatar;
    }

    public void setPost_avatar(String post_avatar) {
        this.post_avatar = post_avatar;
    }

    public String getQuestion_username() {
        return question_username;
    }

    public void setQuestion_username(String question_username) {
        this.question_username = question_username;
    }

    public String getQuestion_avatar() {
        return question_avatar;
    }

    public void setQuestion_avatar(String question_avatar) {
        this.question_avatar = question_avatar;
    }

    @Override
    public String toString() {
        return "PostAndQuestion{" +
                "post_id=" + post_id +
                ", post_content='" + post_content + '\'' +
                ", post_user=" + post_user +
                ", visit_count=" + visit_count +
                ", post_time=" + post_time +
                ", score=" + score +
                ", question_id=" + question_id +
                ", question_content='" + question_content + '\'' +
                ", question_image='" + question_image + '\'' +
                ", question_user=" + question_user +
                ", question_time=" + question_time +
                ", post_username='" + post_username + '\'' +
                ", post_avatar='" + post_avatar + '\'' +
                ", question_username='" + question_username + '\'' +
                ", question_avatar='" + question_avatar + '\'' +
                '}';
    }
}
