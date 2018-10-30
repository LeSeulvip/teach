package top.leseul.springbootmybatisbase.service;

import top.leseul.springbootmybatisbase.model.TestModel;
import top.leseul.springbootmybatisbase.utils.JsonMessage;

/**
 * -测试服务
 * 
 * @author leseul
 *
 */
public interface TestService {

  /**
   * -测试事务台添加
   * 
   * @param model
   * @return
   * @throws Exception
   */
  JsonMessage tranAdd(TestModel model) throws Exception;

}
