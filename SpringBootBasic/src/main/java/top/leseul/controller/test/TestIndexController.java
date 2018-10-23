package top.leseul.controller.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import top.leseul.entity.JsonMessage;
import top.leseul.entity.TbToken;
import top.leseul.exception.AppException;
import top.leseul.service.TestService;
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

  private static final String TWO = "two";
  private static final String ONE = "one";
  @Autowired
  private TokenService tokenService;

  @RequestMapping("/createToken")
  public JsonMessage createToken(TbToken token) throws Exception {
    return tokenService.createToken(token);
  }

  @RequestMapping("/exception")
  public JsonMessage exception(String type) throws Exception {
    if (ONE.equals(type)) {
      throw AppException.getAppException(1000, "第一种异常");
    } else if (TWO.equals(type)) {
      throw AppException.getAppException(1001, "第二种异常");
    } else if (TWO.equals(type)) {
      return JsonMessage.getSuccess("没有错误");
    } else {
      throw new Exception("标准异常");
    }
  }

  @RequestMapping("/converter")
  public JsonMessage converter(TestEntity test) throws Exception {
    // http://127.0.0.1:20000/test/converter
    // ?info=ab&tint=12&tdouble=289.098&tdec=345.6&tdate=1988-08-13 12:33:33
    JsonMessage json = JsonMessage.getSuccess("");
    json.getDatas().put("entity", test);
    return json;
  }

  @RequestMapping("/model")
  public JsonMessage model(TestModel model) throws Exception {
    // http://127.0.0.1:20000/test/model
    // 在控制器中定义的参数用于获取客户端的数据,该对象的字段直接对应客户端的参数名
    // TestModel中token字段,可以直接用?token=adfafs传递
    // 如果字段是复杂对象,需要通过二级名称传递
    // TestModel中的entity字段是TestEntity对象,里面包含tint,tdec等等字段
    // 需要用?entity.tint=100&entity.tdec=12.32传递
    // 传递不同的数据组合:?token=aaa&entity.tint=100&entity.tdec=12.34排名不分先后
    // post提交也是一样的规则{token:'adasgdf','entity.tint':12}
    // http://127.0.0.1:20000/test/model==>token和entity都没有数据
    // http://127.0.0.1:20000/test/model?token=adfcfd
    // ==============?token为adfcd,entity没有数据
    // http://127.0.0.1:20000/test/model?taken=adfcfd
    // ==============?token,entity都没有数据
    // http://127.0.0.1:20000/test/model?token=adfcfd&entity.tint=123
    // ==============?token为adfcd,entity的tint字段为123

    // 注意!!!传递的参数名都是以对象的字段名称,而不是对象的类名称
    // model的字段名称是entity,类型是TestEntity

    JsonMessage json = JsonMessage.getSuccess("");
    json.getDatas().put("model", model);
    return json;
  }

  @Autowired
  private TestService testService;

  @RequestMapping("/page")
  public JsonMessage page(TestModel model) throws Exception {
    // http://127.0.0.1:20000/test/page?page.pageSize=5&page.pageNum=1
    return testService.queryToken(model.getPage());

  }

}
