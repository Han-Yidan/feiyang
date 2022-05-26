package com.example.feiyang.dao;

import com.example.feiyang.entity.Staff;
import com.example.feiyang.entity.StaffExample;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface StaffMapper {

    int countByExample(StaffExample example);

    int deleteByExample(StaffExample example);

    int deleteByPrimaryKey(Long userId);

    int insert(Staff record);

    int insertSelective(Staff record);

    @MapKey("user_id")
    List<Map<String, Object>> selectByYearWithList(Integer year);

    List<Staff> selectByExampleWithBLOBs(StaffExample example);

    List<Staff> selectByExample(StaffExample example);

    Staff selectByPrimaryKey(Long userId);

    int updateByExampleSelective(@Param("record") Staff record, @Param("example") StaffExample example);

    int updateByExampleWithBLOBs(@Param("record") Staff record, @Param("example") StaffExample example);

    int updateByExample(@Param("record") Staff record, @Param("example") StaffExample example);

    int updateByPrimaryKeySelective(Staff record);

    int updateByPrimaryKeyWithBLOBs(Staff record);

    int updateByPrimaryKey(Staff record);
}