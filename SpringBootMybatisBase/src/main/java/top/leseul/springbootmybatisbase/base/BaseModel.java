package top.leseul.springbootmybatisbase.base;

import top.leseul.springbootmybatisbase.entity.TbToken;

/**
 * model层基类
 * 
 * @author leseul
 *
 */
public class BaseModel extends BaseEntity {

  private static final long serialVersionUID = -1831092248041569816L;
  
  private String token;

  public BaseModel() {
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }
  
  /**
   * 获取token的委托方法
   * 
   * @return
   */
  public TbToken getTbToken() {
    TbToken tbToken = new TbToken();
    tbToken.setToken(token);
    return tbToken;

  }

}
