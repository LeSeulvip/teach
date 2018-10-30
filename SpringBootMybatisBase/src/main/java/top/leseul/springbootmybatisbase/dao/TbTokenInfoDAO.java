package top.leseul.springbootmybatisbase.dao;

import org.apache.ibatis.annotations.Mapper;

import top.leseul.springbootmybatisbase.entity.TbTokenInfo;

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

  /**
   * - 添加图片校验码
   * 
   * @param tokenInfo
   * @return
   * @throws Exception
   */
  int addImageCode(TbTokenInfo tokenInfo) throws Exception;

  /**
   * -查询图片校验码
   * 
   * @param tokenInfo
   * @return
   * @throws Exception
   */
  TbTokenInfo queryImageCode(TbTokenInfo tokenInfo) throws Exception;

  /**
   * -更新图片校验码
   * 
   * @param tokenInfo
   * @return
   * @throws Exception
   */
  int updateImageCode(TbTokenInfo tokenInfo) throws Exception;

  /**
   * -删除图片校验码
   * 
   * @param tokenInfo
   * @return
   * @throws Exception
   */
  int deleteImageCode(TbTokenInfo tokenInfo) throws Exception;

}
