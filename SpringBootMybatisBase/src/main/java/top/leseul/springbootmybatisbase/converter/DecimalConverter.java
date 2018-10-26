package top.leseul.springbootmybatisbase.converter;

import java.math.BigDecimal;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import top.leseul.springbootmybatisbase.utils.MyUtils;

/**
 * BigDecimal数值转换器
 * 
 * @author leseul
 *
 */
@Component
public class DecimalConverter implements Converter<String, BigDecimal> {

  @Override
  public BigDecimal convert(String source) {

    if (MyUtils.isEmpty(source)) {
      return null;
    }
    source = MyUtils.trim(source);
    try {
      return new BigDecimal(source);
    } catch (Exception e) {
    }
    return null;
  }

}
