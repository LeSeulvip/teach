package top.leseul.springbootmybatisbase.dao;

import org.apache.ibatis.annotations.Mapper;

/**
 * TbTokenInfo的DAO
 * 
 * @author leseul
 *
 */
@Mapper
public interface TbTokenInfoDAO {
  /**
   * -删除所有过期的TokenInfo
   * 
   * @return
   * @throws Exception
   */
  int deleteTbTokenInfos() throws Exception;

}
