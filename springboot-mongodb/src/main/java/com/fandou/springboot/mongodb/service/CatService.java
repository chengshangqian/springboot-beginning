/**   
 * @Title: CatService.java 
 * @Package com.fandou.springboot.redis.service 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月31日 下午12:04:21
 * @version V0.0.1  
 */
package com.fandou.springboot.mongodb.service;

import java.util.List;

import com.fandou.springboot.mongodb.model.Cat;

/**
 * @Title: CatService
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月31日 下午12:04:21
 * @version V0.0.1
 */
public interface CatService {
	default List<Cat> findByColorEquals(String color) {
		return null;
	}
	default Cat findByNameEquals(String name) {
		return null;
	}
	default Cat addCat(Cat cat) {
		return null;
	}
	default Cat updateCat(Cat cat) {
		return null;
	}
	default void deleteCat(Integer id) {
		
	}
	default  void insertCats(List<Cat> cats) {
		
	}	
}
