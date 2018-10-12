package top.leseul.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import top.leseul.config.MyConfig;
import top.leseul.entity.Greeting;

/**
 * Greeting控制器
 * 
 * @author leseul
 *
 */
@RestController
public class GreetingController {
  @Autowired
  private MyConfig myConfig;
  
  @RequestMapping(name = "")
  public String index() {
    return String.format("欢迎使用springboot!,%s,%s", myConfig.appName, myConfig.reload);
  }

  @RequestMapping("/greeting")
  @ResponseBody
  public Greeting greeting(Greeting greeting) {
    return greeting;
  }

}
