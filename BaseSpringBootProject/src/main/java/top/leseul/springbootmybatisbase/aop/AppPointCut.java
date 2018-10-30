package top.leseul.springbootmybatisbase.aop;

import org.aspectj.lang.annotation.Pointcut;

/**
 * -应用程序且切点定义
 * 
 * @author leseul
 *
 */
public class AppPointCut {

  /**
   * Pointcut是切面的表达式,表示切面类拦截的class <br>
   * executinon是执行的意思,参数是切面表达式 public<br>
   * * 表示必须是public类型的才会被拦截<br>
   * .. 表示无限层级,第一个 * 是类名称,表示任意类名称都会被拦截 <br>
   * 第二个 * 号是方法名称,表示任意方法都会被拦截,如果写成 get* 则表示只有get开头的方法才会被拦截
   */
  @Pointcut("execution(public * top.leseul.springbootmybatisbase.controller..*.*(..))")
  public void controller() {

  }
}
