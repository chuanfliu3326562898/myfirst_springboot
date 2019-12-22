package com.jiangfengliu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 应用模块名称<p>
 * 代码描述<获取所有阶段返回dto>
 *
 * @Author: liujiangfeng
 * Company: 跟谁学<p>
 * @Date: 2019-12-17
 */
@Service
public class HelloWorldService2Impl implements HelloWorldService2{
    @Autowired
    private HelloWorldService helloWorldService;

    @Override
    public String getHelloMessage() {
        System.out.println(helloWorldService.getHelloMessage() + ":getHelloMessage method inner str");
        return helloWorldService.getHelloMessage() + ":getHelloMessage method inner str";
    }
}
