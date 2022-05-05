package com.example.feiyang.dao;

import com.example.feiyang.entity.Feed;
import com.example.feiyang.entity.FeedExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FeedMapper {
    int countByExample(FeedExample example);

    int deleteByExample(FeedExample example);

    int deleteByPrimaryKey(Long feedId);

    int insert(Feed record);

    int insertSelective(Feed record);

    List<Feed> selectByExample(FeedExample example);

    Feed selectByPrimaryKey(Long feedId);

    int updateByExampleSelective(@Param("record") Feed record, @Param("example") FeedExample example);

    int updateByExample(@Param("record") Feed record, @Param("example") FeedExample example);

    int updateByPrimaryKeySelective(Feed record);

    int updateByPrimaryKey(Feed record);
}