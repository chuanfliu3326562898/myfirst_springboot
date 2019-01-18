package com.jiangfengliu.service;

import org.springframework.stereotype.Service;

@Service
public class HelloWorldServiceImpl implements HelloWorldService{
    public String getHelloMessage() {  
        return "Hello world";  
    }  
}