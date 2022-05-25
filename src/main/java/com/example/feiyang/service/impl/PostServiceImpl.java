package com.example.feiyang.service.impl;

import com.example.feiyang.dao.PostMapper;
import com.example.feiyang.dao.StaffMapper;
import com.example.feiyang.dao.UserMapper;
import com.example.feiyang.entity.Post;
import com.example.feiyang.entity.PostExample;
import com.example.feiyang.entity.Staff;
import com.example.feiyang.entity.User;
import com.example.feiyang.service.PostService;
import com.example.feiyang.service.ex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostMapper postMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private StaffMapper staffMapper;

    @Override
    public Post updatePostStatus(Integer postId) {
        //判断帖子是否存在
        Post post = postMapper.selectByPrimaryKey(postId);
        if (post == null) {
            throw new PostNotFoundException("该帖子不存在");
        }
        //修改贴子审核状态
        post.setStatus(1);
        //执行帖子审核
        Integer rows = postMapper.updateByPrimaryKey(post);
        //未知异常
        if (rows != 1) {
            throw new UpdateException("修改审核状态的过程中产生了未知的异常");
        }
        return post;
    }

    @Override
    public Post addPost(Map<String, Object> params) {
        //获取前端传来的帖子信息
        Integer userId = Integer.valueOf(params.get("userId").toString());
        String postContent = params.get("postContent").toString();
        Long relatedQuestionId = Long.valueOf(params.get("relatedQuestionId").toString());

        //判断技术员是否存在
        User userResult = userMapper.selectByPrimaryKey(Long.valueOf(userId));
        if (userResult == null) {
            throw new UserNotFoundException("用户不存在");
        }
        if (userResult.getIsStaff() != 1) {
            throw new StaffNotFoundException("该用户不是技术员");
        }

        //添加一个帖子
        Post post = new Post();
        post.setUserId(userId);
        post.setPostContent(postContent);
        post.setRelatedQuestionId(relatedQuestionId);
        //初始化审核状态status为0，0为未审核，1为已审核。
        post.setStatus(0);
        //初始化创建帖子时间
        Date date = new Date();
        post.setCreateTime(date);

        //执行添加业务功能的实现
        Integer rows = postMapper.insertSelective(post);

        Staff staff = staffMapper.selectByPrimaryKey(Long.valueOf(userId));
        int postCount=  staff.getPostCount();
        int score = staff.getScore();
        staff.setPostCount(postCount+1);
        staff.setScore(score+1);
        staffMapper.updateByPrimaryKeySelective(staff);
        //未知异常
        if (rows != 1) {
            throw new InsertException("技术员在发贴过程中产生了未知的异常");
        }
        return post;

    }

    @Override
    public void deletePost(Integer postId) {
        //执行删除帖子业务功能的实现
        Integer rows = postMapper.deleteByPrimaryKey(postId);

        //抛删除异常
        if (rows != 1) {
            throw new DeleteException("技术员在删除帖子过程中产生了未知的异常");
        }
    }

    @Override
    public Map<String, Object> selectAllByCondition(Integer userId, Long relatedQuestionId) {
        //查看某一技术员发的所有帖子，按照创建帖子时间降序排列
        List<Post> staffPostList = null;
        List<Post> questionPostList = null;
        PostExample staffPostExample = new PostExample();
        PostExample.Criteria criteria1 = staffPostExample.createCriteria();
        if (userId != null) {
            staffPostExample.setOrderByClause("create_time desc"); //升序
            criteria1.andUserIdEqualTo(userId);
            staffPostList = postMapper.selectByExample(staffPostExample);
        }

        //查看某一问题相关的所有帖子，按照创建帖子时间降序排列
        PostExample questionPostExample = new PostExample();
        PostExample.Criteria criteria2 = questionPostExample.createCriteria();
        if (relatedQuestionId != null) {
            questionPostExample.setOrderByClause("create_time desc"); //升序
            criteria2.andRelatedQuestionIdEqualTo(relatedQuestionId);
            questionPostList = postMapper.selectByExample(questionPostExample);
        }

        //返回数据
        Map<String, Object> res = new HashMap<>();
        res.put("staff", staffPostList);
        res.put("question", questionPostList);
        return res;
    }
}
