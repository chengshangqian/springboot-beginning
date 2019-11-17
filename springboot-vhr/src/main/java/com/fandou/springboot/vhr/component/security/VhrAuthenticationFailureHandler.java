/**   
 * @Title: VhrAuthenticationFailureHandler.java 
 * @Package com.fandou.springboot.vhr.component 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月10日 上午12:12:13
 * @version V0.0.1  
 */
package com.fandou.springboot.vhr.component.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.fandou.springboot.vhr.model.RespBean;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @Title: VhrAuthenticationFailureHandler
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月10日 上午12:12:13
 * @version V0.0.1
 */
@Component
public class VhrAuthenticationFailureHandler implements AuthenticationFailureHandler {

	/** 
	 * @Title: onAuthenticationFailure 
	 * @Description: 一句话描述方法的作用
	 * @param request
	 * @param response
	 * @param exception
	 * @throws IOException
	 * @throws ServletException
	 */
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {

		response.setContentType("application/json;charset=utf-8");
		response.setStatus(401);
		RespBean failure = null;
		if(exception instanceof LockedException){
			failure = RespBean.error("账户被锁定，请联系管理员.");
		}
		else if(exception instanceof BadCredentialsException || exception instanceof UsernameNotFoundException) {
			failure = RespBean.error("账户名或密码输入错误.");
		}
		else if(exception instanceof DisabledException) {
			failure = RespBean.error("账户被禁用，请联系管理员.");
		}
		else if(exception instanceof AccountExpiredException) {
			failure = RespBean.error("账户过期，请联系管理员.");
		}
		else if(exception instanceof CredentialsExpiredException) {
			failure = RespBean.error("密码过期，请重新登录或联系管理员.");
		}
		else{
			failure = RespBean.error("登录失败！");
		}
		
		ObjectMapper om = new ObjectMapper();
		PrintWriter out = response.getWriter();
		out.write(om.writeValueAsString(failure));
		out.flush();
		out.close();
	}

}
