package top.leseul.service.impl;

import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import top.leseul.dao.TbTokenDAO;
import top.leseul.dao.UtilsDAO;
import top.leseul.service.TaskService;

/**
 * 定时任务服务实现，service层是dao层和controller层的中间层，负责处理业务逻辑
 * Scheduled注解是将方法编注为定时启动，initialDelay表示第一次启动延时，fixedDelay表示执行的间隔时间
 * cron表示在指定时间点执行 秒 分钟 小时 天 月 天
 * 
 * @author DarkKnight
 *
 */
@Service
public class TaskServiceImpl implements TaskService {

  private static final Logger log = LoggerFactory.getLogger(TaskServiceImpl.class);
  @Autowired
  private UtilsDAO utilsDAO;
  @Autowired
  private TbTokenDAO tbTokenDAO;
  private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

  @Scheduled(initialDelay = 1000 * 5, fixedDelay = 60 * 60 * 1000)
  @Override
  public void showTime() {
    log.debug(String.format("数据库当前时间：%s", SDF.format(utilsDAO.queryTime())));
  }

  @Scheduled(cron = "0 18,19,20 9 * * ? ")
  @Override
  public void showTimeOnce() {
    log.debug(String.format("整点报时：%s", SDF.format(utilsDAO.queryTime())));
  }

  @Override
  @Scheduled(initialDelay = 3 * 1000, fixedDelay = 5 * 60 * 1000)
  public void deleteToken() {
    log.debug("正在启动删除过期token任务");
    int result;
    try {
      result = tbTokenDAO.deleteToken();
    } catch (Exception e) {
      log.error("删除过期token任务发送错误", e);
      result = 0;
    }
    log.debug("删除过期token任务完成:" + result);

  }

}
