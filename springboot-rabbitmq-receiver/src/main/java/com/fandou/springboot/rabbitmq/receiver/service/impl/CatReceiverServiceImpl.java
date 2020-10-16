/**   
 * @Title: CatReceiverServiceImpl.java 
 * @Package com.fandou.springboot.rabbitmq.receiver.service.impl 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月4日 下午2:35:42
 * @version V0.0.1  
 */
package com.fandou.springboot.rabbitmq.receiver.service.impl;

import java.util.Date;

import com.fandou.springboot.rabbitmq.support.PrintThread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.fandou.springboot.rabbitmq.model.Cat;
import com.fandou.springboot.rabbitmq.receiver.service.CatReceiverService;

/**
 * @Title: CatReceiverServiceImpl
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月4日 下午2:35:42
 * @version V0.0.1
 */
@Service
public class CatReceiverServiceImpl implements CatReceiverService {
	private static final Logger LOGGER = LoggerFactory.getLogger(CatReceiverServiceImpl.class);
	
	/** 
	 * @Title: addCat 
	 * @Description: 一句话描述方法的作用
	 * @param cat
	 * @return
	 */
	@Override
	@Async
	@PrintThread
	public Cat addCat(Cat cat) {
		cat.setCreateDate(new Date());
		//TODO 持久化保存代码[耗时任务]
		LOGGER.info("消息已经成功保存到数据库 => {}",cat);
		return cat;
	}
}
