package top.leseul.springbootmybatisbase.dao;

import org.apache.ibatis.annotations.Mapper;

import top.leseul.springbootmybatisbase.entity.TbToken;

/**
 * TbToken表的dao
 * 
 * @author leseul
 *
 */
@Mapper
public interface TbTokenDAO {
  /**
   * -查询toeken
   * 
   * @param token
   * @return
   * @throws Exception
   */
  TbToken queryToken(TbToken token) throws Exception;

  /**
   * -添加token
   * 
   * @param token
   * @return
   * @throws Exception
   */
  int addToken(TbToken token) throws Exception;

  /**
   * -更新token
   * 
   * @param token
   * @return
   * @throws Exception
   */
  int updateToken(TbToken token) throws Exception;

  /**
   * -删除过期token
   * 
   * @param token
   * @return
   * @throws Exception
   */
  int deleteTokens() throws Exception;

  /**
   * -用户上线登录
   * 
   * @return
   * @throws Exception
   */
  int userLogin(TbToken token) throws Exception;

  /**
   * -用户注销
   * 
   * @param token
   * @return
   * @throws Exception
   */
  int userLogout(TbToken token) throws Exception;
}
