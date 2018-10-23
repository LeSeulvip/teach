package top.leseul.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import top.leseul.dao.TestDAO;
import top.leseul.entity.JsonMessage;
import top.leseul.entity.PageBean;
import top.leseul.entity.TbToken;
import top.leseul.service.TestService;

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
  public JsonMessage queryToken(PageBean page) throws Exception {
    // 查询前设置分页参数(第几页,每页记录数)
    PageHelper.startPage(page.getPageNumber(), page.getPageSize());
    // 查询结果可以返回为Page(带分页的List集合扩展,也就是Page<>和List<>可以互换)
    Page<TbToken> pages = (Page<TbToken>) testDAO.queryTokens();
    // List<TbToken> list = testDAO.queryTokens();
    // 获取到分页的信息
    JsonMessage json = JsonMessage.getSuccess("");
    Map<String, Object> datas = json.getDatas();
    // 分页查询集
    page.setPageInfo(pages);
    
    datas.put("page", page);
    // 原始查询集
    datas.put("list", pages);

    return json;
  }

}
