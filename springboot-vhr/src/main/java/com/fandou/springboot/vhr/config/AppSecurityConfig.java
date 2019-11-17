/**   
 * @Title: AppConfig.java 
 * @Package com.fandou.springboot.vhr.config 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月9日 下午11:00:59
 * @version V0.0.1  
 */
package com.fandou.springboot.vhr.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

import com.fandou.springboot.vhr.component.security.AppAccessDecisionManager;
import com.fandou.springboot.vhr.component.security.AppFilterInvocationSecurityMetadataSource;
import com.fandou.springboot.vhr.component.security.AuthenticationAccessDeniedHandler;
import com.fandou.springboot.vhr.component.security.VhrAuthenticationFailureHandler;
import com.fandou.springboot.vhr.component.security.VhrAuthenticationSuccessHandler;
import com.fandou.springboot.vhr.service.HrService;

/**
 * @Title: AppConfig
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月9日 下午11:00:59
 * @version V0.0.1
 */
@Configuration
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
	private Logger logger = LogManager.getLogger(AppSecurityConfig.class);
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(10);
	}
	
	@Autowired
	HrService hrService;
	
	/*
	@Bean
	AppFilterInvocationSecurityMetadataSource securityMetadataSource() {
		return new AppFilterInvocationSecurityMetadataSource();
	}

	@Bean
	AppAccessDecisionManager accessDecisionManager() {
		return new AppAccessDecisionManager();
	}	
	*/
	
	@Autowired
	VhrAuthenticationSuccessHandler vhrAuthenticationSuccessHandler;
	
	@Autowired
	VhrAuthenticationFailureHandler vhrAuthenticationFailureHandler;
	
	@Autowired
	AuthenticationAccessDeniedHandler authenticationAccessDeniedHandler;	
	
	@Autowired
	AppAccessDecisionManager appAccessDecisionManager;
	
	@Autowired
	AppFilterInvocationSecurityMetadataSource appFilterInvocationSecurityMetadataSource;
	
	private ObjectPostProcessor<FilterSecurityInterceptor> securityPostProcessor = new ObjectPostProcessor<FilterSecurityInterceptor>() {
		@Override
		public <O extends FilterSecurityInterceptor> O postProcess(O object) {
			//使用自定义的资源配置源
			object.setSecurityMetadataSource(appFilterInvocationSecurityMetadataSource);
			//使用自定的访问决策管理
			object.setAccessDecisionManager(appAccessDecisionManager);
			return object;
		}
	};	
	
	/*
	@Autowired
	@Qualifier(value = "appSecurityPostProcessor")
	AppSecurityPostProcessor appSecurityPostProcessor;
	/*
	
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
		//http.csrf().disable();
		
		/*
		 *启用跨域支持 
		 */
		//http.cors();
		
		/*
		 * 权限异常处理：主要是权限不足的情形产生的异常
		 */
		http.exceptionHandling().accessDeniedHandler(authenticationAccessDeniedHandler);
		
		/*
		 * 自定义资源访问控制
		 */
		http.authorizeRequests().withObjectPostProcessor(securityPostProcessor)
		
		/*
		 * 开放api跨域预检请求不需要权限验证
		 */
		//.antMatchers(HttpMethod.OPTIONS,"/api/**").permitAll()
		
		/*
		 * 开放api不需要权限验证：api中务必没有使用需要认证后产生的相关对象或信息
		 */
		//.antMatchers("/api/**").permitAll()
		
		/*
		 * 配置登录方式和登录处理接口，同时亦不需要权限认证（permitAll()）
		 */		
		.and().formLogin()
		//.loginPage("/tologin")
		.loginProcessingUrl("/login")
		//.usernameParameter("username").passwordParameter("password")
		.successHandler(vhrAuthenticationSuccessHandler)
		.failureHandler(vhrAuthenticationFailureHandler).permitAll()
		
		//记住我功能(自动登录）：发送cookie到浏览器，后续请求将传递此cookie，相关认证信息使用key（加密使用的盐）进行加密,以及提交的参数、cookie的域、cookie的名称等
		.and().rememberMe().userDetailsService(hrService).key("qetuoadgjlxvn").rememberMeParameter("rememberme").rememberMeCookieDomain("localhost").rememberMeCookieName("rememberme")
		
		.and().logout()
		//退出登录时使session失效、清空认证信息、也可以删除cookie
		.invalidateHttpSession(true).clearAuthentication(true).deleteCookies("rememberme","moreCookieNames")
		.permitAll();
	}
	
	/**
	 * @Title: configure 
	 * @Description: 配置忽略认证的资源（不需要认证即可直接访问的资源）：首页、联系我们、验证码、静态资源等
	 * @param web
	 * @throws Exception
	 */
	@Override
    public void configure(WebSecurity web) throws Exception {   
		web.ignoring().antMatchers("/","/contact","/captcha.jpg**","/favicon.ico","/static/*","/js/**","/css/**","/img/**","/images/**");
    }
	
	/**
	 * @Title: corsConfigurationSource 
	 * @Description: 跨域资源配置
	 * @return
	 */
	/*
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		//定义一个跨域配置
		CorsConfiguration  configuration = new CorsConfiguration();
		
		//允许带凭证：cookie
		configuration.setAllowCredentials(true);
		//允许跨域调用的域
		configuration.setAllowedOrigins(Arrays.asList("http://localhost:8081","http://localhost:8080"));
		//允许使用的方法
		configuration.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE","OPTIONS"));
		
		//配置可以被跨域调用的URL资源（接口）：/api/**、/login、/logout
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/api/**", configuration);
		//source.registerCorsConfiguration("/login", configuration);
		//source.registerCorsConfiguration("/logout", configuration);
		
		return source;
	}
	*/
}
