package top.leseul.model;

import top.leseul.entity.BaseEntity;
import top.leseul.entity.TbToken;

/**
 * model层(获取客户端数据)基础类
 * 
 * @author leseul
 *
 */
public abstract class BaseMoel extends BaseEntity {

  private static final long serialVersionUID = 4234166558780897041L;

  /**
   * token 客户端标识,由服务器端管理,客户端每次都需要提交该数据
   */
  private String token;

  public BaseMoel() {
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  /**
   * getToken的委托方法,将客户端获取的token信息转递给Tbtoken对象
   * 
   * @return
   */
  public TbToken makeTokenInfo() {
    TbToken tbToken = new TbToken();
    tbToken.setToken(token);
    return tbToken;
  }
}
