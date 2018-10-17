package top.leseul.entity;

import java.util.Date;

/**
 * 用户Token追踪表
 * 
 * @author leseul
 *
 */
public class TbToken extends EntityBase {

  private static final long serialVersionUID = -33358915632270553L;

  private String token;
  private Integer uid;
  private Date lastupdate;

  public TbToken() {
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public Integer getUid() {
    return uid;
  }

  public void setUid(Integer uid) {
    this.uid = uid;
  }

  public Date getLastupdate() {
    return lastupdate;
  }

  public void setLastupdate(Date lastupdate) {
    this.lastupdate = lastupdate;
  }

  @Override
  public String toString() {
    return "TbToken [token=" + token + ", uid=" + uid + ", lastupdate=" + lastupdate + "]";
  }

  public TbToken(String token, Integer uid, Date lastupdate) {
    super();
    this.token = token;
    this.uid = uid;
    this.lastupdate = lastupdate;
  }

}
