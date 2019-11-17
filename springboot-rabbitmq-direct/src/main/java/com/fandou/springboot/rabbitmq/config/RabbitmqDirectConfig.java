/**   
 * @Title: RabbitmqDirectConfig.java 
 * @Package com.fandou.springboot.rabbitmq.config 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月4日 下午1:55:35
 * @version V0.0.1  
 */
package com.fandou.springboot.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Title: RabbitmqDirectConfig
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月4日 下午1:55:35
 * @version V0.0.1
 */
@Configuration
public class RabbitmqDirectConfig {
	public final static String DIRECT_NAME = "c95-direct";
	public final static String QUEUE_NAME = "c95-direct-queue";
	
	@Bean
	DirectExchange directExchange() {
		return new DirectExchange(DIRECT_NAME,true,false);
	}
	
	@Bean
	Queue queue() {
		return new Queue(QUEUE_NAME);
	}
	
	@Bean
	Binding binding() {
		return BindingBuilder.bind(queue()).to(directExchange()).with("direct");
	}
}
