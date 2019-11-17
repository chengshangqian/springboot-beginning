package com.fandou.springboot.oauth2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.Banner.Mode;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import com.fandou.springboot.oauth2.config.AppSecurityConfig;

@SpringBootApplication
public class SpringbootSecurityOauth2Application {
	private static Logger logger = LogManager.getLogger(AppSecurityConfig.class);
	/**
	 * @Title: main 
	 * @Description:搭建OAuth2.0认证服务（基于密码模式）
	 * @param args
	 */
	public static void main(String[] args) {
		logger.info("Oauth原理详解 ===> http://www.ruanyifeng.com/blog/2019/04/oauth_design.html");
		logger.info("1:启动应用");
		logger.info("2:启动PostMan");
		logger.info("3:发送获取令牌请求：");
		logger.info("（1）POST");
		logger.info("（2）URL：http://localhost:8080/oauth/token");
		logger.info("（3）Params：username=admin&password=888888&grant_type=password&scope=all&client_id=password-client&client_secret=888888");
		logger.info("（4）Send按钮发送请求获取令牌");
		logger.info("4:请求资源：");
		logger.info("（1）GET");
		logger.info("（2）URL：http://localhost:8080/api/user/info");
		logger.info("（3）Authorization：Type类型选择OAuth2.0");
		logger.info("（4）Access Token：填写步骤3中返回的令牌access_token的值");
		logger.info("（5）Send按钮发送请求资源");
		SpringApplicationBuilder builder = new SpringApplicationBuilder(SpringbootSecurityOauth2Application.class);
		builder.bannerMode(Mode.OFF).run(args);
	}

}
