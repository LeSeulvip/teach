package top.leseul.springbootmybatisbase.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * -控制器日志切面
 * 
 * @author leseul
 *
 */

@Aspect
@Component
public class ControllerLogger extends AppPointCut {

  private static final Logger log = LoggerFactory.getLogger(ControllerLogger.class);

  /**
   * Before是前置拦截,在执行切面拦截的方法之前会执行
   * 
   * @param jp
   */
  @Before("controller()")
  public void before(JoinPoint jp) {
    // getSignature方法会返回切点拦截的方法前面
    log.debug(String.format("进入=================>%s", jp.getSignature()));
    Object[] args = jp.getArgs();
    if (args == null || args.length == 0) {
      log.debug("方法没有参数");
    } else {
      log.debug("参数列表");
      for (Object arg : args) {
        log.debug(arg + "");
      }
    }
  }

  /**
   * After表示切点方法执行之后
   * 
   * @param jp
   */
  @After("controller()")
  public void after(JoinPoint jp) {
    log.debug("%s执行完毕:%s" + jp.getSignature());
  }

  /**
   * AfterReturning表示切点返回后,所以要多一个参数returning来获取方法的返回值
   * 
   * @param jp
   * @param result
   */
  @AfterReturning(pointcut = "controller()", returning = "result")
  public void returning(JoinPoint jp, Object result) {
    log.debug(String.format("%s的返回值:%s", jp.getSignature(), result));
  }

}
