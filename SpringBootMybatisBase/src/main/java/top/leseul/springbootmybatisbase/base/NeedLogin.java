package top.leseul.springbootmybatisbase.base;

import top.leseul.springbootmybatisbase.entity.TbUser;

/**
 * -需要登录的标志的接口
 * 
 * @author leseul
 *
 */
public interface NeedLogin {
  /**
   * -没有登录的错误代码
   */
  public static final int NOT_LOGIN = 1000;

  /**
   * -传入登录的用户信息
   * 
   * @param user
   */
  public void setUser(TbUser user);

}
