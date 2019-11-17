/**   
 * @Title: ComputerController.java 
 * @Package com.fandou.springboot.chapter05.controller 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @color 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月29日 下午10:27:25
 * @version V0.0.1  
 */
package com.fandou.springboot.jpa.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fandou.springboot.jpa.model.Computer;
import com.fandou.springboot.jpa.service.ComputerService;

/**
 * @Title: ComputerController
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @color 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月29日 下午10:27:25
 * @version V0.0.1
 */
@RestController
public class ComputerController {
	private Logger logger = LogManager.getLogger(ComputerController.class);
	
	@Autowired
	ComputerService computerService;
	
	@GetMapping("/computer/max")
	public Computer getMaxComputer() {
		logger.debug("===> getMaxComputer");
		return computerService.getMaxIdComputer();
	}
	
	@GetMapping("/computer/last")
	public Computer getLastComputer() {
		logger.debug("===> getMaxComputer");
		return computerService.getLastComputer();
	}
	
	@GetMapping("/computer/add")
	public Computer addComputer() {
		logger.debug("===> addComputer");
		Computer computer = new Computer();
		computer.setModel("神州一号");
		computer.setName("Acer");
		computerService.addComputer(computer);
		return computer;
	}
}
