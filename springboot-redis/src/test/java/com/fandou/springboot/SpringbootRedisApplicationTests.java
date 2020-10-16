package com.fandou.springboot;

import com.fandou.springboot.redis.model.Cat;
import com.fandou.springboot.redis.service.CatService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SpringbootRedisApplicationTests {

	public static final Logger LOGGER = LoggerFactory.getLogger(SpringbootRedisApplicationTests.class);

	@Autowired
	private CatService catService;

	@Test
	public void contextLoads() {
		Cat jerry = new Cat();
		jerry.setId(1L);
		jerry.setColor("Yellow");
		jerry.setName("Jerry");

		catService.create(jerry);

		LOGGER.debug("The cat is => {}",catService.get(jerry.getId()));

		jerry.setColor("White");
		catService.update(jerry);

		LOGGER.debug("The cat after updated is => {}",catService.get(jerry.getId()));

		catService.delete(jerry.getId());

		LOGGER.debug("The cat after deleted is => {}",catService.get(jerry.getId()));
	}
}
