package top.leseul.springbootmybatisbase.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import top.leseul.springbootmybatisbase.utils.MyUtils;

/**
 * Double 数值转换器
 * 
 * @author leseul
 *
 */

@Component
public class DoubleConverter implements Converter<String, Double> {

  @Override
  public Double convert(String source) {
    if (MyUtils.isEmpty(source)) {
      return null;
    }
    source = MyUtils.trim(source);
    try {
      return Double.valueOf(source);
    } catch (Exception e) {
    }
    return null;
  }

}
