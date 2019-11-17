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
package com.fandou.springboot.chapter05.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fandou.springboot.chapter04.model.Computer;
import com.fandou.springboot.chapter05.service.ComputerService;

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
	
	@GetMapping("/computers")
	public List<Computer> computers() {
		logger.debug("======> computers");
		PageRequest pageable = PageRequest.of(2, 3);
		Page<Computer> page = computerService.getComputerByPage(pageable);
		logger.debug("总页数  => " + page.getTotalPages());
		logger.debug("总记录数  => " + page.getTotalElements());
		logger.debug("当前页数  => " + (page.getNumber() + 1));
		logger.debug("当前页记录数  => " + page.getNumberOfElements());
		logger.debug("每页记录数  => " + page.getSize());
		List<Computer> list = page.getContent();
		return list;
	}
	
	@GetMapping("/computer/get")
	public Computer getMaxComputer() {
		return computerService.getMaxIdComputer();
	}
	
	@GetMapping("/computer/search")
	public List<Computer> search() {
		List<Computer> list = computerService.getComputerByNameStartingWith("Think");
		return list;
	}
	
	@GetMapping("/computer/query")
	public List<Computer> query() {
		List<Computer> list = computerService.getComputerByNameAndId("Think",5);
		return list;
	}
	
	@GetMapping("/computer/add")
	public Computer addComputer() {
		Computer computer = new Computer();
		computer.setModel("cto-x230");
		computer.setName("Thinkpad");
		computerService.addComputer(computer);
		return computer;
	}
	
	@GetMapping("/computer/init")
	public void init() {

		
		for(int i = 0; i < 5; i++) {
			Computer computer = new Computer();
			computer.setName("Thinkpad");
			computer.setModel("x" + (i+1) + "10");
			computerService.addComputer(computer);
		}
		
		for(int i = 1; i < 4; i++) {
			Computer computer = new Computer();
			computer.setName("Thinkpad");
			computer.setModel("x" + (i+1) + "30");
			computerService.addComputer(computer);
		}
	}
}
