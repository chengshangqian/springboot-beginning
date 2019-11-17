/**   
 * @Title: C95ApplicationRunner.java 
 * @Package com.fandou.springboot.chapter04.support 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月29日 下午4:07:01
 * @version V0.0.1  
 */
package com.fandou.springboot.chapter04.support;

import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Title: ChengApplicationRunner
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月29日 下午4:07:01
 * @version V0.0.1
 */
@Component
@Order(3)
public class ChengApplicationRunner implements ApplicationRunner {
	private Logger logger = LogManager.getLogger(ChengApplicationRunner.class);
	/** 
	 * @Title: run 
	 * @Description: 一句话描述方法的作用
	 * @param args
	 * @throws Exception
	 */
	@Override
	public void run(ApplicationArguments args) throws Exception {
		List<String> nonOptionArgs = args.getNonOptionArgs();
		logger.debug("ChengApplicationRunner Order(3) nonOptionArgs => " + nonOptionArgs);
		Set<String> optionNames = args.getOptionNames();
		for(String optionName : optionNames) {
			logger.debug("ChengApplicationRunner key: " + optionName + " => value:" + args.getOptionValues(optionName));
		}
	}

}
