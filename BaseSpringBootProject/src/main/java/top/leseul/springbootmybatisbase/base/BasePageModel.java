package top.leseul.springbootmybatisbase.base;

import top.leseul.springbootmybatisbase.utils.PageBean;

/**
 * -带分页信息的model基类
 * 
 * @author leseul
 *
 */
public class BasePageModel extends BaseModel {

  private static final long serialVersionUID = -8309684167950387924L;

  private PageBean page = new PageBean();

  public BasePageModel() {
  }

  public PageBean getPage() {
    return page;
  }

  public void setPage(PageBean page) {
    this.page = page;
  }


}
