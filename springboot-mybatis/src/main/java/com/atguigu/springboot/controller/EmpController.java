package com.atguigu.springboot.controller;

import com.atguigu.springboot.mapper.EmployeeMapper;
import com.atguigu.springboot.pojo.Employee;
import com.atguigu.springboot.service.EmpService;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmpController {

    @Autowired
    private EmpService empService;

    @Autowired
    private EmployeeMapper employeeMapper;

    @RequestMapping("/emp/{id}")
    @ResponseBody
    public Employee getById(@PathVariable("id") Integer id){
        Employee employee= empService.getById(id);
        return employee;
    }

    @RequestMapping("/emp")
    public Employee insert(Employee employee){
        employeeMapper.insert(employee);
        return employee;
    }
}
