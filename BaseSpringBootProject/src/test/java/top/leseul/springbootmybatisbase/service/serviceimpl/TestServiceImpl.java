package top.leseul.springbootmybatisbase.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import top.leseul.springbootmybatisbase.dao.TestDAO;
import top.leseul.springbootmybatisbase.model.TestModel;
import top.leseul.springbootmybatisbase.service.TestService;
import top.leseul.springbootmybatisbase.utils.JsonMessage;

/**
 * 
 * @author leseul
 *
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TestServiceImpl implements TestService {
  @Autowired
  private TestDAO testDAO;

  @Override
  public JsonMessage tranAdd(TestModel model) throws Exception {
    // 事务处理,只要一个失败都会失败,否则都成功
    testDAO.addToken(model.getCtoken());
    testDAO.addTokenInfo(model.getTokenInfo());

    return JsonMessage.getSuccess("添加成功");
  }

}
