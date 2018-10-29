package top.leseul.springbootmybatisbase.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import top.leseul.springbootmybatisbase.base.NeedLogin;
import top.leseul.springbootmybatisbase.entity.TbUser;
import top.leseul.springbootmybatisbase.model.TestModel;
import top.leseul.springbootmybatisbase.utils.JsonMessage;

/**
 * -测试控制器
 * 
 * @author leseul
 *
 */
@RestController
@RequestMapping("/test")
public class TestController implements NeedLogin {


  private TbUser user;

  @Override
  public void setUser(TbUser user) {
    this.user = user;
  }

  @RequestMapping("/index")
  public JsonMessage index(TestModel model) throws Exception {
    // http://127.0.0.1:20001/test/index
    JsonMessage message = JsonMessage.getSuccess("测试NeedLogin接口");
    // 可以直接拿到登录的user信息
    message.getDatas().put("user", user);
    return message;
  }

  

}
