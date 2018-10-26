package top.leseul.springbootmybatisbase.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import top.leseul.springbootmybatisbase.dao.UtilsDAO;
import top.leseul.springbootmybatisbase.model.IndexModel;
import top.leseul.springbootmybatisbase.service.IndexService;
import top.leseul.springbootmybatisbase.utils.JsonMessage;

/**
 * 
 * @author leseul
 *
 */

@Service
@Transactional(rollbackFor = Exception.class)
public class IndexServiceImpl implements IndexService {

  @Autowired
  private UtilsDAO utilsDAO;

  @Override
  public JsonMessage index(IndexModel model) throws Exception {
    JsonMessage message = JsonMessage.getSuccess(model.getEcho());
    message.getDatas().put("now", utilsDAO.queryTime());
    return message;
  }
}
