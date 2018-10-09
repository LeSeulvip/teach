package top.leseul.entity;

/**
 * 测试实体类
 * 
 * @author leseul
 *
 */
public class Greeting {
  private Integer id;
  private String content;

  public Greeting() {

  }

  @Override
  public String toString() {
    return "Greeting [id=" + id + ", content=" + content + "]";
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Greeting(Integer id, String content) {
    super();
    this.id = id;
    this.content = content;
  }

}
