/**   
 * @Title: AuthenticationSuccessHandler.java 
 * @Package com.fandou.springboot.vhr.component 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月10日 上午12:03:47
 * @version V0.0.1  
 */
package com.fandou.springboot.vhr.component.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.fandou.springboot.vhr.model.RespBean;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @Title: AuthenticationSuccessHandler
 * @Description: TODO(一句话描述该类的业务或功能)
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月10日 上午12:03:47
 * @version V0.0.1
 */
@Component
public class VhrAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	/**
	 * @Title: onAuthenticationSuccess
	 * @Description: 一句话描述方法的作用
	 * @param request
	 * @param response
	 * @param authentication
	 * @throws IOException
	 * @throws ServletException
	 */
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		response.setContentType("application/json;charset=utf-8");
		RespBean success = RespBean.ok("登录成功",authentication.getPrincipal());
		ObjectMapper om = new ObjectMapper();
		PrintWriter out = response.getWriter();
		out.write(om.writeValueAsString(success));
		out.flush();
		out.close();
	}

}
