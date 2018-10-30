package top.leseul.springbootmybatisbase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import top.leseul.springbootmybatisbase.model.IndexModel;
import top.leseul.springbootmybatisbase.service.IndexService;
import top.leseul.springbootmybatisbase.utils.JsonMessage;

/**
 * -首页
 * 
 * @author leseul
 *
 */
@RestController
public class IndexController {

  @Autowired
  IndexService indexService;

  @RequestMapping("")
  public JsonMessage index(IndexModel model) throws Exception {
    //http://127.0.0.1:20001/?echo=abc-123&token=bee1f394-9bba-4867-a719-02a9f1ce30ca
    return indexService.index(model);

  }
}
