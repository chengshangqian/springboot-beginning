/**   
 * @Title: C95Filter.java 
 * @Package com.fandou.springboot.chapter04.support 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月29日 下午4:29:07
 * @version V0.0.1  
 */
package com.fandou.springboot.chapter04.support;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @Title: C95Filter
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月29日 下午4:29:07
 * @version V0.0.1
 */
@WebFilter("/*")
public class C95Filter implements Filter {
	private Logger logger = LogManager.getLogger(C95Filter.class);
	public void init(FilterConfig filterConfig) {
		logger.debug("C95Filter => init");
	}

	/** 
	 * @Title: doFilter 
	 * @Description: 一句话描述方法的作用
	 * @param request
	 * @param response
	 * @param chain
	 * @throws IOException
	 * @throws ServletException
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		logger.debug("C95Filter => doFilter");
		chain.doFilter(request, response);
	}

	public void destroy() {
		logger.debug("C95Filter => destroy");
	}
}
