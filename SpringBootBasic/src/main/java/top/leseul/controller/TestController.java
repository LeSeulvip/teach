package top.leseul.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import top.leseul.dao.TbUserDAO;
import top.leseul.entity.TbUser;

/**
 * 测试用控制器
 * 
 * @author leseul
 *
 */

@RestController
@RequestMapping("/test")
public class TestController {
  @Autowired
  private TbUserDAO tbUserDAO;

  @RequestMapping("/login")
  @ResponseBody
  public TbUser login(TbUser user) throws Exception {
    // http://127.0.0.1:20000/test/login?username=test&password=test-pwd
    return tbUserDAO.login(user);
  }

}
