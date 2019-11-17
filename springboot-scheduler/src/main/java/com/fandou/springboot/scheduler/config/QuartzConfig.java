/**   
 * @Title: QuartzConfig.java 
 * @Package com.fandou.springboot.scheduler.config 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月5日 下午6:21:35
 * @version V0.0.1  
 */
package com.fandou.springboot.scheduler.config;

import org.quartz.CronTrigger;
import org.quartz.SimpleTrigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

import com.fandou.springboot.scheduler.service.ScheduleService;

/**
 * @Title: QuartzConfig
 * @Description: TODO(一句话描述该类的业务或功能)
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月5日 下午6:21:35
 * @version V0.0.1
 */
@Configuration
public class QuartzConfig {
	@Autowired
	private ScheduleService scheduleService;

	/**************************** 定义任务 *****************************/
	/**
	 * @Title: initialDelay
	 * @Description: 简单任务示例
	 * @return
	 */
	@Bean
	MethodInvokingJobDetailFactoryBean initialDelay() {
		MethodInvokingJobDetailFactoryBean bean = new MethodInvokingJobDetailFactoryBean();
		//bean.setTargetBeanName("scheduleService");
		bean.setTargetObject(scheduleService);
		bean.setTargetMethod("initialDelay");
		return bean;
	}

	/**
	 * @Title: cron
	 * @Description: 表达式任务示例
	 * @return
	 */
	@Bean
	MethodInvokingJobDetailFactoryBean cron() {
		MethodInvokingJobDetailFactoryBean bean = new MethodInvokingJobDetailFactoryBean();
		//bean.setTargetBeanName("scheduleService");
		bean.setTargetObject(scheduleService);
		bean.setTargetMethod("cron");
		return bean;
	}

	/**
	 * @Title: generateAndSendSalesReports
	 * @Description: 生产并发送销售报告
	 * @return
	 */
	@Bean
	MethodInvokingJobDetailFactoryBean generateAndSendSalesReports() {
		MethodInvokingJobDetailFactoryBean bean = new MethodInvokingJobDetailFactoryBean();
		//bean.setTargetBeanName("scheduleService");
		bean.setTargetObject(scheduleService);
		bean.setTargetMethod("generateAndSendSalesReports");
		return bean;
	}

	/**
	 * @Title: backUpDatabase
	 * @Description: 备份数据库数据
	 * @return
	 */
	@Bean
	MethodInvokingJobDetailFactoryBean backUpDatabase() {
		MethodInvokingJobDetailFactoryBean bean = new MethodInvokingJobDetailFactoryBean();
		//bean.setTargetBeanName("scheduleService");
		bean.setTargetObject(scheduleService);
		bean.setTargetMethod("backUpDatabase");
		return bean;
	}

	/**************************** 定义任务触发器 *****************************/

	/**
	 * @Title: initialDelayTrigger
	 * @Description: 简单任务示例触发器：系统启动10秒后开始执行第一次任务，后续间隔2秒运行一次，总共运行1+5次
	 * @return
	 */
	@Bean
	SimpleTriggerFactoryBean initialDelayTrigger() {
		SimpleTriggerFactoryBean bean = new SimpleTriggerFactoryBean();
		bean.setJobDetail(initialDelay().getObject());
		bean.setStartDelay(10000);
		bean.setRepeatInterval(2000);
		bean.setRepeatCount(5);// 首次运行后，再（Repeat）执行5次
		return bean;
	}

	/**
	 * @Title: cronTrigger
	 * @Description: 表达式任务示例触发器：每分钟触发一次
	 * @return
	 */
	@Bean
	CronTriggerFactoryBean cronTrigger() {
		CronTriggerFactoryBean bean = new CronTriggerFactoryBean();
		bean.setJobDetail(cron().getObject());
		bean.setCronExpression("0 * * * * ?");
		return bean;
	}

	/**
	 * @Title: generateAndSendSalesReportsTrigger
	 * @Description: 每天凌晨2点触发
	 * @return
	 */
	@Bean
	CronTriggerFactoryBean generateAndSendSalesReportsTrigger() {
		CronTriggerFactoryBean bean = new CronTriggerFactoryBean();
		bean.setJobDetail(generateAndSendSalesReports().getObject());
		bean.setCronExpression("0 0 2 * * ?");
		return bean;
	}

	/**
	 * @Title: backUpDatabaseTrigger
	 * @Description: 每天凌晨4点触发
	 * @return
	 */
	@Bean
	CronTriggerFactoryBean backUpDatabaseTrigger() {
		CronTriggerFactoryBean bean = new CronTriggerFactoryBean();
		bean.setJobDetail(backUpDatabase().getObject());
		bean.setCronExpression("0 0 4 * * ?");
		return bean;
	}

	/**************************** 注册任务调度 *****************************/
	/**
	 * @Title: schedulerFactoryBean
	 * @Description: 定义任务调度
	 * @return
	 */
	SchedulerFactoryBean schedulerFactoryBean() {
		SchedulerFactoryBean scheduler = new SchedulerFactoryBean();
		SimpleTrigger initialDelayTrigger = initialDelayTrigger().getObject();
		CronTrigger cronTrigger = cronTrigger().getObject();
		CronTrigger generateAndSendSalesReportsTrigger = generateAndSendSalesReportsTrigger().getObject();
		CronTrigger backUpDatabaseTrigger = backUpDatabaseTrigger().getObject();

		scheduler.setTriggers(initialDelayTrigger, cronTrigger, generateAndSendSalesReportsTrigger,
				backUpDatabaseTrigger);
		return scheduler;
	}
}
