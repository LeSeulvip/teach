package top.leseul.demo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 演示api功能
 * 
 * @author leseul
 *
 */
public class MyApi {
  public volatile SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

  /**
   * 获取当前时间
   * 
   * @return
   */
  public synchronized String getNow() {

    return sdf.format(new Date());
  }

  public static void main(String[] args) {
    MyApi api = new MyApi();
    System.out.println(api.getNow());
  }

}
