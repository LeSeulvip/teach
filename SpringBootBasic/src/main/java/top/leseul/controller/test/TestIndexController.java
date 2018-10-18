package top.leseul.controller.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import top.leseul.entity.JsonMessage;
import top.leseul.entity.TbToken;
import top.leseul.exception.AppException;
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
public class TestIndexController {

  @Autowired
  private TokenService tokenService;

  @RequestMapping("/createToken")
  public JsonMessage createToken(TbToken token) throws Exception {
    return tokenService.createToken(token);
  }

  @RequestMapping("/exception")
  public JsonMessage exception(String type) throws Exception {
    if ("one".equals(type)) {
      throw AppException.getAppException(1000, "第一种异常");
    } else if ("two".equals(type)) {
      throw AppException.getAppException(1001, "第二种异常");
    } else if ("two".equals(type)) {
      return JsonMessage.getSuccess("没有错误");
    } else {
      throw new Exception("标准异常");
    }
  }
}
