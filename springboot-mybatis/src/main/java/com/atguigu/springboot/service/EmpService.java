package com.atguigu.springboot.service;

import com.atguigu.springboot.pojo.Employee;

import java.sql.SQLException;

public interface EmpService {
    Employee getById(Integer id);

    void insert(Employee employee) throws SQLException;
}
