/**   
 * @Title: MenuMapper.java 
 * @Package com.fandou.springboot.db.dao 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月6日 下午2:24:34
 * @version V0.0.1  
 */
package com.fandou.springboot.vhr.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.fandou.springboot.vhr.model.Menu;

/**
 * @Title: MenuMapper
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月6日 下午2:24:34
 * @version V0.0.1
 */
@Mapper
public interface MenuMapper {
	List<Menu> getAllMenus();
}
