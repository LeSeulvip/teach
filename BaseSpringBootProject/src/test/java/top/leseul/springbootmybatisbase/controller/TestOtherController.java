package top.leseul.springbootmybatisbase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import top.leseul.springbootmybatisbase.entity.TbTokenInfo;
import top.leseul.springbootmybatisbase.model.TestModel;
import top.leseul.springbootmybatisbase.service.TestService;
import top.leseul.springbootmybatisbase.service.UtilService;
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

  @Autowired
  private UtilService utilService;

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

  @RequestMapping("/imageCode")
  public JsonMessage imageCode(TestModel model) throws Exception {
    // http://127.0.0.1:20001/test/imageCode?token=&imageCode
    // 获取获取校验码
    TbTokenInfo info = model.MakeTbTokenInfo();
    info.setInfo(model.getImageCode());
    // 校验
    boolean check = utilService.checkImageCode(info);
    if (check) {
      return JsonMessage.getSuccess("图片校验正确");
    } else {
      return JsonMessage.getFail("图片校验失败");
    }

  }
}
