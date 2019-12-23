package com.jiangfengliu;

//import com.google.gson.Gson;
import com.jiangfengliu.dao.ChannelDao;
import com.jiangfengliu.model.Channel;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//@ServletComponentScan("com.jiangfengliu.controller")
@ComponentScan(basePackages = "com.jiangfengliu")
@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
@Controller
public class SpringBootApplicationDemo extends SpringBootServletInitializer implements WebServerFactoryCustomizer {


//  @RequestMapping("/infos")
//  @ResponseBody
//  public Map<String, String> getInfo(@RequestParam String name) {
//    Map<String, String> map = new HashMap<>();
//    map.put("test", "test");
//    return map;
//  }
  public static void main(String[] args) {
    SpringApplication.run(SpringBootApplicationDemo.class, args);
  }

  @Autowired
  private ChannelDao channelDao;

  @RequestMapping("/testChannel")
  @ResponseBody
  public String getInfo(@RequestParam String name) {
    List<Channel> channels = channelDao.selectByChannelIds(Arrays.asList(8L));
    return Arrays.toString(channels.toArray());
  }

  @Override
  public void customize(WebServerFactory factory) {
    if (factory instanceof ConfigurableWebServerFactory) {
      ((ConfigurableWebServerFactory) factory).setPort(8081);
    }
  }
}