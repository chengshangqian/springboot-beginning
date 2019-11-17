package com.fandou.springboot.jdbc;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SpringbootJdbcApplication {

	public static void main(String[] args) {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(SpringbootJdbcApplication.class);
		builder.bannerMode(Banner.Mode.OFF).run(args);
	}

}
