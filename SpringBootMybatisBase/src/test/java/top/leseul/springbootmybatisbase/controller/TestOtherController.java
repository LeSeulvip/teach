package top.leseul.springbootmybatisbase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import top.leseul.springbootmybatisbase.model.TestModel;
import top.leseul.springbootmybatisbase.service.TestService;
import top.leseul.springbootmybatisbase.utils.JsonMessage;

/**
 * -其他测试
 * 
 * @author leseul
 *
 */
@RequestMapping("/test")
@RestController
public class TestOtherController {

  @Autowired
  private TestService testService;

  /**
   * -测试事务
   * 
   * @param model
   * @return
   * @throws Exception
   */
  @RequestMapping("/tran")
  public JsonMessage tran(TestModel model) throws Exception {
    // http://127.0.0.1:20001/test/tran?token=&ctoken.token=adcdefg&tokenInfo.infokey=abc&tokenInfo.info=ddddd
    model.getTokenInfo().setToken(model.getCtoken().getToken());
    return testService.tranAdd(model);
  }

}
