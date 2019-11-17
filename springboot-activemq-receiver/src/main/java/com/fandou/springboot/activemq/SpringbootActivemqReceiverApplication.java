package com.fandou.springboot.activemq;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SpringbootActivemqReceiverApplication {

	public static void main(String[] args) {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(SpringbootActivemqReceiverApplication.class);
		builder.bannerMode(Banner.Mode.OFF).run(args);		
	}
	
//	@Bean
//	Queue queue() {
//		return new ActiveMQQueue("amq");
//	}

}
