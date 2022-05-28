package com.example.feiyang.service;

import com.example.feiyang.entity.PageRequest;
import com.example.feiyang.entity.PageResult;
import com.example.feiyang.entity.Post;
import com.example.feiyang.entity.PostAndQuestion;

import java.util.List;
import java.util.Map;

public interface PostService {
    /**
     * 修改帖子审核状态
     *
     * @param postId
     * @return
     */
    Post updatePostStatus(Long postId);

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
    void deletePost(Long postId);

    /**
     * 按条件查看所有帖子
     *
     * @param userId
     * @param relatedQuestionId
     * @return
     */
    Map<String, Object> selectAllByCondition(Long userId, Long relatedQuestionId);

    /**
     * 分页获取所有帖子及关联问题
     * @return
     */
    public List<PostAndQuestion> getAllPostAndQuestions(Integer pageNum, Integer pageSize);

    /**
     * 获取未审核的帖子
     * @return
     */
    public List<PostAndQuestion> getNoExamine();

    /**
     * 获取帖子总数
     * @return
     */
    public Integer getPostNum();
}
