/**   
 * @Title: ComputerController.java 
 * @Package com.fandou.springboot.jdbc.controller 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月30日 下午10:04:12
 * @version V0.0.1  
 */
package com.fandou.springboot.batch.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fandou.springboot.batch.model.Computer;
import com.fandou.springboot.batch.service.ComputerService;

/**
 * @Title: ComputerController
 * @Description: TODO(一句话描述该类的业务或功能)
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月30日 下午10:04:12
 * @version V0.0.1
 */
@RestController
public class ComputerController {
	private Logger logger = LogManager.getLogger(ComputerController.class);

	@Autowired
	ComputerService computerService;

	@GetMapping("/computers")
	public List<Computer> computers() {
		logger.debug("======> computers");
		return computerService.getAllComputers();
	}

	@GetMapping("/computer/add")
	public Computer addComputer() {
		logger.debug("======> addComputer");
		Computer computer = new Computer();
		computer.setName("Apple");
		computer.setModel("Macbook Pro");
		computerService.addComputer(computer);
		logger.debug("computer.id ======> " + computer.getId());
		return computer;
	}

	/**
	 * @Title: executeBatchJob 
	 * @Description: 执行批量作业
	 * @param job
	 * @return
	 */
	@GetMapping("/api/batch/{job}")
	public String executeBatchJob(@PathVariable String job) {
		
		logger.debug(" job ======> " + job);
		
		switch (job) {
			case "batchAddComputers":
				logger.debug("批量添加计算机 ======> ");
				computerService.batchAddComputers();
				break;
			case "batchUpdateComputers":
				logger.debug("批量更新计算机 ======> ");
				// computerService.batchUpdateComputers();
				break;
			default:
				logger.debug("缺省操作 ======> Do Nothing.");
				// computerService.batchDefaultOptions();
		}

		return "success";
	}
}
