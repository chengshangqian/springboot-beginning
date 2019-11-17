/**   
 * @Title: ScheduleService.java 
 * @Package com.fandou.springboot.scheduler.service 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月5日 下午5:23:47
 * @version V0.0.1  
 */
package com.fandou.springboot.scheduler.service;

/**
 * @Title: ScheduleService
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月5日 下午5:23:47
 * @version V0.0.1
 */
public interface ScheduleService {
	void fixedDelay();
	void fixedRate();
	void initialDelay();
	void cron();
	
	void generateAndSendSalesReports();
	void backUpDatabase();
}
