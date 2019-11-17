/**   
 * @Title: CatController.java 
 * @Package com.fandou.springboot.redis.controller 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月31日 下午12:01:32
 * @version V0.0.1  
 */
package com.fandou.springboot.rediscluster.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fandou.springboot.rediscluster.model.Cat;
import com.fandou.springboot.rediscluster.service.CatService;

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
		/*
		long startTime = System.currentTimeMillis();
		for(int i = 0; i < 10000; i++) {
			logger.debug("第" + (i + 1) + "次 getCatName ====> " + catService.getCatName(key+"=>name"));
		}
		long endTime = System.currentTimeMillis();
		logger.debug("读取10000次花费时间 ====> " + ((endTime - startTime) / 1000 ) + " 秒");//60秒左右
		*/
		
		logger.debug("====> getCatName");
		return catService.getCatName(key+"=>name");
	}
	
	@GetMapping("/cat/saveName")
	public String saveCatName() {
		logger.debug("====> saveCatName");
		catService.saveCatName(key+"=>name","Jerry");
		return "Jerry";
	}
}
