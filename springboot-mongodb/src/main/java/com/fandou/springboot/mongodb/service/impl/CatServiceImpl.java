/**   
 * @Title: CatServiceImpl.java 
 * @Package com.fandou.springboot.redis.service.impl 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月31日 下午12:07:55
 * @version V0.0.1  
 */
package com.fandou.springboot.mongodb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.fandou.springboot.mongodb.dao.CatDao;
import com.fandou.springboot.mongodb.model.Cat;
import com.fandou.springboot.mongodb.service.CatService;

/**
 * @Title: CatServiceImpl
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月31日 下午12:07:55
 * @version V0.0.1
 */
@Service
public class CatServiceImpl implements CatService {
	
	@Autowired
	CatDao catDao;
	
	//也可以使用MongoTemplate代替继承MongoRepository的catDao
	@Autowired
	MongoTemplate mongoTemplate;
	
	/****************** MongoDB *******************/
	public Cat addCat(Cat cat) {
		return catDao.insert(cat);
	}
	
	public Cat updateCat(Cat cat) {
		return catDao.save(cat);
	}
	
	public void deleteCat(Integer id) {
		catDao.deleteById(id);
	}

	/** 
	 * @Title: findByColorEquals 
	 * @Description: 一句话描述方法的作用
	 * @param color
	 * @return
	 */
	@Override
	public List<Cat> findByColorEquals(String color) {
		return catDao.findByColorEquals(color);
	}

	/** 
	 * @Title: findByNameEquals 
	 * @Description: 一句话描述方法的作用
	 * @param name
	 * @return
	 */
	@Override
	public Cat findByNameEquals(String name) {
		return catDao.findByNameEquals(name);
	}
	
	/**
	 * @Title: insertCats 
	 * @Description: 也可以使用MongoTemplate代替继承MongoRepository的Dao
	 * @param cats
	 * @return
	 */
	public void insertCats(List<Cat> cats) {
		mongoTemplate.insertAll(cats);
	}
}
