package com.atguigu.springboot.bean;

import java.io.Serializable;

public class User implements Serializable {
    private Integer id;
    private String lastName;

    public User(){

    }
    public User(Integer id,String lastName){
        this.id=id;
        this.lastName=lastName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
