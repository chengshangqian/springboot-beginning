package com.fandou.springboot.rabbitmq;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fandou.springboot.rabbitmq.direct.service.CatDirectService;
import com.fandou.springboot.rabbitmq.model.Cat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRabbitmqDirectApplicationTests {
	private Logger logger = LogManager.getLogger(SpringbootRabbitmqDirectApplicationTests.class);
	
	@Autowired
	CatDirectService catDirectService;
	
	@Test
	public void contextLoads() {
		long start = System.currentTimeMillis();
		for(int i = 1; i < 10001; i++) {
			Cat c = new Cat();
			c.setId(i);
			c.setName("Jerry::" + i);
			c.setColor("Yellow");
			catDirectService.sendCat(c);
		}
		long end = System.currentTimeMillis();
		long spentTime = end - start;
		logger.debug("发送1w条消息总共花费时间  => " + (spentTime/1000) + "秒");
	}

}
