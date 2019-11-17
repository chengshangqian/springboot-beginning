/**   
 * @Title: MenuServiceImpl.java 
 * @Package com.fandou.springboot.db.service.impl 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月6日 下午6:12:08
 * @version V0.0.1  
 */
package com.fandou.springboot.db.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fandou.springboot.db.dao.MenuMapper;
import com.fandou.springboot.db.model.Menu;
import com.fandou.springboot.db.service.MenuService;

/**
 * @Title: MenuServiceImpl
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月6日 下午6:12:08
 * @version V0.0.1
 */
@Service
public class MenuServiceImpl implements MenuService {
	@Autowired
	private MenuMapper menuMapper;
	
	/** 
	 * @Title: getAllMenus 
	 * @Description: 一句话描述方法的作用
	 * @return
	 */
	@Override
	public List<Menu> getAllMenus() {
		return menuMapper.getAllMenus();
	}

}
