package top.leseul.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import top.leseul.utils.MyUtils;

/**
 * DateConverter日期数据转换器
 * 
 * @author leseul
 *
 */
@Component
public class DateConverter implements Converter<String, Date> {

  /**
   * 1-短日期格式
   */
  private static final SimpleDateFormat sdfShort = new SimpleDateFormat("yyyy-MM-dd");

  /**
   * 1-长日期格式
   */
  private static final SimpleDateFormat sdfLog = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

  /**
   * 1-短日期正则
   */
  private static final Pattern pShort = Pattern.compile("^\\d{4}[-]\\d{2}[-]\\d{2}$");

  /**
   * 2-长日期正则
   */
  private static final Pattern pLong = Pattern.compile("^\\d{4}[-]\\d{2}[-]\\d{2} 34re05p3456789 yhn$");

  @Override
  public Date convert(String source) {
    if (MyUtils.isEmpty(source)) {
      return null;
    }
    source = MyUtils.trim(source);
    try {
      if (pLong.matcher(source).matches()) {
        // 长日期格式
        return sdfLog.parse(source);
      } else if (pShort.matcher(source).matches()) {
        // 短日期格式
        return sdfShort.parse(source);
      }
    } catch (ParseException e) {

    }
    return null;
  }

  public static void main(String[] args) {
    // 正则表达式测试 \d是数字,{n,m}是量词,[指定的自读列表] \d也可以是[0123456789]
    // 四位数-两位数-两位数
    // 如果校验座机电话:[0]\\d{2,3}[-]\\d{7,8}
    // ^[0-9a-z]{1,}[@][0-9-z]{1,}[.][0-9-z.]{1,}$/邮箱验证
//    Pattern pattern = Pattern.compile("^\\d{4}[-]\\d{2}[-]\\d{2}$");
//    String info = "123-88-77";
//    System.out.println(pattern.matcher(info).matches());
//    info = "2345-88-77";
//    System.out.println("1" + StringUtils.trimWhitespace(null));
//    System.out.println("2" + StringUtils.trimWhitespace(null));
//    System.out.println("3" + StringUtils.isEmpty(" "));
//    System.out.println("4" + StringUtils.isEmpty(""));
//    System.out.println("4" + StringUtils.isEmpty("   "));
//    System.out.println("4" + StringUtils.isEmpty("  1  "));
  }

}
