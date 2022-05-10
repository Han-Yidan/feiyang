package com.example.feiyang.common.utils;

/**
 * @author 望舒
 * @date 2022/5/6 20:45
 */

import com.example.feiyang.entity.PageRequest;
import com.example.feiyang.entity.PageResult;
import com.github.pagehelper.PageInfo;

public class PageUtils {

    /**
     * 将分页信息封装到统一的接口
     * @param pageRequest
     * @param pageInfo
     * @return
     */
    public static PageResult getPageResult(PageRequest pageRequest, PageInfo<?> pageInfo) {
        PageResult pageResult = new PageResult();
        pageResult.setPageNum(pageInfo.getPageNum());
        pageResult.setPageSize(pageInfo.getPageSize());
        pageResult.setTotalSize(pageInfo.getTotal());
        pageResult.setTotalPages(pageInfo.getPages());
        pageResult.setContent(pageInfo.getList());
        return pageResult;
    }
}
