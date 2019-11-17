/**   
 * @Title: RabbitmqFanoutConfig.java 
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
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Title: RabbitmqFanoutConfig
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月4日 下午1:55:35
 * @version V0.0.1
 */
@Configuration
public class RabbitmqFanoutConfig {
	public final static String FANOUT_NAME = "c95-fanout";
	public final static String QUEUE_ONE_NAME = "c95-fanout-queue-one";
	public final static String QUEUE_TWO_NAME = "c95-fanout-queue-two";
	
	@Bean
	FanoutExchange fanoutExchange() {
		return new FanoutExchange(FANOUT_NAME,true,false);
	}	
	
	@Bean
	Queue queueOne() {
		return new Queue(QUEUE_ONE_NAME);
	}
	
	@Bean
	Queue queueTwo() {
		return new Queue(QUEUE_TWO_NAME);
	}
	
	@Bean
	Binding bindingOne() {
		return BindingBuilder.bind(queueOne()).to(fanoutExchange());
	}
	
	@Bean
	Binding bindingTwo() {
		return BindingBuilder.bind(queueTwo()).to(fanoutExchange());
	}
}
