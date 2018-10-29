package top.leseul.springbootmybatisbase.service.serviceimpl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import top.leseul.springbootmybatisbase.dao.TbTokenDAO;
import top.leseul.springbootmybatisbase.dao.TbTokenInfoDAO;
import top.leseul.springbootmybatisbase.entity.TbToken;
import top.leseul.springbootmybatisbase.service.TokenService;
import top.leseul.springbootmybatisbase.utils.MyUtils;

/**
 * 
 * @author leseul
 *
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TokenServiceImpl implements TokenService {

  @Autowired
  private TbTokenDAO tbTokenDAO;

  @Autowired
  private TbTokenInfoDAO tbTokenInfoDAO;

  /**
   * -创建新的token
   * 
   * @return
   * @throws Exception
   */
  private TbToken newToken() throws Exception {
    TbToken token = new TbToken();
    token.setToken(UUID.randomUUID().toString());
    tbTokenDAO.addToken(token);
    return token;
  }

  @Override
  public TbToken checkToken(TbToken token) throws Exception {

    // 没有传入token就返回
    if (token == null || MyUtils.isEmpty(token.getToken())) {
      return newToken();
    }
    // 数据库校验
    TbToken stoken = tbTokenDAO.queryToken(token);
    // 校验不通过就返回
    if (stoken == null) {
      return newToken();
    }
    // 通过就更新时间
    tbTokenDAO.updateToken(stoken);
    return stoken;
  }

  @Override
  public int deleteTokens() throws Exception {
    //先删除tokenInfo
    tbTokenInfoDAO.deleteTbTokenInfos();
    //在删除token
    return tbTokenDAO.deleteTokens();
  }
}
