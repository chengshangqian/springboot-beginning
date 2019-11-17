/**   
 * @Title: ScheduleServiceImpl.java 
 * @Package com.fandou.springboot.scheduler.service.impl 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月5日 下午5:30:15
 * @version V0.0.1  
 */
package com.fandou.springboot.scheduler.service.impl;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.fandou.springboot.scheduler.service.ScheduleService;

/**
 * @Title: ScheduleServiceImpl
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月5日 下午5:30:15
 * @version V0.0.1
 */
@Service
public class ScheduleServiceImpl implements ScheduleService {
	private Logger logger = LogManager.getLogger(ScheduleServiceImpl.class);

	/** 
	 * @Title: fixedDelay 
	 * @Description: 每次任务【结束】2秒后开始执行下一次任务
	 */
	@Override
	//@Scheduled(fixedDelay = 2000)
	public void fixedDelay() {
		logger.info("fixedDelay 每次任务结束2秒后  => " + new Date());
	}

	/** 
	 * @Title: fixedRate 
	 * @Description: 本次任务执行2秒后开始执行下次任务【不管本次是否结束】：即间隔2秒执行一次任务，不管之前的任务是否结束
	 */
	@Override
	//@Scheduled(fixedRate = 2000)
	public void fixedRate() {
		logger.info("fixedRate 每次任务间隔2秒：" + new Date());
	}

	/** 
	 * @Title: initialDelay 
	 * @Description: 首次执行延迟10秒（未设置则默认系统启动即立即执行首次任务）：系统启动10秒后开始执行首次任务，然后每隔2秒执行一次
	 */
	@Override
	//@Scheduled(initialDelay = 10000,fixedRate = 2000)
	public void initialDelay() {
		logger.info("initialDelay 首次执行延迟10秒 => " + new Date());
		logger.info("默认声明的bean都是单例作用域 ScheduleServiceImpl initialDelay => " + this);
	}

	/** 
	 * @Title: cron 
	 * @Description: 每分钟执行一次
	 */
	@Override
	//@Scheduled(cron = "0 * * * * ?")
	public void cron() {
		logger.info("cron 每分钟调用一次 => " + new Date());
		logger.info("默认声明的bean都是单例作用域 ScheduleServiceImpl cron => " + this);
	}

	/** 
	 * @Title: generateAndSendSalesReports 
	 * @Description: 每天凌晨2点生成并发送昨天的销售报告:0 0 2 * * ? 
	 */
	@Override
	public void generateAndSendSalesReports() {
		logger.info("generateAndSendSalesReports 每天凌晨2点生成并发送昨天的销售报告 => " + new Date());
		//TODO 业务代码：编写相关代码或调用相关服务完成销售报告的生成和发送
		logger.info("默认声明的bean都是单例作用域 ScheduleServiceImpl generateAndSendSalesReports => " + this);
	}

	/** 
	 * @Title: backUpDatabase 
	 * @Description: 每天凌晨4点备份数据库:0 0 4 * * ? 
	 */
	@Override
	public void backUpDatabase() {
		logger.info("backUpDatabase 每天凌晨4点备份数据库 => " + new Date());
		//TODO 业务代码：编写相关代码或调用相关服务完成系统数据库备份
		logger.info("默认声明的bean都是单例作用域 ScheduleServiceImpl backUpDatabase => " + this);
	}
}
