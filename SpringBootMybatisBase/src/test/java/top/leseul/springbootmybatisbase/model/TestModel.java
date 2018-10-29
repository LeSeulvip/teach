package top.leseul.springbootmybatisbase.model;

import top.leseul.springbootmybatisbase.base.BaseModel;
import top.leseul.springbootmybatisbase.entity.TbToken;
import top.leseul.springbootmybatisbase.entity.TbTokenInfo;

/**
 * -测试用modle
 * 
 * @author leseul
 *
 */
public class TestModel extends BaseModel {

  private static final long serialVersionUID = 2197262484376563403L;

  private TbToken ctoken = new TbToken();
  private TbTokenInfo tokenInfo = new TbTokenInfo();

  public TbToken getCtoken() {
    return ctoken;
  }

  public void setCtoken(TbToken ctoken) {
    this.ctoken = ctoken;
  }

  public TbTokenInfo getTokenInfo() {
    return tokenInfo;
  }

  public void setTokenInfo(TbTokenInfo tokenInfo) {
    this.tokenInfo = tokenInfo;
  }

}
