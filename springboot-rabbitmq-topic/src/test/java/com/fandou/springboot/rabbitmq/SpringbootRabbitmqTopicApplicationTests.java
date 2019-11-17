package com.fandou.springboot.rabbitmq;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fandou.springboot.rabbitmq.model.Cat;
import com.fandou.springboot.rabbitmq.topic.service.CatTopicService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRabbitmqTopicApplicationTests {
	private Logger logger = LogManager.getLogger(SpringbootRabbitmqTopicApplicationTests.class);
	
	@Autowired
	CatTopicService catTopicService;
	
	@Test
	public void contextLoads() {
		long start = System.currentTimeMillis();
		String[] queues = {"jerry.news","mickey.news","cat.news","jerry.cat","mickey.cat"};
		for(int q = 0; q < 5; q++) {
			String queue = queues[q];
			for(int i = 1; i < 10001; i++) {
				Cat c = new Cat();
				c.setId(i);
				c.setName("[" + queue + "]::Jerry::" + i);
				c.setColor("Yellow");
				catTopicService.sendCat(c,queue);
			}
		}
		long end = System.currentTimeMillis();
		long spentTime = end - start;
		logger.debug("发送1w条消息总共花费时间  => " + (spentTime/1000) + "秒");
	}

}
