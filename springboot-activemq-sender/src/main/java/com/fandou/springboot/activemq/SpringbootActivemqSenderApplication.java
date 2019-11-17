package com.fandou.springboot.activemq;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootActivemqSenderApplication {

	public static void main(String[] args) {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(SpringbootActivemqSenderApplication.class);
		builder.bannerMode(Banner.Mode.OFF).run(args);		
	}
	
	@Bean
	Queue queue() {
		return new ActiveMQQueue("amq");
	}

}
