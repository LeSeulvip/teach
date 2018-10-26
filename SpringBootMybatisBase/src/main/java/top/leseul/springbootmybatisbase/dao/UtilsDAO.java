package top.leseul.springbootmybatisbase.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Mapper;

/**
 * -工具类
 * 
 * @author DarkKnight
 *
 */
@Mapper
public interface UtilsDAO {
  /**
   * 查询系统时间
   * 
   * @return
   */
  Date queryTime();
}
