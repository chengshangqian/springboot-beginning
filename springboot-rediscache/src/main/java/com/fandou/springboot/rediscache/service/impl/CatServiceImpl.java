/**   
 * @Title: CatServiceImpl.java 
 * @Package com.fandou.springboot.ehcache.service.impl 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月3日 上午12:03:56
 * @version V0.0.1  
 */
package com.fandou.springboot.rediscache.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fandou.springboot.rediscache.dao.CatDao;
import com.fandou.springboot.rediscache.model.Cat;
import com.fandou.springboot.rediscache.service.CatService;

/**
 * @Title: CatServiceImpl
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月3日 上午12:03:56
 * @version V0.0.1
 */
@Service
public class CatServiceImpl implements CatService {
	
	@Autowired
	CatDao catDao;
	
	/** 
	 * @Title: getCatById 
	 * @Description: 一句话描述方法的作用
	 * @param id
	 * @return
	 */
	@Override
	public Cat getCatById(Integer id) {
		return catDao.getCatById(id);
	}

	/** 
	 * @Title: updateCatById 
	 * @Description: 一句话描述方法的作用
	 * @param cat
	 * @return
	 */
	@Override
	public Cat updateCatById(Cat cat) {
		return catDao.updateCatById(cat);
	}

	/** 
	 * @Title: deleteCatById 
	 * @Description: 一句话描述方法的作用
	 * @param id
	 */
	@Override
	public void deleteCatById(Integer id) {
		catDao.deleteCatById(id);
	}

}
