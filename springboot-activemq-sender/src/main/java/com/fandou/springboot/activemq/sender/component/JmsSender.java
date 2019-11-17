/**   
 * @Title: JmsComponent.java 
 * @Package com.fandou.springboot.activemq.component 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月3日 下午8:29:58
 * @version V0.0.1  
 */
package com.fandou.springboot.activemq.sender.component;

import javax.jms.Queue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import com.fandou.springboot.activemq.model.Cat;

/**
 * @Title: JmsSender
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月3日 下午8:29:58
 * @version V0.0.1
 */
@Component
public class JmsSender {
	private Logger logger = LogManager.getLogger(JmsSender.class);
	
	@Autowired
	JmsMessagingTemplate jmsMessagingTemplate;
	
	@Autowired
	Queue queue;
	
	/*
	 * 发送消息：能否开启多线程异步发送消息？
	 */
	//@Async
	public void send(Cat cat) {
		String threadName = Thread.currentThread().getName();
		logger.info("JmsSender.send :: threadName => " + threadName);	
		jmsMessagingTemplate.convertAndSend(this.queue,cat);
		logger.info("发送消息到队列中 ===>  " + cat);
	}
}
