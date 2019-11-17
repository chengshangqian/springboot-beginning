/**   
 * @Title: BatchConfig.java 
 * @Package com.fandou.springboot.batch.config 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月5日 下午8:49:29
 * @version V0.0.1  
 */
package com.fandou.springboot.batch.config;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.fandou.springboot.batch.model.Computer;

/**
 * @Title: BatchConfig
 * @Description: TODO(一句话描述该类的业务或功能)
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月5日 下午8:49:29
 * @version V0.0.1
 */
@Configuration
public class BatchConfig {
	
	@Autowired
	StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	JobBuilderFactory jobBuilderFactory;

	@Autowired
	DataSource dataSource;

	@Bean
	@StepScope
	FlatFileItemReader<Computer> itemReader() {
		FlatFileItemReader<Computer> reader = new FlatFileItemReader<Computer>();
		reader.setLinesToSkip(1);//跳过1行（即跳过表头）
		reader.setResource(new ClassPathResource("computers.csv"));
		reader.setLineMapper(new DefaultLineMapper<Computer>() {
			{
				setLineTokenizer(new DelimitedLineTokenizer() {
					{
						setNames("name", "model");//各列表头名
						setDelimiter(",");//各列分割符，csv用逗号,分隔，可能有些是用水平制表符 \t
						//setDelimiter("\t");
					}
				});
				setFieldSetMapper(new BeanWrapperFieldSetMapper<Computer>() {
					{
						setTargetType(Computer.class);//设置读取的结果转换对象属性的映射
					}
				});
			}
		});
		return reader;
	}
	
	@Bean
	JdbcBatchItemWriter<Computer> jdbcBatchItemWriter() {
		JdbcBatchItemWriter<Computer> writer = new JdbcBatchItemWriter<Computer>();
		writer.setDataSource(dataSource);
		writer.setSql("insert into computer(name,model) values (:name,:model)");
		writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
		return writer;
	}
	
	@Bean
	Step batchAddComputers() {
		//chunk(2)：表示读取到2条数据就执行一次写（write）操作，将数据写入到数据库
		return stepBuilderFactory.get("batchAddComputers").<Computer,Computer>chunk(2).reader(itemReader()).writer(jdbcBatchItemWriter()).build();
	}
	
	@Bean
	Job batchAddComputersJob() {
		return jobBuilderFactory.get("batchAddComputersJob").start(batchAddComputers()).build();
	}
}
