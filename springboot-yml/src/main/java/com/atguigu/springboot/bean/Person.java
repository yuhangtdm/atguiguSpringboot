package com.atguigu.springboot.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Map;

/**
 * @ConfigurationProperties(prefix = "person") 可以注入springboot全局文件里的属性
 * 但是实体本身要是spring的bean 可以加JSR303校验 不支持spel表达式
 * @Value可以一个个的属性注入 但是不可以加JSR303校验 但是支持spel表达式
 * @PropertySource 可以指定配置文件用来读取数据 只可以读取properties文件
 *
 * 注意yml的写法 空格表示范围 冒号和变量必须要用空格间断
 * 字面量 数字 布尔 字符串等直接写 不需要加引号 对于字符串
 * 单引号 转义特殊字符
 * 双引号 不转义特殊字符
 * 对象/map 换行重写属性 或者{"k":v}的方式
 * 数组/list []或者 - k: v的方式
 * yml/properties文件 主要用于手写配置文件 对于配置信息便于管理
 * 项目中可以配置类用配置文件的方式注入
 * 大部分都是单个属性取配置文件中 若是全局文件的也就是application.xxx
 * 则直接@Value 若不是 则加@PropertySource指定配置文件
 */
@Component
@ConfigurationProperties(prefix = "person")
@PropertySource(value = {"classpath:person.properties"})
@Validated
public class Person {
//    @Email
   @Value("${person.last-name}")
    private String lastName;
    private Integer age;
    private Boolean sex;
    private Map<String,Object> inst;
    private List<String> loves;
    private Dog dog;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Map<String, Object> getInst() {
        return inst;
    }

    public void setInst(Map<String, Object> inst) {
        this.inst = inst;
    }

    public List<String> getLoves() {
        return loves;
    }

    public void setLoves(List<String> loves) {
        this.loves = loves;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", inst=" + inst +
                ", loves=" + loves +
                ", dog=" + dog +
                '}';
    }
}
