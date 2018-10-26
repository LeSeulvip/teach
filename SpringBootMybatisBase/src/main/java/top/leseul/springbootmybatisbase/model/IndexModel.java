package top.leseul.springbootmybatisbase.model;

import top.leseul.springbootmybatisbase.base.BaseModel;

/**
 * -首页model层
 * 
 * @author leseul
 *
 */

public class IndexModel extends BaseModel {

  private static final long serialVersionUID = 7362095744050241114L;

  private String echo;

  public IndexModel() {
  }

  public String getEcho() {
    return echo;
  }

  public void setEcho(String echo) {
    this.echo = echo;
  }

}
