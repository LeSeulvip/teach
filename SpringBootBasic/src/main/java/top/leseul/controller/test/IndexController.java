package top.leseul.controller.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import top.leseul.entity.JsonMessage;
import top.leseul.entity.TbToken;
import top.leseul.service.TokenService;

/**
 * 测试用的控制器
 * 
 * @author DarkKnight
 *
 */
@RestController
@ResponseBody
@RequestMapping("/test")
public class IndexController {

  @Autowired
  private TokenService tokenService;

  @RequestMapping("/createToken")
  public JsonMessage createToken(TbToken token) throws Exception {
    return tokenService.createToken(token);
  }

}
