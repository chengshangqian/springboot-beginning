/**   
 * @Title: DruidConfig.java 
 * @Package com.fandou.springboot.chapter05.config 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月29日 下午9:37:26
 * @version V0.0.1  
 */
package com.fandou.springboot.chapter05.config;

import javax.servlet.Filter;
import javax.servlet.Servlet;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

/**
 * @Title: DruidConfig
 * @Description: 整合druid监控组件
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月29日 下午9:37:26
 * @version V0.0.1
 */
//@Configuration
public class DruidConfig {

	/**
	 * @Title: druidDataSource
	 * @Description: 配置druid监控的数据源，开启SQL、SQL防火墙等监控
	 *               在POM中引入druid-spring-boot-starter，默认会监控使用了DruidDataSource作为数据源组件的数据源，但不会监控SQL，需要开启配置
	 *               单数据源的情况下，druid的数据源会覆盖spring.datasource的配置的数据源而提供给应用程序调用
	 * @return
	 */
	/*
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource.druid")
	public DataSource druidDataSource() {
		//druid-spring-boot-starter API
		return DruidDataSourceBuilder.create().build();
	}
	*/

	/**
	 * 注册Servlet 配置druid监控管理后台的访问路径：http://localhost:8080/druid
	 * 
	 * @return
	 */
	@Bean
	@ConditionalOnMissingBean
	public ServletRegistrationBean<Servlet> druidServlet() {
		ServletRegistrationBean<Servlet> servletRegistrationBean = new ServletRegistrationBean<Servlet>(
				new StatViewServlet(), "/druid/*");

		// 白名单：
		// servletRegistrationBean.addInitParameter("allow","127.0.0.1,139.196.87.48");
		// IP黑名单 (存在共同时，deny优先于allow) : 如果满足deny的话提示:Sorry, you are not permitted to
		// view this page.
		// servletRegistrationBean.addInitParameter("deny","192.168.1.119");
		// 登录查看信息的账号密码, 用于登录Druid监控后台
		servletRegistrationBean.addInitParameter("loginUsername", "admin");
		servletRegistrationBean.addInitParameter("loginPassword", "admin");
		// 是否能够重置数据.
		servletRegistrationBean.addInitParameter("resetEnable", "true");
		return servletRegistrationBean;

	}

	/**
	 * 注册Filter 开启Web应用、URI、Session的监控
	 * 
	 * @return
	 */
	@Bean
	@ConditionalOnMissingBean
	public FilterRegistrationBean<Filter> filterRegistrationBean() {
		FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<Filter>();
		filterRegistrationBean.setFilter(new WebStatFilter());
		filterRegistrationBean.addUrlPatterns("/*");
		filterRegistrationBean.addInitParameter("exclusions",
				"*.html,*.js,*.gif,*.jpg,*.jpeg,*.png,*.css,*.ico,/druid/*");
		return filterRegistrationBean;
	}
}
