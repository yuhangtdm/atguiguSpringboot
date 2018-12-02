package com.atguigu.springboot.mapper;

import com.atguigu.springboot.pojo.Department;
import org.apache.ibatis.annotations.Insert;

public interface DepartmentMapper {

     Department getById(Integer id);

     @Insert("insert into department(dept_name) values(#{deptName})")
     void insert(Department department);
}
