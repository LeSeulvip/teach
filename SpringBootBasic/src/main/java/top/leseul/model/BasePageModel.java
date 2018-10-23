package top.leseul.model;

import top.leseul.entity.PageBean;

/**
 * -分页
 * @author leseul
 *
 */
public abstract class BasePageModel extends BaseMoel {

  private static final long serialVersionUID = -5599318608408460215L;

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
