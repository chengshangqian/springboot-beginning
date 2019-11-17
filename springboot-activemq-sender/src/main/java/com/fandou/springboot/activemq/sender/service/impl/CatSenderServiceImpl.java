/**   
 * @Title: CatSenderImpl.java 
 * @Package com.fandou.springboot.activemq.service.impl 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月3日 下午8:42:51
 * @version V0.0.1  
 */
package com.fandou.springboot.activemq.sender.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fandou.springboot.activemq.model.Cat;
import com.fandou.springboot.activemq.sender.component.JmsSender;
import com.fandou.springboot.activemq.sender.service.CatSenderService;

/**
 * @Title: CatSenderImpl
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月3日 下午8:42:51
 * @version V0.0.1
 */
@Service
public class CatSenderServiceImpl implements CatSenderService {
	private Logger logger = LogManager.getLogger(CatSenderServiceImpl.class);
	
	@Autowired
	JmsSender jmsSender;
	
	/** 
	 * @Title: send 
	 * @Description: 发送消息
	 * @param cat
	 */
	@Override
	public void send(Cat cat) {
		String threadName = Thread.currentThread().getName();
		logger.info("CatSenderServiceImpl.send :: threadName => " + threadName);			
		jmsSender.send(cat);
	}
}
