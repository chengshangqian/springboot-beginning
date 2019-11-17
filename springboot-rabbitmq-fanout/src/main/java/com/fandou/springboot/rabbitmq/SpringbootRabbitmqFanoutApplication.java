package com.fandou.springboot.rabbitmq;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SpringbootRabbitmqFanoutApplication {

	public static void main(String[] args) {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(SpringbootRabbitmqFanoutApplication.class);
		builder.bannerMode(Banner.Mode.OFF).run(args);
	}

}
