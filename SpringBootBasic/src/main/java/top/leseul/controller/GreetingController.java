package top.leseul.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import top.leseul.entity.Greeting;

/**
 * Greeting控制器
 * 
 * @author leseul
 *
 */
@RestController
public class GreetingController {

  @RequestMapping(name = "")
  public String index() {
    return "欢迎使用springboot!";
  }

  @RequestMapping("/greeting")
  @ResponseBody
  public Greeting greeting(Greeting greeting) {
    return greeting;
  }

}
