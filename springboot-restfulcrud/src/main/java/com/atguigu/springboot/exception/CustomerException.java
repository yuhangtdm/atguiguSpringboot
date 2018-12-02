package com.atguigu.springboot.exception;

public class CustomerException extends RuntimeException {
    private Integer code;
    private String msg;
    public CustomerException() {
        super();
    }

    public CustomerException(Integer code,String message) {
        super(message);
        this.code=code;
        this.msg=message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
