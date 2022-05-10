package com.example.feiyang.service;

import com.example.feiyang.common.utils.JsonResponse;
import com.example.feiyang.entity.Feed;
import com.example.feiyang.entity.PageRequest;
import com.example.feiyang.entity.PageResult;

/**
 * @author 望舒
 * @date 2022/5/6 20:32
 */

public interface FeedService {
    /**
     * 添加反馈
     * @param feed
     * @return
     */
    public JsonResponse addFeed(Feed feed);

    /**
     * 反馈分页查询接口
     * 这里统一封装了分页请求和结果，避免直接引入具体框架的分页对象, 如MyBatis或JPA的分页对象
     * 从而避免因为替换ORM框架而导致服务层、控制层的分页接口也需要变动的情况，替换ORM框架也不会
     * 影响服务层以上的分页接口，起到了解耦的作用
     * @param pageRequest 自定义，统一分页查询请求
     * @return
     */
    public PageResult getAllFeeds(PageRequest pageRequest);
}
