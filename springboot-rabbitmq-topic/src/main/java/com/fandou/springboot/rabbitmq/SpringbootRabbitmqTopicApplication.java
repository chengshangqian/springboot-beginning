package com.fandou.springboot.rabbitmq;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SpringbootRabbitmqTopicApplication {

	public static void main(String[] args) {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(SpringbootRabbitmqTopicApplication.class);
		builder.bannerMode(Banner.Mode.OFF).run(args);
	}

}
