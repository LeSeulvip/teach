package top.leseul.controller.test;

import top.leseul.model.BasePageModel;

/**
 * TestModel测试用的model层,model层是可以组合不同的数据传送
 * 
 * @author leseul
 *
 */
public class TestModel extends BasePageModel {

  private static final long serialVersionUID = -2820885921653252177L;

  /**
   * model层定义的对象数据,可以直接new创建出来,可以减少null值判断
   */
  private TestEntity entity = new TestEntity();

  public TestModel() {
  }

  public TestEntity getEntity() {
    return entity;
  }

  public void setEntity(TestEntity entity) {
    this.entity = entity;
  }

}
