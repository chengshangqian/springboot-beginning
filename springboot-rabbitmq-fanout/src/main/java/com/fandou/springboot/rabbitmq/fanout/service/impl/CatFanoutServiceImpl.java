/**   
 * @Title: CatDirectServiceImpl.java 
 * @Package com.fandou.springboot.rabbitmq.direct.service.impl 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月4日 下午2:14:37
 * @version V0.0.1  
 */
package com.fandou.springboot.rabbitmq.fanout.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fandou.springboot.rabbitmq.config.RabbitmqFanoutConfig;
import com.fandou.springboot.rabbitmq.fanout.service.CatFanoutService;
import com.fandou.springboot.rabbitmq.model.Cat;

/**
 * @Title: CatDirectServiceImpl
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月4日 下午2:14:37
 * @version V0.0.1
 */
@Service
public class CatFanoutServiceImpl implements CatFanoutService {
	private Logger logger = LogManager.getLogger(CatFanoutServiceImpl.class);
	private final static String ALL_QUEUES = null;
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	/** 
	 * @Title: sendCat 
	 * @Description: 一句话描述方法的作用
	 * @param cat
	 */
	@Override
	public void sendCat(Cat cat) {
		rabbitTemplate.convertAndSend(RabbitmqFanoutConfig.FANOUT_NAME,ALL_QUEUES,cat);
		logger.debug("消息已发送 :: cat.id => " + cat.getId());
	}
}
