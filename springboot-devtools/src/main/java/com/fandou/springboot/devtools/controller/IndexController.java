/**   
 * @Title: IndexController.java 
 * @Package com.fandou.springboot.devtools.controller 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月1日 下午2:25:30
 * @version V0.0.1  
 */
package com.fandou.springboot.devtools.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fandou.springboot.devtools.model.Cat;

/**
 * @Title: IndexController
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月1日 下午2:25:30
 * @version V0.0.1
 */
@Controller
public class IndexController {
	private Logger logger = LogManager.getLogger(IndexController.class);
	
	@GetMapping("/")
	public ModelAndView idx() {
		
		return new ModelAndView("index");
	}
	
	@GetMapping("/index")
	public ModelAndView index() {
		
		return new ModelAndView("index");
	}
	
	@GetMapping("/welcome")
	public ModelAndView welcome() {
		
		return new ModelAndView("index");
	}
	
	@GetMapping("/home")
	public ModelAndView home() {
		
		return new ModelAndView("index");
	}
	
	@GetMapping("/cat")
	@ResponseBody
	public Cat getCat(String name) {
		logger.debug("name => " + name);
		Cat cat = new Cat();
		cat.setId(1);
		cat.setName("C95");
		cat.setColor("Blue");
		return cat;
	}
	
	@PostMapping("/cats")
	@ResponseBody
	public List<Cat> getCats(@RequestBody Cat c) {
		logger.debug("getName => " + c.getName());
		List<Cat> cats = new ArrayList<Cat>();
		Cat cat = new Cat();
		cat.setId(3);
		cat.setName("Cat");
		cat.setColor("WhiteBlack");
		cats.add(cat);
		Cat jerry = new Cat();
		jerry.setId(2);
		jerry.setName("Jerry");
		jerry.setColor("Yellow");
		cats.add(jerry);
		return cats;
	}
}
