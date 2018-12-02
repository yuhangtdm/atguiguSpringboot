package com.atguigu.springboot.mapper;

import com.atguigu.springboot.pojo.Employee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

/**
 * 通过@Mapper为EmployeeMapper创建代理对象
 * mybatis的特性全部可以按照MybatisProperties 配置在yml文件里
 * 也可以指定mybatis的配置文件
 * 还可以写myybatis的配置类
 */
//@Mapper
public interface EmployeeMapper {

    @Select("select * from employee where id=#{id}")
    public Employee getById(Integer id);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into employee(last_name,email,gender) values(#{lastName},#{email},#{gender})")
    public int insert(Employee employee);
}
