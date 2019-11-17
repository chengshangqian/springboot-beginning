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
package com.fandou.springboot.http.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RestController
public class UserController {
	private Logger logger = LogManager.getLogger(UserController.class);
	
	@GetMapping("/")
	public String index() {
		logger.info("欢迎来到项目交付管理系统");
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
		String pwd = encoder.encode("888888");
		logger.info("pwd => " + pwd);
		return "首页";
	}
	@GetMapping("/admin/index")
	public String admin() {
		logger.info("欢迎来到项目交付管理系统ADMIN后台");
		return "ADMIN后台";
	}
	@GetMapping("/db/index")
	public String db() {
		logger.info("欢迎来到项目交付管理系统DBA后台");
		return "DBA后台";
	}
	@GetMapping("/user/index")
	public String user() {
		logger.info("欢迎来到项目交付管理系统业务平台");
		return "USER后台";
	}
	
	
}
