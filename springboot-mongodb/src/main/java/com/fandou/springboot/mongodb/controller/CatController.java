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
package com.fandou.springboot.mongodb.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fandou.springboot.mongodb.model.Cat;
import com.fandou.springboot.mongodb.service.CatService;

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
	
	@Autowired
	CatService catService;
	
	/*********************MongoDB 操作***********************/
	@GetMapping("/cat/findByColor")
	public List<Cat> findByColor(){
		String color = "WhiteBlack";
		return catService.findByColorEquals(color);
	}
	
	@GetMapping("/cat/findByName")
	public Cat findByName() {
		String name = "Jerry";
		return catService.findByNameEquals(name);
	}
	
	@GetMapping("/cat/add")
	public Cat addCat() {
		Cat cat = new Cat();
		cat.setId(21);
		cat.setName("C95");
		cat.setColor("Yellow");		
		return catService.addCat(cat);
	}
	
	@GetMapping("/cat/update")
	public Cat updateCat() {
		Cat cat = new Cat();
		cat.setId(11);
		cat.setName("成九五");
		cat.setColor("Yellow");			
		return catService.updateCat(cat);
	}
	
	@GetMapping("/cat/delete")
	public String deleteCat() {
		Integer id = 1;
		catService.deleteCat(id);
		return "success";
	}
	
	@GetMapping("/cat/init")
	public String initMongoDB() {
		logger.debug("初始化MongoDB => initMongoDB");
		for(int i = 0; i < 6; i++) {
			Cat cat = new Cat();
			cat.setId(i+1);
			cat.setName("Mickey" + i);
			cat.setColor("WhiteBlack");
			catService.addCat(cat);
		}
		
		Cat a = new Cat();
		a.setId(12);
		a.setName("Nomi");
		a.setColor("WhiteBlack");
		catService.addCat(a);
		
		Cat b = new Cat();
		b.setId(11);
		b.setName("Jerry");
		b.setColor("Yellow");
		catService.addCat(b);		
		
		Cat c = new Cat();
		c.setId(10);
		c.setName("Mickey");
		c.setColor("WhiteBlack");
		catService.addCat(c);
		
		return "success";
	}
	
	/**
	 * @Title: initBatchOptions 
	 * @Description: 一句话描述方法的作用
	 * @return
	 */
	@GetMapping("/cat/insert")
	public String initBatchOptions() {
		
		List<Cat> cats = new ArrayList<Cat>();
		for(int i = 25; i < 30; i++) {
			Cat cat = new Cat();
			cat.setId(i+1);
			cat.setName("CC" + i);
			cat.setColor("Blue");
			cats.add(cat);
		}
		catService.insertCats(cats);
		
		return "success";
	}
}
