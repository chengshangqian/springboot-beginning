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
package com.fandou.springboot.oauth2.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Title: UserController
 * @Description: 需要用户授权才可以访问的资源
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月6日 上午10:45:47
 * @version V0.0.1
 */
@RestController
public class UserController {
	private Logger logger = LogManager.getLogger(UserController.class);
	
	@GetMapping("/")
	public String home() {
		logger.info("欢迎回家");
		return "欢迎回家";
	}
	
	@GetMapping("/index")
	public String index() {
		logger.info("欢迎来到项目交付管理系统首页");
		return "欢迎来到项目交付管理系统首页";
	}
	
	@GetMapping("/contact")
	public String contact() {
		logger.info("登录后可以查看联系方式：18565029972");
		return "登录后可以查看联系方式：18565029972";
	}
	
	@GetMapping("/api/system/bigdata")
	public String admin() {
		logger.info("系统平台统计信息");
		//TODO 从数据库中获取数据或从内部非开放的平台api获取数据返回给第三方应用
		return "系统中所有用户画像大数据";
	}
	
	@GetMapping("/api/user/info")
	public String user() {
		logger.info("项目管理平台");
		//TODO 从数据库中获取数据或从内部非开放的平台api获取数据返回给第三方应用
		return "用户手机号|身份证|昵称|相片|性别信息";
	}
}
