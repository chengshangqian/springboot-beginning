/**   
 * @Title: JpaReadOnlyConfig.java 
 * @Package com.fandou.springboot.jpa.config 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月30日 下午11:48:28
 * @version V0.0.1  
 */
package com.fandou.springboot.jpa.config;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Title: JpaReadOnlyConfig
 * @Description: TODO(一句话描述该类的业务或功能)
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月30日 下午11:48:28
 * @version V0.0.1
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.fandou.springboot.jpa.dao.readonly", entityManagerFactoryRef = "readOnlyEntityManagerFactory", transactionManagerRef = "readOnlyPlatformTransactionManager")
public class JpaReadOnlyConfig {
	@Resource(name = "readOnlyDataSource")
	DataSource readOnlyDataSource;

	@Autowired
	JpaProperties jpaProperties;

	@Bean
	@Primary
	LocalContainerEntityManagerFactoryBean readOnlyEntityManagerFactory(EntityManagerFactoryBuilder builder) {
		return builder.dataSource(readOnlyDataSource).properties(jpaProperties.getProperties())
				.packages("com.fandou.springboot.jpa.model").persistenceUnit("readOnlyPU").build();
	}

	@Bean
	PlatformTransactionManager readOnlyPlatformTransactionManager(EntityManagerFactoryBuilder builder) {
		LocalContainerEntityManagerFactoryBean factory = readOnlyEntityManagerFactory(builder);
		return new JpaTransactionManager(factory.getObject());
	}
}
