package top.leseul.service;

import top.leseul.entity.JsonMessage;
import top.leseul.entity.PageBean;

/**
 * TestService-测试用服务
 * 
 * @author leseul
 *
 */
public interface TestService {

  /**
   * -分页查询
   * 
   * @param page
   * @return
   * @throws Exception
   */
  JsonMessage queryToken(PageBean page) throws Exception;

}
