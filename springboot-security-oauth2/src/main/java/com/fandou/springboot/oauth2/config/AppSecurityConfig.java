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
package com.fandou.springboot.oauth2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Title: WebSecurityConfig
 * @Description: 配置SpringSecurity
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月6日 上午10:53:50
 * @version V0.0.1
 */
@Configuration
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
	
	/**
	 * @Title: passwordEncoder 
	 * @Description: 声明密码加密器
	 * @return
	 */
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(10);
	}
	
	/**
	 * @Title: authenticationManagerBean 
	 * @Description: 注入到Oauth2AuthorizationServerConfig
	 * @return
	 * @throws Exception
	 */
	@Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }	
	
	/**
	 * @Title: configure 
	 * @Description: /oauth/**路径直接放行，这里的HttpSecurity优先级高于ResourceServerConfig类的HttpSecurity：
	 * ·即请求先经过这里的HttpSecurity，再经过ResourceServerConfig的HttpSecurity，即后者会覆盖前者
	 * @param http
	 * @throws Exception
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/oauth/**").permitAll()
			.and().csrf().disable();
	}
}
