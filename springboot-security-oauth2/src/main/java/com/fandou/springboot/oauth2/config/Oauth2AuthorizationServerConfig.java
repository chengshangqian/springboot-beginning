/**   
 * @Title: Oauth2AuthorizationServerConfig.java 
 * @Package com.fandou.springboot.oauth2.config 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月8日 下午3:31:46
 * @version V0.0.1  
 */
package com.fandou.springboot.oauth2.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import com.fandou.springboot.oauth2.service.Oauth2ClientDetailsService;

/**
 * @Title: Oauth2AuthorizationServerConfig
 * @Description: Oath2认证授权服务器配置
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月8日 下午3:31:46
 * @version V0.0.1
 */
@Configuration
@EnableAuthorizationServer
public class Oauth2AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
	private Logger logger = LogManager.getLogger(Oauth2AuthorizationServerConfig.class);
	
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	RedisConnectionFactory redisConnectionFactory;
	
	/**
	 * 自定义ClientDetailsService，根据client_id从数据库中查询client信息：即在本应用中有效备案的第三方应用
	 */
	@Autowired
	Oauth2ClientDetailsService oauth2ClientDetailsService;
	
	/**
	 * @Title: configure 
	 * @Description: 验证客户端请求的配置：参考:https://blog.csdn.net/qq_33460562/article/details/79351938
	 * @param clients
	 * @throws Exception
	 */
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		logger.info("调用了Oauth2AuthorizationServerConfig  ===================>  configure::clients");
		/*
		 * ·验证第三方应用的clent_id是否正确有效：是否是在本系统中注册/登记的有效应用
		 */
		clients.withClientDetails(oauth2ClientDetailsService);
	}

	/**
	 * @Title: configure 
	 * @Description: 认证服务端点配置
	 * @param endpoints
	 * @throws Exception
	 */
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		//使用redis保存令牌
		endpoints.tokenStore(new RedisTokenStore(redisConnectionFactory))
		
		//认证管理器：AppSecurityConfig中声明
		.authenticationManager(authenticationManager)
		
		//用户信息服务：查询验证第三方应用提交过来的用户信息是否正确有效，SpringSecurity自动发现并使用
		//.userDetailsService(userDetailsService)
		
		//接收GET和POST
        //.allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST)
		;
	}
	
	/**
	 * @Title: configure 
	 * @Description: 允许使用form表单认证
	 * @param securityConfigurer
	 * @throws Exception
	 */
	public void configure(AuthorizationServerSecurityConfigurer securityConfigurer) throws Exception {
		securityConfigurer.allowFormAuthenticationForClients();
	}
}
