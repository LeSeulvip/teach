package top.leseul.demo;

import java.io.Serializable;

/**
 * 
 * @author leseul
 *
 */
public class FastJsonEntity implements Serializable {

  private static final long serialVersionUID = -8154155107631519128L;

  private Integer eid;
  private String info;

  public FastJsonEntity() {

  }

  @Override
  public String toString() {
    return "FastJsonEntity [eid=" + eid + ", info=" + info + "]";
  }

  public Integer getEid() {
    return eid;
  }

  public void setEid(Integer eid) {
    this.eid = eid;
  }

  public String getInfo() {
    return info;
  }

  public void setInfo(String info) {
    this.info = info;
  }

  public FastJsonEntity(Integer eid, String info) {
    super();
    this.eid = eid;
    this.info = info;
  }

}
