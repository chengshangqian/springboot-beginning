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
package com.fandou.springboot.vhr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.fandou.springboot.vhr.mapper.MenuMapper;
import com.fandou.springboot.vhr.model.Menu;
import com.fandou.springboot.vhr.service.MenuService;

/**
 * @Title: MenuServiceImpl
 * @Description: 菜单服务  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月6日 下午6:12:08
 * @version V0.0.1
 */
@Service
@CacheConfig(cacheNames="vhr_menu_cache")
public class MenuServiceImpl implements MenuService {
	
	@Autowired
	private MenuMapper menuMapper;
	
	/** 
	 * @Title: getAllMenus 
	 * @Description: 一句话描述方法的作用
	 * @return
	 */
	@Override
	@Cacheable(key="#root.method")
	public List<Menu> getAllMenus() {
		return menuMapper.getAllMenus();
	}
}
