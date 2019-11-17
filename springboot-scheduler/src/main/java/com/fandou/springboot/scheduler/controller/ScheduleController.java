/**   
 * @Title: ScheduleController.java 
 * @Package com.fandou.springboot.scheduler.controller 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月5日 下午7:25:41
 * @version V0.0.1  
 */
package com.fandou.springboot.scheduler.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fandou.springboot.scheduler.service.ScheduleService;

/**
 * @Title: ScheduleController
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月5日 下午7:25:41
 * @version V0.0.1
 */
@RestController
public class ScheduleController {
	private Logger logger = LogManager.getLogger(ScheduleController.class);
	private String singleton = "singleton";
	
	public String getSingleton() {
		return singleton;
	}

	public void setSingleton(String singleton) {
		this.singleton = singleton;
	}

	@Autowired
	private ScheduleService scheduleService;
	
	@GetMapping("/")
	public String index() {
		logger.info("欢迎来到任务调度中心 ======> " + Thread.currentThread().getName());
		logger.info("欢迎来到任务调度中心  ScheduleController 默认声明的bean都是单例作用域 ======> " + this);
		logger.info("欢迎来到任务调度中心  singleton ======> " + singleton);
		scheduleService.backUpDatabase();
		this.singleton = "prototype";
		return singleton;
	}
	
	@GetMapping("/index")
	public String home() {
		logger.info("欢迎来到任务调度中心  ScheduleController ======> " + this);
		logger.info("欢迎来到任务调度中心  singleton ======> " + singleton);
		return singleton;
	}
}
