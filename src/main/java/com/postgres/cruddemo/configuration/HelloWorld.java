package com.postgres.cruddemo.configuration;

import org.springframework.stereotype.Component;

@Component
public class HelloWorld {
   private String msg;

    public HelloWorld() {
        this.msg = "Wecome Default Message";
    }

    HelloWorld(String msg){
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
