/**   
 * @Title: ApiConfig.java 
 * @Package com.fandou.springboot.api 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月4日 下午10:41:56
 * @version V0.0.1  
 */
package com.fandou.springboot.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.google.common.base.Predicate;

import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Title: ApiConfig
 * @Description: TODO(一句话描述该类的业务或功能)
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月4日 下午10:41:56
 * @version V0.0.1
 */
@Configuration
@EnableSwagger2
public class ApiConfig implements WebMvcConfigurer {

	@Bean
	Docket docket() {
		DocumentationType documentationType = DocumentationType.SWAGGER_2;
		Predicate<RequestHandler> apis = RequestHandlerSelectors.basePackage("com.fandou.springboot.api.controller");
		Predicate<String> paths = PathSelectors.any();
		return new Docket(documentationType).apiInfo(apiInfo()).select().apis(apis).paths(paths).build();
	}

	private ApiInfo apiInfo() {
		String title = "项目交付管理系统API文档";
		String description = "这是蕃豆科技开发的项目交付管理系统API说明文档。当前为1.0.0版本，接口正在陆续提交当中，开发人员可以在这里查找需要的接口并集成到自己的代码中使用进行测试和调试，API支持跨域调用。";
		String version = "v1.0.0";
		Contact contact = new Contact("成九五", "https://fandou.com", "c95@fandou.com");
		String license = "Apache2.0";
		String licenseUrl = "https://www.apache.org/licenses/LICENSE-2.0";
		String termsOfServiceUrl = "https://fandou.com/contact.html";
		return new ApiInfoBuilder().title(title).description(description).version(version).contact(contact)
				.license(license).licenseUrl(licenseUrl).termsOfServiceUrl(termsOfServiceUrl).build();
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
		String[] allowedOrigins = new String[] { "*" };
		long maxAge = 1800l;
		registry.addMapping(addMapping).allowedHeaders(allowedHeaders).allowedMethods(allowedMethods)
				.allowedOrigins(allowedOrigins).maxAge(maxAge);
	}
}
