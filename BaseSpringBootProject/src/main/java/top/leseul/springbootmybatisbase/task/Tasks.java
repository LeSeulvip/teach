package top.leseul.springbootmybatisbase.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import top.leseul.springbootmybatisbase.service.TokenService;

/**
 * -定时任务
 * 
 * @author leseul
 *
 */
@Component
public class Tasks {

  private static final Logger log = LoggerFactory.getLogger(Tasks.class);

  @Autowired
  private TokenService tokenService;

  @Scheduled(initialDelay = 3 * 1000, fixedDelay = 5 * 60 * 1000)
  public void deleteTokens() {
    try {
      log.debug("正在删除过期的token");
      int result = tokenService.deleteTokens();
      log.debug(String.format("删除过期的token完成,数量为:%s", result));
    } catch (Exception ex) {
      log.error("删除过期的token发生错误", ex);
    }
  }

}
