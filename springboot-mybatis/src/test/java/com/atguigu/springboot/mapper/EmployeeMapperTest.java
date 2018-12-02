package com.atguigu.springboot.mapper;

import com.atguigu.springboot.pojo.Employee;
import com.atguigu.springboot.service.EmpService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLException;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeMapperTest {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private EmpService empService;

    @Test
    public void getById() {
        System.out.println(employeeMapper.getById(1));
    }

    @Test
    public void insert() throws SQLException {
        Employee employee=new Employee();
        employee.setLastName("哈哈");
        employee.setEmail("haha@qq.com");
        employee.setGender("男");
         empService.insert(employee);


    }
}