package top.leseul.springbootmybatisbase.dao;

import org.apache.ibatis.annotations.Mapper;

import top.leseul.springbootmybatisbase.entity.TbToken;
import top.leseul.springbootmybatisbase.entity.TbTokenInfo;

/**
 * -测试的dao
 * 
 * @author leseul
 *
 */
@Mapper
public interface TestDAO {

  /**
   * -添加tokeninfo
   * 
   * @param info
   * @return
   * @throws Exception
   */
  int addTokenInfo(TbTokenInfo tokenInfo) throws Exception;

  /**
   * -添加token
   * 
   * @param token
   * @return
   * @throws Exception
   */
  int addToken(TbToken token) throws Exception;

}
