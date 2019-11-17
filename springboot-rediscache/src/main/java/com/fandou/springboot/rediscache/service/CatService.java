/**   
 * @Title: CatService.java 
 * @Package com.fandou.springboot.ehcache.service 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月3日 上午12:01:13
 * @version V0.0.1  
 */
package com.fandou.springboot.rediscache.service;

import com.fandou.springboot.rediscache.model.Cat;

/**
 * @Title: CatService
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月3日 上午12:01:13
 * @version V0.0.1
 */
public interface CatService {
	Cat getCatById(Integer id);
	Cat updateCatById(Cat cat);
	void deleteCatById(Integer id);
	
}
