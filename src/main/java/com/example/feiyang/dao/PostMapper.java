package com.example.feiyang.dao;

import com.example.feiyang.entity.Feed;
import com.example.feiyang.entity.Post;
import com.example.feiyang.entity.PostAndQuestion;
import com.example.feiyang.entity.PostExample;
import java.util.List;

import javafx.geometry.Pos;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PostMapper {
    int countByExample(PostExample example);

    int deleteByExample(PostExample example);

    int deleteByPrimaryKey(Long postId);

    int insert(Post record);

    int insertSelective(Post record);

    List<Post> selectByExampleWithBLOBs(PostExample example);

    List<Post> selectByExample(PostExample example);

    Post selectByPrimaryKey(Long postId);

    int updateByExampleSelective(@Param("record") Post record, @Param("example") PostExample example);

    int updateByExampleWithBLOBs(@Param("record") Post record, @Param("example") PostExample example);

    int updateByExample(@Param("record") Post record, @Param("example") PostExample example);

    int updateByPrimaryKeySelective(Post record);

    int updateByPrimaryKeyWithBLOBs(Post record);

    int updateByPrimaryKey(Post record);

    List<PostAndQuestion> selectPage();

    List<PostAndQuestion> getNoExamine();

    PostAndQuestion getByPostId(@Param("post_id") Long post_id);
}