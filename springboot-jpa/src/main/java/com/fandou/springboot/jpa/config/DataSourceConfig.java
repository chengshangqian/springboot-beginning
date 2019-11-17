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
package com.fandou.springboot.jpa.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;

/**
 * @Title: DataSourceConfig
 * @Description: 配置读/写数据源
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月29日 下午9:37:26
 * @version V0.0.1
 */
@Configuration
public class DataSourceConfig {
	
	@Bean
	@ConfigurationProperties(prefix="spring.datasource.readonly")
	@Primary
	public DataSource readOnlyDataSource() {
		return DruidDataSourceBuilder.create().build();
	}	
	
	@Bean
	@ConfigurationProperties(prefix="spring.datasource.writeonly")
	public DataSource writeOnlyDataSource() {
		return DruidDataSourceBuilder.create().build();
	}
		
}
