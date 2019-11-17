package com.fandou.springboot.http;

import org.springframework.boot.Banner.Mode;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SpringbootSecurityHttpApplication {

	public static void main(String[] args) {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(SpringbootSecurityHttpApplication.class);
		builder.bannerMode(Mode.OFF).run(args);
	}

}
