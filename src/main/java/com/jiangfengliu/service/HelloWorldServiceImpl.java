package com.jiangfengliu.service;

import org.springframework.stereotype.Service;

@Service
public class HelloWorldServiceImpl implements HelloWorldService{
    @Override
    public String getHelloMessage() {  
        return "Hello world";  
    }  
}