/**   
 * @Title: ResourceServerConfig.java 
 * @Package com.fandou.springboot.oauth2.config 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月8日 下午3:56:07
 * @version V0.0.1  
 */
package com.fandou.springboot.oauth2.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * @Title: ResourceServerConfig
 * @Description: 资源服务器配置
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月8日 下午3:56:07
 * @version V0.0.1
 */
@Configuration
@EnableResourceServer
public class Oauth2ResourceServerConfig extends ResourceServerConfigurerAdapter {
	
	/**
	 * TODO 实际开发中，可以将开放的资源数据存储在数据库中进行管理
	 */
	public void configure(ResourceServerSecurityConfigurer resources) {
		resources.resourceId("open-api");
	}
	
	/**
	 * TODO 实际开发中，资源数据一般存储在数据库中进行管理
	 */
	public void configure(HttpSecurity http) throws Exception {
		/*
		 * 开放api：请求的资源。例如，允许或想要实现第三方可以使用本系统/平台的用户信息进行登录，可以开放用户api；如果是做平台型产品，类似专门做各类数据服务api的平台，所有的api都可以是资源
		 */
		String systemApi = "/api/system/**";
		String userApi = "/api/user/**";
		//开放更多的资源（api）...
		
		/*
		 *使用开放api的第三方应用的角色
		 */
		String vipRole = "vip";
		String systemRole = "admin";
		String userRole = "user";
		//更多角色...
		
		/*
		 * api与角色关系：配置权限
		 */
		http.authorizeRequests()
		.antMatchers(systemApi).hasAnyRole(vipRole,systemRole)
		.antMatchers(userApi).hasAnyRole(vipRole,userRole)
		
		/*
		 * 首页不需要身份认证
		 */
		.antMatchers("/","/index").permitAll()
		
		/*
		 *其它的只要认证即可登录，不需要区分角色 ，比如 /contact
		 */
		.anyRequest().authenticated();
	}
}
