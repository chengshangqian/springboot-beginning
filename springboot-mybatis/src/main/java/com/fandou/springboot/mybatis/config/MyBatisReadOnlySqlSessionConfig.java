/**   
 * @Title: MyBatisConfig.java 
 * @Package com.fandou.springboot.mybatis.config 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月30日 下午10:35:07
 * @version V0.0.1  
 */
package com.fandou.springboot.mybatis.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Title: MyBatisReadOnlySqlSessionConfig
 * @Description: 只读数据源配置  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月30日 下午10:35:07
 * @version V0.0.1
 */
@Configuration
@MapperScan(value="com.fandou.springboot.mybatis.dao.readonly",sqlSessionFactoryRef="readOnlySqlSessionFactory")
public class MyBatisReadOnlySqlSessionConfig {
	
	@Autowired
	@Qualifier("readOnlyDataSource")
	DataSource readOnlyDataSource;
	
	/**************** 只读数据库的数据源   *********************************/
	@Bean
	SqlSessionFactory readOnlySqlSessionFactory() throws Exception {
		SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
		factory.setDataSource(readOnlyDataSource);
		return factory.getObject();
	}
	
	@Bean
	SqlSessionTemplate readOnlySqlSessionTemplate() throws Exception {
		return new SqlSessionTemplate(readOnlySqlSessionFactory());
	}
}
