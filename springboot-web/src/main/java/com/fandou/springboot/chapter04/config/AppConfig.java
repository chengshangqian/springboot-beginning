/**   
 * @Title: AppConfig.java 
 * @Package com.fandou.springboot.chapter04 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月29日 下午2:39:28
 * @version V0.0.1  
 */
package com.fandou.springboot.chapter04.config;

import java.lang.reflect.Modifier;
import java.nio.charset.Charset;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.fandou.springboot.chapter04.support.C95Interceptor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @Title: AppConfig
 * @Description: 应用公共配置  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月29日 下午2:39:28
 * @version V0.0.1
 */
@Configuration
public class AppConfig implements WebMvcConfigurer{
	/**
	 * @Title: gsonHttpMessageConverter 
	 * @Description: 配置gson
	 * @return
	 */
	@Bean
	GsonHttpMessageConverter gsonHttpMessageConverter() {
		GsonHttpMessageConverter converter = new GsonHttpMessageConverter();
		GsonBuilder builder = new GsonBuilder();
		builder.setDateFormat("yyyy-MM-dd HH:mm");
		builder.excludeFieldsWithModifiers(Modifier.PROTECTED);
		Gson gson = builder.create();
		converter.setGson(gson);
		return converter;
	}
	
	/**
	 * @Title: fastJsonHttpMessageConverter 
	 * @Description: 配置fastjson
	 * @return
	 */
	@Bean
	FastJsonHttpMessageConverter fastJsonHttpMessageConverter() {
		FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
		FastJsonConfig config = new FastJsonConfig();
		config.setDateFormat("yyyy-MM-dd HH:mm:ss");
		config.setCharset(Charset.forName("UTF-8"));
		config.setSerializerFeatures(
				//SerializerFeature.WriteClassName, 
				//SerializerFeature.WriteMapNullValue,
				SerializerFeature.PrettyFormat, SerializerFeature.WriteNullListAsEmpty,
				SerializerFeature.WriteNullStringAsEmpty);
		converter.setFastJsonConfig(config);
		return converter;
	}
	
	/*******************以下开始为WebMvc相关配置************************/
	/**
	 * @Title: addResourceHandlers 
	 * @Description: 自定义静态资源访问路径
	 * @param registry
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/img/**").addResourceLocations("classpath:/img/");
	}

	/**
	 * @Title: addCorsMappings 
	 * @Description: CORS跨域配置
	 * @param registry
	 */
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		String addMapping = "/api/**";
		String[] allowedHeaders = new String[] { "*" };
		String[] allowedMethods = new String[] { "GET", "POST", "PUT", "DELETE", "HEAD", "OPTIONS" };
		String[] allowedOrigins = new String[] { "http://localhost:9997" };
		long maxAge = 1800l;
		registry.addMapping(addMapping).allowedHeaders(allowedHeaders).allowedMethods(allowedMethods)
				.allowedOrigins(allowedOrigins).maxAge(maxAge);
	}
	
	/**
	 * @Title: addInterceptors 
	 * @Description: 配置拦截器
	 * @param registry
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		HandlerInterceptor interceptor = new C95Interceptor();
		registry.addInterceptor(interceptor).addPathPatterns("/hi");
		//registry.addInterceptor(interceptor).addPathPatterns("/**").excludePathPatterns("/api/**");
	}
	
	/**
	 * @Title: addViewControllers 
	 * @Description: 配置简单访问请求或页面（不需要经过控制器加载数据）的路径映射
	 * @param registry
	 */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/index").setViewName("index");
	}
}
