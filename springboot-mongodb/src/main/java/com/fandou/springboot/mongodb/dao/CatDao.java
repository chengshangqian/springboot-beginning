/**   
 * @Title: CatDao.java 
 * @Package com.fandou.springboot.redis.dao 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月31日 下午2:40:20
 * @version V0.0.1  
 */
package com.fandou.springboot.mongodb.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fandou.springboot.mongodb.model.Cat;

/**
 * @Title: CatDao
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月31日 下午2:40:20
 * @version V0.0.1
 */
public interface CatDao extends MongoRepository<Cat, Integer> {
	List<Cat> findByColorEquals(String color);
	Cat findByNameEquals(String name);
}
