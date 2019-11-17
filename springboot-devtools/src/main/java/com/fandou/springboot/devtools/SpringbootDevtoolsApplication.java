package com.fandou.springboot.devtools;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SpringbootDevtoolsApplication {

	public static void main(String[] args) {
		//也可以使用编码方式停止使用开发者工具自动重启项目
		//System.setProperty("spring.devtools.restart.enabled","false");
		SpringApplicationBuilder builder = new SpringApplicationBuilder(SpringbootDevtoolsApplication.class);
		builder.bannerMode(Banner.Mode.OFF).run(args);		
	}

}
