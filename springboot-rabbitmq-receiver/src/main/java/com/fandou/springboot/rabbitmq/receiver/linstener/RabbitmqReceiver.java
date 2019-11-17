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
package com.fandou.springboot.rabbitmq.receiver.linstener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fandou.springboot.rabbitmq.model.Cat;
import com.fandou.springboot.rabbitmq.receiver.service.CatReceiverService;

/**
 * @Title: RabbitmqReceiver
 * @Description: 消息队列监听器（接收器）
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月3日 下午8:29:58
 * @version V0.0.1
 */
@Component
public class RabbitmqReceiver {
	private Logger logger = LogManager.getLogger(RabbitmqReceiver.class);
	
	@Autowired
	CatReceiverService catReceiverService;
	
	/*******************direct模式发送端******************************************/
	@RabbitListener(queues="c95-direct-queue")
	public void receiveDirectQueue(Cat cat) {
		String threadName = Thread.currentThread().getName();
		logger.info("RabbitmqReceiver::receiveDirectQueue::threadName => " + threadName);
		catReceiverService.addCat(cat);
	}
	
	/*******************fanout模式发送端******************************************/
	@RabbitListener(queues="c95-fanout-queue-one")
	public void receiveFanoutQueueOne(Cat cat) {
		String threadName = Thread.currentThread().getName();
		logger.info("RabbitmqReceiver::receiveFanoutQueueOne::threadName => " + threadName);
		catReceiverService.addCat(cat);
	}
	
	@RabbitListener(queues="c95-fanout-queue-two")
	public void receiveFanoutQueueTwo(Cat cat) {
		String threadName = Thread.currentThread().getName();
		logger.info("RabbitmqReceiver::receiveFanoutQueueTwo::threadName => " + threadName);
		catReceiverService.addCat(cat);
	}
	
	/*******************topic模式发送端******************************************/
	@RabbitListener(queues="c95-topic-queue-jerry")
	public void receiveTopicQueueJerry(Cat cat) {
		String threadName = Thread.currentThread().getName();
		logger.info("RabbitmqReceiver::receiveTopicQueueJerry::threadName => " + threadName);
		catReceiverService.addCat(cat);
	}
	
	@RabbitListener(queues="c95-topic-queue-mickey")
	public void receiveTopicQueueMickey(Cat cat) {
		String threadName = Thread.currentThread().getName();
		logger.info("RabbitmqReceiver::receiveTopicQueueMickey::threadName => " + threadName);
		catReceiverService.addCat(cat);
	}	
	
	@RabbitListener(queues="c95-topic-queue-cat")
	public void receiveTopicQueueCat(Cat cat) {
		String threadName = Thread.currentThread().getName();
		logger.info("RabbitmqReceiver::receiveTopicQueueCat::threadName => " + threadName);
		catReceiverService.addCat(cat);
	}	
}
