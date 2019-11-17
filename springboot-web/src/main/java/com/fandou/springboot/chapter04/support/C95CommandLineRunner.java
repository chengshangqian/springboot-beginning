/**   
 * @Title: C95CommandLineRunner.java 
 * @Package com.fandou.springboot.chapter04.support 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月29日 下午3:58:23
 * @version V0.0.1  
 */
package com.fandou.springboot.chapter04.support;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Title: C95CommandLineRunner
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月29日 下午3:58:23
 * @version V0.0.1
 */
@Component
@Order(1)
public class C95CommandLineRunner implements CommandLineRunner {
	private Logger logger = LogManager.getLogger(C95CommandLineRunner.class);
	/** 
	 * @Title: run 
	 * @Description: 一句话描述方法的作用
	 * @param args
	 * @throws Exception
	 */
	@Override
	public void run(String... args) throws Exception {
		logger.debug("C95CommandLineRunner Order(1) ==> " + Arrays.toString(args));
	}

}
