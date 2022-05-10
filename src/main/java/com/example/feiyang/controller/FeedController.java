package com.example.feiyang.controller;

import com.example.feiyang.common.utils.JsonResponse;
import com.example.feiyang.entity.Feed;
import com.example.feiyang.entity.PageRequest;
import com.example.feiyang.entity.PageResult;
import com.example.feiyang.service.serviceImpl.FeedServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 望舒
 * @date 2022/5/6 21:22
 */

@Controller
@RequestMapping(value = "/feed")
public class FeedController {
    @Autowired
    private FeedServiceImpl feedService;

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    @ResponseBody
    public JsonResponse addFeed(@RequestBody Map<String, Object> params) {
        Long user_id = Long.valueOf((String) params.get("user_id"));
        String feed_content = (String) params.get("feed_content");

        Feed feed = new Feed();
        feed.setUserId(user_id);
        feed.setFeedContent(feed_content);
        feed.setCreateTime(new Date());

        JsonResponse res = feedService.addFeed(feed);

        return res;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all")
    @ResponseBody
    public JsonResponse getAllFeeds(@RequestBody PageRequest pageQuery) {
        Map<String, Object> res = new HashMap<>();
        PageResult allFeeds = feedService.getAllFeeds(pageQuery);

        res.put("feeds", allFeeds);
        return JsonResponse.success(res, "查询成功！");
    }
}
