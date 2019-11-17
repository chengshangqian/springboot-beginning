package com.fandou.springboot.activemq;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fandou.springboot.activemq.model.Cat;
import com.fandou.springboot.activemq.sender.service.CatSenderService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootActivemqSenderApplicationTests {
	private Logger logger = LogManager.getLogger(SpringbootActivemqSenderApplicationTests.class);
	
	@Autowired
	CatSenderService catSender;
	
	@Test
	public void contextLoads() {
		Cat jerry = new Cat();
		jerry.setId(1);
		jerry.setName("Jerry");
		jerry.setColor("Yellow");
		catSender.send(jerry);
		logger.info("给你发送了一只猫咪，名叫Jerry ==> " + jerry);
		
		/*
		 * 测试同一台机器下接收端使用单线程/异步多线程方式保存到数据库的情况下，
		 * 机器发送1W条消息的时间
		 */
		long start = System.currentTimeMillis();
		for(int i = 0; i < 100 ;i++) {
			Cat c = new Cat();
			int index = i + 1;
			c.setId(index);
			c.setName("Jerry:" + index);
			c.setColor("Yellow");
			catSender.send(c);		
		}
		long end = System.currentTimeMillis();
		long spent = end - start;
		logger.info("发送1w条消息总共花费时间（接收端异步多线程） => " + (spent/1000) + " 秒");//18-25分钟
		//logger.info("发送1w条消息总共花费时间（接收端单线程） => " + (spent/1000) + " 秒");//27.194分钟
	}
}
