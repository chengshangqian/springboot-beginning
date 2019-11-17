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
package com.fandou.springboot.activemq.receiver.listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.fandou.springboot.activemq.model.Cat;
import com.fandou.springboot.activemq.receiver.service.CatReceiverService;

/**
 * @Title: JmsReceiver
 * @Description: 消息队列监听器（接收器）
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月3日 下午8:29:58
 * @version V0.0.1
 */
@Component
public class JmsReceiver {
	private Logger logger = LogManager.getLogger(JmsReceiver.class);
	
	@Autowired
	CatReceiverService catReceiverService;
	
	@JmsListener(destination="amq")
	public void receive(Cat cat) {
		logger.info("从队列中取回消息  ===>  " + cat);
		//TODO 获取到消息后，启用新的线程保存到数据库
		String threadName = Thread.currentThread().getName();
		logger.info("JmsReceiver :: threadName => " + threadName);
		//异步多线程保存消息
		catReceiverService.addCat(cat);
		//单线程保存消息
		//catReceiverService.addCatOneThread(cat);
	}
}
