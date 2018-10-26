package top.leseul.springbootmybatisbase.service;

import top.leseul.springbootmybatisbase.model.UserModel;
import top.leseul.springbootmybatisbase.utils.JsonMessage;

/**
 * -User控制器的服务
 * 
 * @author leseul
 *
 */
public interface UserService {

  /**
   * -用户登录
   * 
   * @param model
   * @return
   * @throws Exception
   */
  JsonMessage login(UserModel model) throws Exception;

  /**
   * -用户注销
   * 
   * @param model
   * @return
   * @throws Exception
   */
  JsonMessage logout(UserModel model) throws Exception;

  /**
   * -获取当前登录的用户信息
   * 
   * @param model
   * @return
   * @throws Exception
   */
  JsonMessage getUserInfo(UserModel model) throws Exception;

}
