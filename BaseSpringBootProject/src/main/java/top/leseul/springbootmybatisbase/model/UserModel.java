package top.leseul.springbootmybatisbase.model;

import top.leseul.springbootmybatisbase.base.BaseModel;
import top.leseul.springbootmybatisbase.entity.TbUser;

/**
 * user控制器的模型
 * 
 * @author leseul
 *
 */
public class UserModel extends BaseModel {

  private static final long serialVersionUID = 7030882132771048928L;

  private TbUser user = new TbUser();

  public UserModel() {
  }

  public TbUser getUser() {
    return user;
  }

  public void setUser(TbUser user) {
    this.user = user;
  }

}
