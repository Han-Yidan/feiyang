package com.example.feiyang.controller;

import com.example.feiyang.common.utils.JsonResponse;
import com.example.feiyang.dao.FeedMapper;
import com.example.feiyang.entity.Feed;
import com.example.feiyang.entity.PageRequest;
import com.example.feiyang.entity.PageResult;
import com.example.feiyang.service.impl.FeedServiceImpl;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
    public JsonResponse getAllFeeds(@PathParam("pageNum") Integer pageNum, @PathParam("pageSize") Integer pageSize) {

        List<Feed> allFeeds = feedService.getAllFeeds(pageNum, pageSize);
        Map<String, Object> res = new HashMap<>();

        res.put("feeds", allFeeds);
        return JsonResponse.success(res, "查询成功！");
    }
}
