package com.example.feiyang.service;

import com.example.feiyang.entity.Post;

import java.util.Map;

public interface PostService {
    /**
     * 修改帖子审核状态
     *
     * @param postId
     * @return
     */
    Post updatePostStatus(Integer postId);

    /**
     * 添加帖子
     *
     * @param params
     * @return
     */
    Post addPost(Map<String, Object> params);

    /**
     * 删除帖子
     *
     * @param postId
     */
    void deletePost(Integer postId);

    /**
     * 按条件查看所有帖子
     *
     * @param userId
     * @param relatedQuestionId
     * @return
     */
    Map<String, Object> selectAllByCondition(Integer userId, Long relatedQuestionId);

}
