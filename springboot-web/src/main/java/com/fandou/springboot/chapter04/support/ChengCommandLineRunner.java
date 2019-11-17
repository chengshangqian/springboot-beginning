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
 * @Title: ChengCommandLineRunner
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月29日 下午3:58:23
 * @version V0.0.1
 */
@Component
@Order(2)
public class ChengCommandLineRunner implements CommandLineRunner {
	private Logger logger = LogManager.getLogger(ChengCommandLineRunner.class);
	/** 
	 * @Title: run 
	 * @Description: 一句话描述方法的作用
	 * @param args
	 * @throws Exception
	 */
	@Override
	public void run(String... args) throws Exception {
		logger.debug("ChengCommandLineRunner Order(2) ==> " + Arrays.toString(args));
	}

}
