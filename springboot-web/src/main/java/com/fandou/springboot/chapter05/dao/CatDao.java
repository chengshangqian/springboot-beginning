/**   
 * @Title: CatDao.java 
 * @Package com.fandou.springboot.chapter05.dao 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月30日 下午6:14:59
 * @version V0.0.1  
 */
package com.fandou.springboot.chapter05.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.fandou.springboot.chapter04.model.Cat;

/**
 * @Title: CatDao
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月30日 下午6:14:59
 * @version V0.0.1
 */
@Repository
public class CatDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public int addCat(Cat cat) {
		return jdbcTemplate.update("insert into cat(name,color) values (?,?)", cat.getName(),cat.getColor());
	}
	
	public int updateCat(Cat cat) {
		return jdbcTemplate.update("update cat set name = ?,color = ? where id = ?", cat.getName(),cat.getColor(),cat.getId());
	}
	
	public int deleteCat(Integer id) {
		return jdbcTemplate.update("delete from cat where id = ?", id);
	}
	
	public Cat getCat(Integer id) {
		return jdbcTemplate.queryForObject("select id,name,color from cat where id = ?", new BeanPropertyRowMapper<>(Cat.class), id);
	}
	
	public List<Cat> getAllCats() {
		return jdbcTemplate.query("select id,name,color from cat", new BeanPropertyRowMapper<>(Cat.class));
	}
}
