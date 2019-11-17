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
package com.fandou.springboot.http.config;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

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
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	private Logger logger = LogManager.getLogger(WebSecurityConfig.class);
	
	@Bean
	PasswordEncoder passwordEncoder() {
		//使用强哈希函数
		return new BCryptPasswordEncoder(10);
	}

	/**
	 * @Title: configure
	 * @Description: 基于内存存储的验证：将用户名密码保存在内容中
	 * @param auth
	 * @throws Exception
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("root").password("$2a$10$4SIPumdJjcgvWJ19YOzmWufz6117ogfnsNYE0xZrznzyjhOXub.IG").roles("ADMIN", "DBA")
			.and()
			.withUser("admin").password("$2a$10$VCk3NUj3cZZPtxOk2tODcesbtY33GPRijCQMEyYSzSnLiYOdX8jGa").roles("ADMIN", "USER")
			.and()
			.withUser("sqcheng").password("$2a$10$.SyCzQodO1Qy0kQh31UfOOeF4Z.YEAHEq/dJtoOWpneq.wDLimET2").roles("USER");
	}
	
	/**
	 * @Title: roleHierarchy 
	 * @Description: 配置角色关系（继承关系）:新旧版本角色继承的写法：https://blog.csdn.net/u012702547/article/details/99543744
	 * @Description 以下配置：admin可以访问自身资源外，还可以访问user和dba的资源；dba和user权限相互独立，没有继承关系
	 * @return
	 */
	@Bean
	RoleHierarchy roleHierarchy() {
		RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
		String hierarchy = "ROLE_BOSS > ROLE_USER \n ROLE_ADMIN > ROLE_USER \n ROLE_ADMIN > ROLE_DBA";
		roleHierarchy.setHierarchy(hierarchy);
		return roleHierarchy;
	}

	/**
	 * @Title: configure
	 * @Description: 配置受保护的资源：配置访问地址与权限角色关系，以及登录地址、csrf
	 * @param http
	 * @throws Exception
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			/*
			 *  配置 /admin/**路径下的资源必须拥有ADMIN角色才能访问
			 *  配置 /user/**路径下的资源拥有ADMIN和USER角色均可访问
			 *  配置 /db/**路径下的资源必须拥有ADMIN和DBA角色方可访问
			 */
			.antMatchers("/admin/**").hasRole("ADMIN")
			.antMatchers("/user/**").hasRole("USER")
			.antMatchers("/db/**").hasRole("DBA")
			.antMatchers("/chat/**").access("hasAnyRole('ADMIN','USER','DBA','BOSS')")
			.antMatchers("/manage/**").access("hasRole('ADMIN') and hasRole('BOSS')")
			
			.anyRequest().authenticated()
			
			/*
			 * 配置表单登录
			 * 配置自定义的登录界面为 login.html
			 * 配置登录处理接口为 /login，访问需要授权的地址时，将跳转到登录界面，如果未登录的话
			 * 配置登录成功/或失败的处理方法
			 */
			.and().formLogin()
			//.loginPage("login.html")
			.loginProcessingUrl("/login")
			.successHandler(new AuthenticationSuccessHandler() {
				@Override
				public void onAuthenticationSuccess(HttpServletRequest req,HttpServletResponse resp,Authentication auth) throws IOException {
					Object principal = auth.getPrincipal();
					resp.setContentType("application/json;charset=utf-8");
					resp.setStatus(200);
					Map<String,Object> map = new HashMap<>();
					map.put("status", 200);
					map.put("principal", principal);
					ObjectMapper om = new ObjectMapper();
					PrintWriter out = resp.getWriter();
					out.write(om.writeValueAsString(map));
					out.flush();
					out.close();
					logger.info("用户登录成功....");
				}
			})
			.failureHandler(new AuthenticationFailureHandler() {
				@Override
				public void onAuthenticationFailure(HttpServletRequest req,HttpServletResponse resp,AuthenticationException e) throws IOException {
					resp.setContentType("application/json;charset=utf-8");
					resp.setStatus(401);
					Map<String,Object> map = new HashMap<>();
					map.put("status", 401);
					if(e instanceof LockedException){
						map.put("error", "账户被锁定，登录失败！");
					}
					else if(e instanceof BadCredentialsException) {
						map.put("error", "账户名或密码输入错误，登录失败！");
					}
					else if(e instanceof DisabledException) {
						map.put("error", "账户名或密码输入错误，登录失败！");
					}
					else if(e instanceof AccountExpiredException) {
						map.put("error", "账户名或密码输入错误，登录失败！");
					}
					else if(e instanceof CredentialsExpiredException) {
						map.put("error", "账户名或密码输入错误，登录失败！");
					}
					else{
						map.put("error", "登录失败！");
					}
					ObjectMapper om = new ObjectMapper();
					PrintWriter out = resp.getWriter();
					out.write(om.writeValueAsString(map));
					out.flush();
					out.close();
					logger.info("用户失败....");
				}
			})
			.permitAll()
			
			/*
			 * 配置退出 / 注销登录：
			 * 配置注销登录接口为 /logout
			 * 配置注销即成功后的处理方法
			 */
			.and().logout().logoutUrl("/logout").clearAuthentication(true).invalidateHttpSession(true).addLogoutHandler(new LogoutHandler() {
				@Override
				public void logout(HttpServletRequest req,HttpServletResponse resp,Authentication auth) {
					logger.info("用户正在退出登出....");
				}
			}).logoutSuccessHandler(new LogoutSuccessHandler() {
				@Override
				public void onLogoutSuccess(HttpServletRequest req,HttpServletResponse resp,Authentication auth) {
					//TODO 成功退出，做点其它清理工作
					logger.info("用户已退出系统....");
					//resp.sendRedirect("login.html");//回到登录界面
				}
			})
			
			/*
			 * 关闭CSRF跨域攻击
			 */
			.and().csrf().disable();
	}
}
