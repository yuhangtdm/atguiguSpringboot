package com.atguigu.springboot;

import com.atguigu.springboot.bean.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootCacheApplicationTests {

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate empRedisTemplate;


    @Test
    public void test01() {
        stringRedisTemplate.opsForValue().set("hello","小红");
    }

    @Test
    public void test02() {
        empRedisTemplate.opsForValue().set("emp02",new Employee(2,"小清","11",1,2));
    }

}
