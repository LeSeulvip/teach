package top.leseul.springbootmybatisbase.service;

import top.leseul.springbootmybatisbase.entity.TbToken;

/**
 * token服务
 * 
 * @author leseul
 *
 */
public interface TokenService {

  /**
   * -检查token是否存在,不存在就返回新的
   * 
   * @param token
   * @return
   * @throws Exception
   */
  TbToken checkToken(TbToken token) throws Exception;

  /**
   * -删除过期token
   * @return
   * @throws Exception
   */
  int deleteTokens() throws Exception;

}
