package com.fandou.springboot.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SpringbootRabbitmqDirectApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringbootRabbitmqDirectApplication.class);

	public static void main(String[] args) {
		LOGGER.debug("thread => {}",Thread.currentThread().getName());
		SpringApplicationBuilder builder = new SpringApplicationBuilder(SpringbootRabbitmqDirectApplication.class);
		builder.bannerMode(Banner.Mode.OFF).run(args);
	}

}
