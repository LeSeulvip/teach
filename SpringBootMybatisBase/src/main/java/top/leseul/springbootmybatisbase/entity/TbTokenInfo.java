package top.leseul.springbootmybatisbase.entity;

import java.util.Date;

import top.leseul.springbootmybatisbase.base.BaseEntity;

/**
 * TbTokenInfo表
 * 
 * @author leseul
 *
 */
public class TbTokenInfo extends BaseEntity {

  private static final long serialVersionUID = 2876080691555887175L;

  private String token;
  private String infoKey;
  private String info;
  private Date lastupdate;

  public TbTokenInfo() {
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public String getInfoKey() {
    return infoKey;
  }

  public void setInfoKey(String infoKey) {
    this.infoKey = infoKey;
  }

  public String getInfo() {
    return info;
  }

  public void setInfo(String info) {
    this.info = info;
  }

  public Date getLastupdate() {
    return lastupdate;
  }

  public void setLastupdate(Date lastupdate) {
    this.lastupdate = lastupdate;
  }

}
