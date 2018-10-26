package top.leseul.springbootmybatisbase.service;

import top.leseul.springbootmybatisbase.model.IndexModel;
import top.leseul.springbootmybatisbase.utils.JsonMessage;

/**
 * -首页服务
 * 
 * @author leseul
 *
 */
public interface IndexService {

  /**
   * -首页echo
   * @param model
   * @return
   * @throws Exception
   */
  JsonMessage index(IndexModel model) throws Exception;

}
