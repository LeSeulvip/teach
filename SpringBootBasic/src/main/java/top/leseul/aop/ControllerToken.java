package top.leseul.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import top.leseul.entity.JsonMessage;
import top.leseul.entity.TbToken;
import top.leseul.model.BaseMoel;
import top.leseul.service.TokenService;

/**
 * 环绕切面
 * 
 * @author leseul
 *
 */
@Aspect
@Component
public class ControllerToken {

  @Pointcut("execution(public * top.leseul.controller..*.*(..))")
  public void pointcut() {
  }

  private static final Logger log = LoggerFactory.getLogger(ControllerToken.class);

  /**
   * Around表示环绕切面,带有被切面的方法返回值,切点信息和异常抛出
   * 
   * @param pjp
   * @return
   * @throws Exception
   */
  @Around("pointcut()")
  public Object token(ProceedingJoinPoint pjp) throws Throwable {
    // 前置=============================
    // getTarget获取切面的类型
    log.debug("被切面的类型:" + pjp.getTarget().getClass().getName());
    log.debug("即将执行:" + pjp.getSignature());
    StringBuilder sb = new StringBuilder();
    Object[] args = pjp.getArgs();
    if (args == null || args.length == 0) {
      log.debug("没有参数");
    } else {
      for (Object arg : args) {
        sb.append(arg).append("\r\n");
      }
      log.debug(sb.toString());
    }
    // 进入控制器之前要检查客户端的token信息====================
    TbToken token = processToken(pjp);
    // 分界点,proceed方法表示执行切点方法并获取返回值
    Object result = pjp.proceed();
    // 尾置
    log.debug(String.format("%s执行完毕", pjp.getSignature()));
    // 返回值
    log.debug(String.format("%s的返回值是:%s", pjp.getSignature(), result));
    // 返回值需要加入token信息======================================
    if (result instanceof JsonMessage && token != null) {
      JsonMessage message = (JsonMessage) result;
      message.setToken(token.getToken());
    }
    return result;

  }

  /**
   * -处理客户端传入的token信息
   * 
   * @param pjp
   * @return
   * @throws Exception
   */
  private TbToken processToken(ProceedingJoinPoint pjp) throws Exception {
    TbToken token = null;
    BaseMoel model = null;
    // 检查参数是否存在model
    Object[] args = pjp.getArgs();
    for (Object arg : args) {
      if (arg instanceof BaseMoel) {
        model = (BaseMoel) arg;
        break;
      }
    }
    // 如果BaseModel存在就校验token信息
    if (model != null) {
      token = tokenService.checkTbToken(model.makeTokenInfo());
    }
    return token;
  }

  @Autowired
  private TokenService tokenService;
}
