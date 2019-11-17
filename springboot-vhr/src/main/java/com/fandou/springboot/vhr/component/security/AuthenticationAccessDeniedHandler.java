/**   
 * @Title: AuthenticationAccessDeniedHandler.java 
 * @Package com.fandou.springboot.vhr.component 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月9日 下午11:55:56
 * @version V0.0.1  
 */
package com.fandou.springboot.vhr.component.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import com.fandou.springboot.vhr.model.RespBean;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @Title: AuthenticationAccessDeniedHandler
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月9日 下午11:55:56
 * @version V0.0.1
 */
@Component
public class AuthenticationAccessDeniedHandler implements AccessDeniedHandler {

	/** 
	 * @Title: handle 
	 * @Description: 一句话描述方法的作用
	 * @param request
	 * @param response
	 * @param accessDeniedException
	 * @throws IOException
	 * @throws ServletException
	 */
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		
		response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		response.setContentType("application/json;charset=utf-8");
		RespBean error = RespBean.error("权限不足，请联系管理员");
		ObjectMapper om = new ObjectMapper();
		PrintWriter out = response.getWriter();
		out.write(om.writeValueAsString(error));
		out.flush();
		out.close();
	}

}
