/**   
 * @Title: CorsController.java 
 * @Package com.fandou.springboot.chapter04 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月29日 下午12:02:38
 * @version V0.0.1  
 */
package com.fandou.springboot.chapter04.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fandou.springboot.chapter04.model.Cat;

/**
 * @Title: CorsController
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月29日 下午12:02:38
 * @version V0.0.1
 */
@RestController
@RequestMapping("/api/cat")
public class CorsController {
	private Logger logger = LogManager.getLogger(CorsController.class);
	@GetMapping("/get")
	//@CrossOrigin(value="http://localhost:9997",maxAge=1800,allowedHeaders="*")
	public Cat get(Cat c) {
		logger.debug(" => " + c.getName() + " : " + c.getColor());
		Cat cat = new Cat();
		cat.setColor("Yellow");
		cat.setName("Jerry");
		return cat;
	}
	
	@GetMapping("/delete/{id}")
	//@CrossOrigin(value="http://localhost:9997",maxAge=1800,allowedHeaders="*")
	public String delete(Cat c,@PathVariable String id) {
		logger.debug(" => " + c.getName() + " : " + c.getColor());
		return id;
	}
}
