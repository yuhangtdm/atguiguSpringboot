package com.atguigu.springboot.service;

import com.atguigu.springboot.mapper.DepartmentMapper;
import com.atguigu.springboot.pojo.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;

    @Transactional
    public void insert(Department department){
        departmentMapper.insert(department);
        int i=10/0;
    }
}
