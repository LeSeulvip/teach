package top.leseul.service;

import top.leseul.entity.JsonMessage;
import top.leseul.entity.TbToken;

/**
 * Token的服务
 * 
 * @author DarkKnight
 *
 */
public interface TokenService {

  /**
   * 更新或者返回新的token
   * 
   * @param token 客戶端的token
   * @return
   * @throws Exception
   */
  JsonMessage createToken(TbToken token) throws Exception;
}
