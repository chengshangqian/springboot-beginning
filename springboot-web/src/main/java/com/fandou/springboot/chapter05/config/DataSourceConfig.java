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

/**
 * @Title: DataSourceConfig
 * @Description: 数据源配置
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月29日 下午9:37:26
 * @version V0.0.1
 */
//@Configuration
public class DataSourceConfig {
	
	/*
	@Bean
	@ConditionalOnMissingBean
	@ConfigurationProperties(prefix="spring.datasource")
	public DataSource dataSource() {
		return DruidDataSourceBuilder.create().build();
	}
	
	
	@Bean
	@ConfigurationProperties(prefix="spring.datasource.jpa")
	public DataSource jpaDataSource() {
		return DruidDataSourceBuilder.create().build();
	}	
	
	@Bean
	@ConfigurationProperties(prefix="spring.datasource.mongo")
	public DataSource mongoDataSource() {
		return DruidDataSourceBuilder.create().build();
	}	
	
	@Bean
	@ConfigurationProperties(prefix="spring.datasource.test")
	public DataSource testDataSource() {
		return DruidDataSourceBuilder.create().build();
	}
	*/	
}
