/**   
 * @Title: JdbcTemplateConfig.java 
 * @Package com.fandou.springboot.chapter05.config 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月30日 下午8:51:37
 * @version V0.0.1  
 */
package com.fandou.springboot.chapter05.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @Title: JdbcTemplateConfig
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月30日 下午8:51:37
 * @version V0.0.1
 */
//@Configuration
public class JdbcTemplateConfig {
	
	@Bean
	JdbcTemplate jpaJdbcTemplate(@Qualifier("jpaDataSource")DataSource jpaDataSource) {
		return new JdbcTemplate(jpaDataSource);
	}
	
	@Bean
	JdbcTemplate mangoJdbcTemplate(@Qualifier("mongoDataSource")DataSource mongoDataSource) {
		return new JdbcTemplate(mongoDataSource);
	}
	
	@Bean
	JdbcTemplate testJdbcTemplate(@Qualifier("testDataSource")DataSource testDataSource) {
		return new JdbcTemplate(testDataSource);
	}
}
