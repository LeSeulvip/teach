package top.leseul.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import top.leseul.entity.TbToken;

/**
 * TestDAO
 * 
 * @author leseul
 *
 */
@Mapper
public interface TestDAO {
  /**
   * TbToken的分页查询
   * 
   * @return
   * @throws Exception
   */
  List<TbToken> queryTokens() throws Exception;

}
