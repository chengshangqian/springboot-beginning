/**   
 * @Title: UserController.java 
 * @Package com.fandou.springboot.http.controller 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月6日 上午10:45:47
 * @version V0.0.1  
 */
package com.fandou.springboot.db.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fandou.springboot.db.model.User;

/**
 * @Title: UserController
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月6日 上午10:45:47
 * @version V0.0.1
 */
@Controller
public class UserController {
	private Logger logger = LogManager.getLogger(UserController.class);
	
	@GetMapping("/")
	public ModelAndView index() {
		logger.info("欢迎来到项目交付管理系统首页");
		return new ModelAndView("index");
	}
	
	@GetMapping("/admin/index")
	public ModelAndView admin() {
		logger.info("系统管理平台");
		return new ModelAndView("admin");
	}
	
	@GetMapping("/db/index")
	public ModelAndView db() {
		logger.info("数据库管理平台");
		return new ModelAndView("dba");
	}
	
	@GetMapping("/user/index")
	public ModelAndView user() {
		logger.info("项目管理平台");
		return new ModelAndView("user");
	}
	
	@GetMapping("/contact")
	public ModelAndView contact() {
		logger.info("联系我们");
		return new ModelAndView("contact");
	}
	
	@GetMapping("/auth/login")
	public ModelAndView login() {
		logger.info("登录");
		return new ModelAndView("login");
	}
	
	@GetMapping("/api/users")
	@ResponseBody
	public User addUser() {
		logger.info("添加用户");
		User user = new User();
		user.setId(1);
		user.setUsername("sqcheng");
		return user;
	}
}
