/**   
 * @Title: CatServiceImpl.java 
 * @Package com.fandou.springboot.chapter05.model.service.impl 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月29日 下午10:24:13
 * @version V0.0.1  
 */
package com.fandou.springboot.chapter05.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fandou.springboot.chapter04.model.Cat;
import com.fandou.springboot.chapter05.dao.CatDao;
import com.fandou.springboot.chapter05.service.CatService;

/**
 * @Title: CatServiceImpl
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月29日 下午10:24:13
 * @version V0.0.1
 */
@Service
public class CatServiceImpl implements CatService {

	@Autowired
	CatDao catDao;
	
	/** 
	 * @Title: addCat 
	 * @Description: 一句话描述方法的作用
	 * @param cat
	 * @return
	 */
	@Override
	public int addCat(Cat cat) {
		return catDao.addCat(cat);
	}

	/** 
	 * @Title: deleteCat 
	 * @Description: 一句话描述方法的作用
	 * @param id
	 * @return
	 */
	@Override
	public int deleteCat(Integer id) {
		return catDao.deleteCat(id);
	}

	/** 
	 * @Title: updateCat 
	 * @Description: 一句话描述方法的作用
	 * @param cat
	 * @return
	 */
	@Override
	public int updateCat(Cat cat) {
		return catDao.updateCat(cat);
	}

	/** 
	 * @Title: getCat 
	 * @Description: 一句话描述方法的作用
	 * @param id
	 * @return
	 */
	@Override
	public Cat getCat(Integer id) {
		return catDao.getCat(id);
	}

	/** 
	 * @Title: getAllCats 
	 * @Description: 一句话描述方法的作用
	 * @return
	 */
	@Override
	public List<Cat> getAllCats() {
		return catDao.getAllCats();
	}

}
