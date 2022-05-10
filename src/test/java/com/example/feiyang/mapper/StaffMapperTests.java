package com.example.feiyang.mapper;

import com.example.feiyang.dao.StaffMapper;
import com.example.feiyang.entity.Staff;
import com.example.feiyang.entity.StaffExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class StaffMapperTests {
    @Autowired
    private StaffMapper staffMapper;

    @Test
    public void insert() {
        StaffExample staffExample = new StaffExample();
        StaffExample.Criteria criteria = staffExample.createCriteria();
        criteria.andUserIdEqualTo(1L);
        List<Staff> staffs = staffMapper.selectByExample(staffExample);
        System.out.println(staffs.size());


    }

}
