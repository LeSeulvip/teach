package top.leseul.entity;

import java.io.Serializable;

import com.alibaba.fastjson.JSONObject;

/**
 * Entity和数据传输类型的对象的基础类,统一toString为json格式
 * 
 * @author leseul
 *
 */
public class BaseEntity implements Serializable {

  private static final long serialVersionUID = -4460791645951717329L;

  @Override
  public String toString() {
    // 创建fastjson的对象
    JSONObject json = new JSONObject();
    // 将当前实例以当前类的名称为key放入json对象中
    json.put(this.getClass().getName(), this);
    // 返回json格式字符串
    return json.toString();
  }

}
