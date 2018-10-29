package top.leseul.springbootmybatisbase.converter;

import org.springframework.core.convert.converter.Converter;

import top.leseul.springbootmybatisbase.utils.MyUtils;

/**
 * -字符串转换器(去空)
 * 
 * @author leseul
 *
 */
public class StringConverter implements Converter<String, String> {

  @Override
  public String convert(String source) {
    return MyUtils.trim(source);
  }

}
