/**   
 * @Title: CatDao.java 
 * @Package com.fandou.springboot.activemq.dao 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月3日 下午9:06:48
 * @version V0.0.1  
 */
package com.fandou.springboot.activemq.receiver.dao;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.fandou.springboot.activemq.model.Cat;

/**
 * @Title: CatDao
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月3日 下午9:06:48
 * @version V0.0.1
 */
@Repository
public class CatDao {
	private Logger logger = LogManager.getLogger(CatDao.class);
	
	public Cat addCat(Cat cat) {
		//添加创建时间,然后保存到数据库
		cat.setCreateDate(new Date());
		//TODO 保存到数据库的代码
		logger.info("消息已成功保存到数据库 =>  {id:" + cat.getId() + ",name:" + cat.getName() + ",color:" + cat.getColor() + "}");
		return cat;
	}
}
