package com.atguigu.springboot.service;

import com.atguigu.springboot.bean.Employee;
import com.atguigu.springboot.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * 通过CacheAutoConfiguration导入的以下缓存配置类 优先级从高到低
 * org.springframework.boot.autoconfigure.cache.GenericCacheConfiguration
 * org.springframework.boot.autoconfigure.cache.JCacheCacheConfiguration
 * org.springframework.boot.autoconfigure.cache.EhCacheCacheConfiguration
 * org.springframework.boot.autoconfigure.cache.HazelcastCacheConfiguration
 * org.springframework.boot.autoconfigure.cache.InfinispanCacheConfiguration
 * org.springframework.boot.autoconfigure.cache.CouchbaseCacheConfiguration
 * org.springframework.boot.autoconfigure.cache.RedisCacheConfiguration
 * org.springframework.boot.autoconfigure.cache.CaffeineCacheConfiguration
 * org.springframework.boot.autoconfigure.cache.GuavaCacheConfiguration
 * org.springframework.boot.autoconfigure.cache.SimpleCacheConfiguration 默认使用的缓存配置类
 * org.springframework.boot.autoconfigure.cache.NoOpCacheConfiguration
 *
 * 其中 SimpleCacheConfiguration使用的是ConcurrentMapCacheManager
 * 使用的是 ConcurrentMapCache 内部是ConcurrentMap保存键值对
 * 常用的注解有 @EnableCaching 开启缓存 @Cacheable @CachePut  @CacheEvict @CacheConfig
 *
 * RedisCacheConfiguration 配置 RedisCacheManager
 * RedisAutoConfiguration 配置 RedisTemplate 和 StringRedisTemplate 等
 *
 */

@Service
public class EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * 注意：缓存名称必须设定
     * 查询时先查缓存 缓存查询不到 在调用方法 调用方法后将数据添加到缓存中
     * 查询到缓存 即不调用方法
     * cacheNames/value 表示缓存的名字
     * key 表示缓存的key
     * keyGenerator 表示生成key的方式 默认是SimpleKeyGenerator
     * key和keyGenerator 不可同时使用
     * 核心：注意key的唯一性
     * condition 条件成立时才加入缓存
     * unless 条件不成立时才加入缓存
     * @param id
     * @return
     */
    @Cacheable(cacheNames = "emp" ,keyGenerator = "mykeyGenerator" /*,,condition = "#id>1",unless = "#a0==2"*/)
    public Employee getEmp(Integer id) {
        System.out.println("查询"+id+"号员工");
        Employee emp = employeeMapper.getEmpById(id);
        return emp;
    }

    /**
     * 执行方法后修改缓存
     * @param employee
     * @return
     */
    @CachePut(value = "emp",key = "emp+#a0.id")
    public Employee updateEmp(Employee employee) {
        System.out.println("更新"+employee.getId()+"号员工");
        employeeMapper.updateEmp(employee);
        return employee;
    }

    /**
     * 清空缓存
     * allEntries 是否删除所有缓存
     * beforeInvocation 默认是方法执行之后清除缓存 万一方法执行失败 不清除缓存
     * 修改为true 则执行之前清除 一定会清除
     * @param id
     */
    @CacheEvict(value = "emp")
    public void deleteEmp(Integer id) {
        System.out.println("删除"+id+"号员工");
        //employeeMapper.deleteEmpById(id);
    }

    public Employee getEmpByLastName(String lastName) {
        System.out.println("查询"+lastName+"员工");
        Employee emp = employeeMapper.getEmpByLastName(lastName);
        return emp;
    }
}
