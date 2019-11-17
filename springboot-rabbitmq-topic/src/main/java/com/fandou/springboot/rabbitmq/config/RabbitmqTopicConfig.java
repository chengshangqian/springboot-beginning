/**   
 * @Title: RabbitmqTopicConfig.java 
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
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Title: RabbitmqTopicConfig
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月4日 下午1:55:35
 * @version V0.0.1
 */
@Configuration
public class RabbitmqTopicConfig {
	public final static String TOPIC_NAME = "c95-topic";
	public final static String QUEUE_JERRY_NAME = "c95-topic-queue-jerry";
	public final static String QUEUE_MICKEY_NAME = "c95-topic-queue-mickey";
	public final static String QUEUE_CAT_NAME = "c95-topic-queue-cat";
	
	@Bean
	TopicExchange topicExchange() {
		return new TopicExchange(TOPIC_NAME,true,false);
	}	
	
	@Bean
	Queue queueJerry() {
		return new Queue(QUEUE_JERRY_NAME);
	}
	
	@Bean
	Queue queueMickey() {
		return new Queue(QUEUE_MICKEY_NAME);
	}
	
	@Bean
	Queue queueCat() {
		return new Queue(QUEUE_CAT_NAME);
	}
	
	@Bean
	Binding bindingJerry() {
		return BindingBuilder.bind(queueJerry()).to(topicExchange()).with("jerry.#");
	}
	
	@Bean
	Binding bindingMickey() {
		return BindingBuilder.bind(queueMickey()).to(topicExchange()).with("mickey.#");
	}
	
	@Bean
	Binding bindingCat() {
		return BindingBuilder.bind(queueCat()).to(topicExchange()).with("#.cat.#");
	}
}
