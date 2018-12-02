package com.atguigu.springboot;

public class HelloService {

    private HelloProperties helloProperties;

    public String say(String name){
        return helloProperties.getPrefix()+"-"+name+"-"+helloProperties.getSuffix();
    }

    public HelloProperties getHelloProperties() {
        return helloProperties;
    }

    public void setHelloProperties(HelloProperties helloProperties) {
        this.helloProperties = helloProperties;
    }
}
