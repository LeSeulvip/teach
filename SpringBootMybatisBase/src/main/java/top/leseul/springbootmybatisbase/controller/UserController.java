package top.leseul.springbootmybatisbase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import top.leseul.springbootmybatisbase.model.UserModel;
import top.leseul.springbootmybatisbase.service.UserService;
import top.leseul.springbootmybatisbase.utils.JsonMessage;

/**
 * -用户信息控制器
 * 
 * @author leseul
 *
 */

@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserService userService;

  @RequestMapping("/login")
  public JsonMessage login(UserModel model) throws Exception {
    // http://127.0.0.1:20001/?echo=abc-123&token=8d0e9ebe-b629-446d-b3f7-041c86065b81
    // &user.username=test&user.password=test-pwd
    return userService.login(model);
  }

  @RequestMapping("/logout")
  public JsonMessage logout(UserModel model) throws Exception {
    // http://127.0.0.1:20001/?echo=abc-123&token=ef80aec9-74ec-4c55-b480-453a7e0d1824
    return userService.logout(model);
  }

  @RequestMapping("/getUserInfo")
  public JsonMessage getUserInfo(UserModel model) throws Exception {
    // http://127.0.0.1:20001/user/getUserInfo?token=ef80aec9-74ec-4c55-b480-453a7e0d1824
    return userService.getUserInfo(model);
  }
}
