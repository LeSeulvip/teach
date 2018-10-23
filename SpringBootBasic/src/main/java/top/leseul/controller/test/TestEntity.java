package top.leseul.controller.test;

import java.math.BigDecimal;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

import top.leseul.entity.BaseEntity;

/**
 * converter测试实体类
 * 
 * @author leseul
 *
 */
public class TestEntity extends BaseEntity {

  private static final long serialVersionUID = 8541620172395830430L;

  private Integer tint;
  private Double tdouble;
  @JSONField(format = "yyyy-MM-dd HH:mm:ss")
  private Date tdate;
  private BigDecimal tdec;
  private String info;

  public String getInfo() {
    return info;
  }

  public void setInfo(String info) {
    this.info = info;
  }

  public TestEntity() {
  }

  public Integer getTint() {
    return tint;
  }

  public void setTint(Integer tint) {
    this.tint = tint;
  }

  public Double getTdouble() {
    return tdouble;
  }

  public void setTdouble(Double tdouble) {
    this.tdouble = tdouble;
  }

  public Date getTdate() {
    return tdate;
  }

  public void setTdate(Date tDate) {
    this.tdate = tDate;
  }

  public BigDecimal getTdec() {
    return tdec;
  }

  public void setTdec(BigDecimal tdec) {
    this.tdec = tdec;
  }

}
