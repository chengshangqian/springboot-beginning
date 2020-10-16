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

import com.fandou.springboot.rabbitmq.support.PrintThread;
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

	@Autowired
	CatReceiverService catReceiverService;
	
	/*******************direct模式发送端******************************************/
	@RabbitListener(queues="c95-direct-queue")
	@PrintThread
	public void receiveDirectQueue(Cat cat) {
		catReceiverService.addCat(cat);
	}
	
	/*******************fanout模式发送端******************************************/
	@RabbitListener(queues="c95-fanout-queue-one")
	@PrintThread
	public void receiveFanoutQueueOne(Cat cat) {
		catReceiverService.addCat(cat);
	}
	
	@RabbitListener(queues="c95-fanout-queue-two")
	@PrintThread
	public void receiveFanoutQueueTwo(Cat cat) {
		catReceiverService.addCat(cat);
	}
	
	/*******************topic模式发送端******************************************/
	@RabbitListener(queues="c95-topic-queue-jerry")
	@PrintThread
	public void receiveTopicQueueJerry(Cat cat) {
		catReceiverService.addCat(cat);
	}
	
	@RabbitListener(queues="c95-topic-queue-mickey")
	@PrintThread
	public void receiveTopicQueueMickey(Cat cat) {
		catReceiverService.addCat(cat);
	}	
	
	@RabbitListener(queues="c95-topic-queue-cat")
	@PrintThread
	public void receiveTopicQueueCat(Cat cat) {
		catReceiverService.addCat(cat);
	}	
}
