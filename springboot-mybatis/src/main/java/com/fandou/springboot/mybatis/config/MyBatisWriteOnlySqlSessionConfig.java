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
 * @Title: MyBatisTestConfig
 * @Description: 只写数据源配置
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月30日 下午10:35:07
 * @version V0.0.1
 */
@Configuration
@MapperScan(value="com.fandou.springboot.mybatis.dao.writeonly",sqlSessionFactoryRef="writeOnlySqlSessionFactory")
public class MyBatisWriteOnlySqlSessionConfig {
	
	@Autowired
	@Qualifier("writeOnlyDataSource")
	DataSource writeOnlyDataSource;
	
	/**************** 只写数据库的数据源   *********************************/
	@Bean
	SqlSessionFactory writeOnlySqlSessionFactory() throws Exception {
		SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
		factory.setDataSource(writeOnlyDataSource);
		return factory.getObject();
	}
	
	@Bean
	SqlSessionTemplate writeOnlySqlSessionTemplate() throws Exception {
		return new SqlSessionTemplate(writeOnlySqlSessionFactory());
	}
}
