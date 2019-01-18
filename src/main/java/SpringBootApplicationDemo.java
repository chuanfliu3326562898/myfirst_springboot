import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;


//@ServletComponentScan("com.jiangfengliu.controller")
@ComponentScan(basePackages = "com.jiangfengliu")
@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
//@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@Controller
public class SpringBootApplicationDemo extends SpringBootServletInitializer implements WebServerFactoryCustomizer {

  public static void main(String[] args) {
    SpringApplication.run(SpringBootApplicationDemo.class, args);
  }

  @RequestMapping("/infos")
  @ResponseBody
  public Map<String, String> getInfo(@RequestParam String name) {
    Map<String, String> map = new HashMap<>();
    map.put("test", "test");
    return map;
  }


  @Override
  public void customize(WebServerFactory factory) {
    if (factory instanceof ConfigurableWebServerFactory) {
      ((ConfigurableWebServerFactory) factory).setPort(8081);
    }
  }
}