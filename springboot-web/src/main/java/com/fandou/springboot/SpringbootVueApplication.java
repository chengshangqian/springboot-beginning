package com.fandou.springboot;

import org.springframework.boot.Banner;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
//@EnableAutoConfiguration(exclude= {ErrorMvcAutoConfiguration.class})//过滤不需要开启的自动化配置
public class SpringbootVueApplication {

	public static void main(String[] args) {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(SpringbootVueApplication.class);
		builder.bannerMode(Banner.Mode.OFF).run(args);
	}

}
