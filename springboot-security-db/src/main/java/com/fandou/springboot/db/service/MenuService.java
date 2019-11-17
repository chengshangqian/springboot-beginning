/**   
 * @Title: MenuService.java 
 * @Package com.fandou.springboot.db.service 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月6日 下午6:11:37
 * @version V0.0.1  
 */
package com.fandou.springboot.db.service;

import java.util.List;

import com.fandou.springboot.db.model.Menu;

/**
 * @Title: MenuService
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月6日 下午6:11:37
 * @version V0.0.1
 */
public interface MenuService {
	List<Menu> getAllMenus();
}
