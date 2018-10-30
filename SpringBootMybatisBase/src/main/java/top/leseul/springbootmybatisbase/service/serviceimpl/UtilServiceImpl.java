package top.leseul.springbootmybatisbase.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import top.leseul.springbootmybatisbase.dao.TbTokenInfoDAO;
import top.leseul.springbootmybatisbase.entity.TbTokenInfo;
import top.leseul.springbootmybatisbase.model.UtilModel;
import top.leseul.springbootmybatisbase.service.UtilService;
import top.leseul.springbootmybatisbase.utils.ImageCode;
import top.leseul.springbootmybatisbase.utils.MyUtils;

@Service
@Transactional(rollbackFor = Exception.class)
public class UtilServiceImpl implements UtilService {

  @Autowired
  private TbTokenInfoDAO tbTokenInfoDAO;

  @Override
  public String makeImageCode(UtilModel model) throws Exception {
    // 产生图片校验码
    String code = ImageCode.makeCode();
    // 获取图片校验码
    TbTokenInfo tokenInfo = model.getTbTokenInfo();
    // 判断图片校验码是否存在
    TbTokenInfo sinfo = tbTokenInfoDAO.queryImageCode(tokenInfo);
    if (sinfo == null) {
      // 不存在就将图片code写入
      tokenInfo.setInfo(code);
      tbTokenInfoDAO.addImageCode(tokenInfo);
    } else {
      // 存在就更新图片code
      tokenInfo.setInfo(code);
      tbTokenInfoDAO.updateImageCode(sinfo);
    }
    return code;
  }

  @Override
  public boolean checkImageCode(TbTokenInfo tokenInfo) throws Exception {
    // code不存在就返回错误
    if (MyUtils.isEmpty(tokenInfo.getInfo())) {
      return false;
    }
    TbTokenInfo sinfo = tbTokenInfoDAO.queryImageCode(tokenInfo);
    if (sinfo == null) {
      // 不存在就返回false
      return false;
    }
    // 删除数据库中的code(只能使用一次)
    tbTokenInfoDAO.deleteImageCode(sinfo);
    // 返回数据库中code和传入code对比结果
    return sinfo.getInfo().equalsIgnoreCase(tokenInfo.getInfo());
  }

}
