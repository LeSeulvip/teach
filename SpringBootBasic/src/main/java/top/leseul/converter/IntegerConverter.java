package top.leseul.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import top.leseul.utils.MyUtils;

/**
 * Integer数值转换器
 * 
 * @author leseul
 *
 */

@Component
public class IntegerConverter implements Converter<String, Integer> {

  @Override
  public Integer convert(String source) {
    if (MyUtils.isEmpty(source)) {
      return null;
    }
    source = MyUtils.trim(source);
    try {
      // 长日期格式
      return Integer.parseInt(source);
    } catch (Exception ex) {
    }
    return null;
  }
}
