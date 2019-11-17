/**   
 * @Title: CatService.java 
 * @Package com.fandou.springboot.chapter05.model.service 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月29日 下午10:23:54
 * @version V0.0.1  
 */
package com.fandou.springboot.chapter05.service;

import java.util.List;

import com.fandou.springboot.chapter04.model.Cat;

/**
 * @Title: CatService
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月29日 下午10:23:54
 * @version V0.0.1
 */
public interface CatService {
	int addCat(Cat cat);
	int deleteCat(Integer id);
	int updateCat(Cat cat);
	Cat getCat(Integer id);
	List<Cat> getAllCats();
}
