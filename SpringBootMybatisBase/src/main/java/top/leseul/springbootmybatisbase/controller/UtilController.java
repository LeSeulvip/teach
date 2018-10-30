package top.leseul.springbootmybatisbase.controller;

import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import top.leseul.springbootmybatisbase.model.UtilModel;
import top.leseul.springbootmybatisbase.service.UtilService;
import top.leseul.springbootmybatisbase.utils.ImageCode;

/**
 * -工具类控制器
 * 
 * @author leseul
 *
 */

@RestController
@RequestMapping("/util")
public class UtilController {

  @Autowired
  private UtilService utilService;

  @RequestMapping("/validate.jpg")
  public void imageCode(UtilModel model, HttpServletResponse response) throws Exception {
    // http:127.0.0.1:20001/util/validate.jpg?token=
    // 自定义应答类型
    response.setContentType("image/jpeg");
    // 自定义应答为图片
    String code = utilService.makeImageCode(model);
    // 将图片通过response输出
    OutputStream os = response.getOutputStream();
    ImageIO.write(ImageCode.makeImage(code), "jpeg", os);
    os.close();
  }



}
