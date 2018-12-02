package com.atguigu.springboot.mapper;

import com.atguigu.springboot.pojo.Department;
import com.atguigu.springboot.service.DepartmentService;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartmentMapperTest {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Autowired
    private SqlSession sqlSession;

    @Autowired
    private DepartmentService departmentService;

    @Test
    public void getById() {
        System.out.println(departmentMapper.getById(1));
        System.out.println(departmentMapper.getById(1));
    }

    @Test
    public void testCache(){
        Department department=sqlSession.selectOne("com.atguigu.springboot.mapper.DepartmentMapper.getById",1);
        System.out.println(department);
        Department department2=sqlSession.selectOne("com.atguigu.springboot.mapper.DepartmentMapper.getById",1);
        System.out.println(department2);
    }
    @Test
    public void test(){
        Department department=new Department();
        department.setDeptName("直营部");
        departmentService.insert(department);
    }
}