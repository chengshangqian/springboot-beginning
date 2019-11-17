package com.fandou.springboot.mybatis;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SpringbootMybatisApplication {

	public static void main(String[] args) {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(SpringbootMybatisApplication.class);
		builder.bannerMode(Banner.Mode.OFF).run(args);
	}

}
