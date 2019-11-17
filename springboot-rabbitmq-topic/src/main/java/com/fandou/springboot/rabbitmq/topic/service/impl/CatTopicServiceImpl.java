/**   
 * @Title: CatTopicServiceImpl.java 
 * @Package com.fandou.springboot.rabbitmq.direct.service.impl 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月4日 下午2:14:37
 * @version V0.0.1  
 */
package com.fandou.springboot.rabbitmq.topic.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fandou.springboot.rabbitmq.config.RabbitmqTopicConfig;
import com.fandou.springboot.rabbitmq.model.Cat;
import com.fandou.springboot.rabbitmq.topic.service.CatTopicService;

/**
 * @Title: CatTopicServiceImpl
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月4日 下午2:14:37
 * @version V0.0.1
 */
@Service
public class CatTopicServiceImpl implements CatTopicService {
	private Logger logger = LogManager.getLogger(CatTopicServiceImpl.class);
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	/** 
	 * @Title: sendCat 
	 * @Description: 一句话描述方法的作用
	 * @param cat
	 */
	@Override
	public void sendCat(Cat cat,String queue) {
		rabbitTemplate.convertAndSend(RabbitmqTopicConfig.TOPIC_NAME,queue,cat);
		logger.debug("消息已发送 :: cat.name => " + cat.getName());
	}
}
