package top.leseul.springbootmybatisbase.service;

import top.leseul.springbootmybatisbase.entity.TbTokenInfo;
import top.leseul.springbootmybatisbase.model.UtilModel;

/**
 * -工具类服务
 * 
 * @author leseul
 *
 */
public interface UtilService {

  /**
   * -生成图片校验码
   * 
   * @param model
   * @return
   * @throws Exception
   */
  String makeImageCode(UtilModel model) throws Exception;

  /**
   * -删除过期的图片校验码,服务器段的图片校验码只能使用一次
   * 
   * @param tokenInfo
   * @return
   * @throws Exception
   */
  boolean checkImageCode(TbTokenInfo tokenInfo) throws Exception;

}
