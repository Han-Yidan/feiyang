package com.example.feiyang.service.impl;

import com.example.feiyang.common.utils.JsonResponse;
import com.example.feiyang.dao.FeedMapper;
import com.example.feiyang.entity.Feed;
import com.example.feiyang.entity.FeedExample;
import com.example.feiyang.service.FeedService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.FeatureDescriptor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 望舒
 * @date 2022/5/6 20:32
 */

@Service
public class FeedServiceImpl implements FeedService {
    @Autowired
    FeedMapper feedMapper;

    @Override
    public JsonResponse addFeed(Feed feed) {
        int isInsert = feedMapper.insert(feed);

        Map<String, Object> res = new HashMap<>();

        if (isInsert == 1) {
            res.put("isAdd", 1);
            return JsonResponse.success(res, "提交成功！");
        }
        res.put("isAdd", 0);
        return JsonResponse.success(res, "提交失败！");
    }


    @Override
    public List<Feed> getAllFeeds(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Feed> allFeeds = feedMapper.selectPage();

        return allFeeds;
    }

    @Override
    public Integer getTotalFeed() {
        FeedExample feedExample = new FeedExample();
        FeedExample.Criteria criteria = feedExample.createCriteria();
        criteria.andFeedIdIsNotNull();

        int countFeed = feedMapper.countByExample(feedExample);
        return countFeed;
    }


}
