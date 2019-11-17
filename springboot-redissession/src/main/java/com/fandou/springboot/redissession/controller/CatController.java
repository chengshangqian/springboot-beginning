/**   
 * @Title: RedisController.java 
 * @Package com.fandou.springboot.redis.controller 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月31日 下午12:01:32
 * @version V0.0.1  
 */
package com.fandou.springboot.redissession.controller;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fandou.springboot.redissession.model.Cat;
import com.fandou.springboot.redissession.service.CatService;

/**
 * @Title: RedisController
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月31日 下午12:01:32
 * @version V0.0.1
 */
@RestController
public class CatController {
	private Logger logger = LogManager.getLogger(CatController.class);
	private String key = "c95";
	@Autowired
	CatService catService;
	
	/*********************Redis(Jedis) 操作***********************/
	@GetMapping("/cat/getCat")
	public Cat getCat() {
		logger.debug("====> getCat");
		return catService.getCat(key);
	}
	
	@GetMapping("/cat/saveCat")
	public Cat saveCat() {
		logger.debug("====> saveCat");
		Cat jerry = new Cat();
		jerry.setId(1);
		jerry.setName("Jerry");
		jerry.setColor("Yellow");
		catService.saveCat(key,jerry);
		return jerry;
	}
	
	@GetMapping("/cat/getName")
	public String getCatName() {
		logger.debug("====> getCatName");
		return catService.getCatName(key+"=>name");
	}
	
	@GetMapping("/cat/saveName")
	public String saveCatName() {
		logger.debug("====> saveCatName");
		catService.saveCatName(key+"=>name","Jerry");
		return "Jerry";
	}
	
	/*********************Session 操作***********************/
	@Value("${server.port}")
	String port;
	
	@GetMapping("/cat/setSession")
	public String setSessionAttribute(String name,String value,HttpSession session) {
		logger.debug(port + "/cat/setSession?name=" + name + "&value=" + value);
		session.setAttribute(name, value);
		return port;
	}
	
	@GetMapping("/cat/getSession")
	public String getSessionAttribute(String name,HttpSession session) {
		logger.debug(port + "/cat/getSession?name=" + name);
		
		Object sessionValue = session.getAttribute(name);
		String value = null == sessionValue ? "空值" : sessionValue.toString();
		
		return port + " : [" + name + " => " + value + "]";
	}
	
	@GetMapping("/")
	public String index(String name,HttpSession session) {
		logger.debug(port + " ===> 访问了首页");
		
		Object sessionValue = session.getAttribute(name);
		String value = null == sessionValue ? "空值" : sessionValue.toString();
		
		return port + " : [" + name + " => " + value + "]";
	}
}
