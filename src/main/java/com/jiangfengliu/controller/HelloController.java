package com.jiangfengliu.controller;

import com.jiangfengliu.dao.SpecialtyDao;
import com.jiangfengliu.mapper.SpecialtyMapper;
import com.jiangfengliu.service.HelloWorldService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RestController
@RequestMapping("/hello")
public class HelloController {

  @Resource
  HelloWorldService helloWorldService;
//  @Resource
  SpecialtyMapper specialtyMapper;

  @RequestMapping("/info")
  @ResponseBody
  public String getInfo(@RequestParam String name) {
    return helloWorldService.getHelloMessage();
  }

  @RequestMapping("/test")
  @ResponseBody
  public List<SpecialtyDao> getDbMapper() {
    return specialtyMapper.getSpecialtyList("河北");
  }
} 