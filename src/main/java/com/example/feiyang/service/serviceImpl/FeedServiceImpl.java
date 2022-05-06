package com.example.feiyang.service.serviceImpl;

import com.example.feiyang.common.utils.JsonResponse;
import com.example.feiyang.common.utils.PageUtils;
import com.example.feiyang.dao.FeedMapper;
import com.example.feiyang.entity.Feed;
import com.example.feiyang.entity.PageRequest;
import com.example.feiyang.entity.PageResult;
import com.example.feiyang.service.FeedService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    /**
     * 调用分页插件完成分页
     * @param pageRequest
     * @return
     */
    private PageInfo<Feed> getPageInfo(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<Feed> sysMenus = feedMapper.selectPage();
        return new PageInfo<Feed>(sysMenus);
    }

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
    public PageResult getAllFeeds(PageRequest pageRequest) {
        return PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest));
    }


}
