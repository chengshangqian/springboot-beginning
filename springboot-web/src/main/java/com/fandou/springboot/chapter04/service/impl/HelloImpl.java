/**   
 * @Title: HelloImpl.java 
 * @Package com.fandou.springboot.chapter04.service.impl 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月29日 下午3:14:31
 * @version V0.0.1  
 */
package com.fandou.springboot.chapter04.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fandou.springboot.chapter04.service.Hello;

/**
 * @Title: HelloImpl
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月29日 下午3:14:31
 * @version V0.0.1
 */
//@Service //示例使用xml方式声明
public class HelloImpl implements Hello {
	private Logger logger = LogManager.getLogger(HelloImpl.class);
	/** 
	 * @Title: sayHello 
	 * @Description: 一句话描述方法的作用
	 * @param username
	 * @return
	 */
	@Override
	public String sayHello(String username) {
		logger.debug("执行HelloImpl.sayHello方法");
		String hi = null == username ? "world" : username;
		return "Hello," + hi + "!";
	}

	/** 
	 * @Title: add 
	 * @Description: add
	 * @param id
	 * @return
	 */
	@Override
	public String add(String id) {
		logger.debug("执行HelloImpl.add方法");
		return id;
	}

	/** 
	 * @Title: delete 
	 * @Description: delete
	 * @param id
	 * @return
	 */
	@Override
	public String delete(String id) {
		logger.debug("执行HelloImpl.delete方法");
		return id;
	}

	/** 
	 * @Title: throwException 
	 * @Description: 一句话描述方法的作用
	 * @param id
	 * @return
	 */
	@Override
	public String throwException(String id) {
		logger.debug("执行HelloImpl.throwException方法");
		int i = 1 / 0;
		return i + "";
	}

}
