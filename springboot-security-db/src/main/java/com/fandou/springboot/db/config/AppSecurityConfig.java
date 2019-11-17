/**   
 * @Title: WebSecurityConfig.java 
 * @Package com.fandou.springboot.http.config 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月6日 上午10:53:50
 * @version V0.0.1  
 */
package com.fandou.springboot.db.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

/**
 * @Title: WebSecurityConfig
 * @Description: TODO(一句话描述该类的业务或功能)
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月6日 上午10:53:50
 * @version V0.0.1
 */
@Configuration
/*
 * ·pom中引入的是spring-boot-starter-security，不需要再额外开启这个@EnableWebSecurity注解，
 * ·因为在SpringBootWebSecurityConfiguration里面已经开启了这个注解，同时，该类中还配置了忽略的静态文件资源：
 * private static List<String> DEFAULT_IGNORED = Arrays.asList("/css/**", "/js/**","/images/**", "/webjars/**", "/** /favicon.ico");
 */
//@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
	private Logger logger = LogManager.getLogger(AppSecurityConfig.class);

	/*
	@Autowired
	private UserService userService;
	*/
	
	@Bean
	PasswordEncoder passwordEncoder() {
		logger.info("调用了AppSecurityConfig  ===================>  passwordEncoder");
		// 使用强哈希函数
		return new BCryptPasswordEncoder(10);
	}
	
	/*
	@Bean
    @Override
    public UserDetailsService userDetailsService() {
        return userService;
    }	
    */

	/**
	 * @Title: configure
	 * @Description: 认证管理：基于数据库的验证，用户和角色存储在数据库中
	 * ·业务系统中如果扩展了UserDetailsService的类并加上了@Service注解，Spring Security会自动发现并使用
	 * ·不需要再重载这个方法
	 * @param authenticationManagerBuilder
	 * @throws Exception
	 */
	/*
	@Override
	protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		logger.info("调用了AppSecurityConfig  ===================>  configure::authenticationManagerBuilder");
		authenticationManagerBuilder.userDetailsService(userService);
	}
	*/

	/**
	 * @Title: configure
	 * @Description: 配置受保护的资源（菜单/操作等）：配置访问地址与权限角色关系，以及登录地址、csrf
	 * @param http
	 * @throws Exception
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		logger.info("调用了AppSecurityConfig  ===================>  configure::http");
		
		/*
		 * 关闭CSRF跨域攻击
		 */
		http.csrf().disable();
		
		/*
		 * 自定义资源访问控制
		 */
		http.authorizeRequests().withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
			@Override
			public <O extends FilterSecurityInterceptor> O postProcess(O object) {
				//使用自定义的资源配置源
				object.setSecurityMetadataSource(securityMetadataSource());
				//使用自定的访问决策管理
				object.setAccessDecisionManager(accessDecisionManager());
				return object;
			}
		})
		
		/*
		 * 跨域预检请求
		 */
		.antMatchers(HttpMethod.OPTIONS,"/api/**").permitAll()
		
		/*
		 * 首页、登录页、联系我们、验证码、静态资源目录等
		 */
		//.antMatchers("/","/contact","/captcha.jpg**","/favicon.ico").permitAll()
		//.antMatchers("/js/**","/css/**","/img/**","/images/**").permitAll()
		
		/*
		 * 配置登录方式和登录处理接口
		 */		
		.and().formLogin().loginProcessingUrl("/login").permitAll()
		.and().logout().permitAll();
	}
	
	/**
	 * @Title: configure 
	 * @Description: 配置直接访问的资源：包括静态资源，首页、联系我们、验证码、静态资源等
	 * @param web
	 * @throws Exception
	 */
	@Override
    public void configure(WebSecurity web) throws Exception {   
		/*
		 * 首页、登录页、联系我们、验证码、静态资源目录等免认证即可访问
		 */
		web.ignoring().antMatchers("/","/contact","/captcha.jpg**","/favicon.ico","/js/**","/css/**","/img/**","/images/**");
    }

	@Bean
	AppFilterInvocationSecurityMetadataSource securityMetadataSource() {
		return new AppFilterInvocationSecurityMetadataSource();
	}

	@Bean
	AppAccessDecisionManager accessDecisionManager() {
		return new AppAccessDecisionManager();
	}
}
