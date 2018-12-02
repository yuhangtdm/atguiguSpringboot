package com.atguigu.springboot.service;

import com.atguigu.springboot.bean.Department;
import com.atguigu.springboot.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeptService {

    @Autowired
    private DepartmentMapper departmentMapper;

    public Department getDeptById(Integer id) {
        Department dept = departmentMapper.getDeptById(id);
        return dept;
    }
}
