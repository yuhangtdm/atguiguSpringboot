package com.atguigu.springboot.service.impl;

import com.atguigu.springboot.mapper.DepartmentMapper;
import com.atguigu.springboot.mapper.EmployeeMapper;
import com.atguigu.springboot.pojo.Department;
import com.atguigu.springboot.pojo.Employee;
import com.atguigu.springboot.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public Employee getById(Integer id) {
        Employee employee = employeeMapper.getById(id);
        Department department = departmentMapper.getById(employee.getDid());
        employee.setDepartment(department);

        return employee;
    }

    /**
     *spring框架中对SqlException做了重新抛出： BadSqlGrammarException
     * 即遇到了会回滚
     * @param employee
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insert(Employee employee) throws SQLException {
        int insert = employeeMapper.insert(employee);
        throw new SQLException("sqlException");
    }
}
