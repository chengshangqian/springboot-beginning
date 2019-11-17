/**   
 * @Title: ComputerServiceImpl.java 
 * @Package com.fandou.springboot.jdbc.service.impl 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月30日 下午9:59:08
 * @version V0.0.1  
 */
package com.fandou.springboot.batch.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fandou.springboot.batch.dao.ComputerDao;
import com.fandou.springboot.batch.model.Computer;
import com.fandou.springboot.batch.service.ComputerService;

/**
 * @Title: ComputerServiceImpl
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月30日 下午9:59:08
 * @version V0.0.1
 */
@Service
public class ComputerServiceImpl implements ComputerService {
	private Logger logger = LogManager.getLogger(ComputerServiceImpl.class);
	
	@Autowired
	ComputerDao computerDao;
	
	@Autowired
	JobLauncher jobLauncher;
	
	@Autowired
	Job job;
	
	
	/** 
	 * @Title: addComputer 
	 * @Description: 一句话描述方法的作用
	 * @param computer
	 * @return
	 */
	@Override
	public int addComputer(Computer computer) {
		return computerDao.addComputer(computer);
	}

	/** 
	 * @Title: getAllComputers 
	 * @Description: 一句话描述方法的作用
	 * @return
	 */
	@Override
	public List<Computer> getAllComputers() {
		List<Computer> list = new ArrayList<Computer>();
		list.addAll(computerDao.getAllComputers());
		return list;
	}

	/** 
	 * @Title: batchAddComputers 
	 * @Description: 一句话描述方法的作用
	 */
	@Override
	public void batchAddComputers() {
		try {
			/**
			 * Spring Batch需要每次唯一的作业参数来执行：如果参数相同，Spring Batch检查数据库如果记录在过去已经执行完成的，再次调用则不会被执行。
			 * 需要循环执行的任务或开发测试时，可以添加一个日期时间或随机数这类实时变化的参数保证任务每次都被执行。
			 */
			jobLauncher.run(job, new JobParametersBuilder().addDate("keep-executing-everytime", new Date()).toJobParameters());
			logger.info("批量添加计算机成功！");
		} catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException
				| JobParametersInvalidException e) {
			e.printStackTrace();
			logger.error("批量添加计算机失败 => " + e.getMessage());
		}
	}

}
