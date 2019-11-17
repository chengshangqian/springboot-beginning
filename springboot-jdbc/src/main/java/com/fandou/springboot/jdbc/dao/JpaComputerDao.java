/**   
 * @Title: ComputerDao.java 
 * @Package com.fandou.springboot.jdbc.dao
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月30日 下午6:14:59
 * @version V0.0.1  
 */
package com.fandou.springboot.jdbc.dao;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.fandou.springboot.jdbc.model.Computer;

/**
 * @Title: ComputerDao
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月30日 下午6:14:59
 * @version V0.0.1
 */
@Repository
public class JpaComputerDao {
	private Logger logger = LogManager.getLogger(JpaComputerDao.class);
	@Autowired
	@Qualifier("jpaJdbcTemplate")
	JdbcTemplate jpaJdbcTemplate;
	
	public int addComputer(Computer computer) {
		int i = jpaJdbcTemplate.update("insert into computer(name,model) values (?,?)", computer.getName(),computer.getModel());
		logger.debug("jpaJdbcTemplate computer.id => " + computer.getId());
		return i;
	}
	
	public int updateComputer(Computer computer) {
		return jpaJdbcTemplate.update("update computer set name = ?,model = ? where id = ?", computer.getName(),computer.getModel(),computer.getId());
	}
	
	public int deleteComputer(Integer id) {
		return jpaJdbcTemplate.update("delete from computer where id = ?", id);
	}
	
	public Computer getComputer(Integer id) {
		return jpaJdbcTemplate.queryForObject("select id,name,model from computer where id = ?", new BeanPropertyRowMapper<>(Computer.class), id);
	}
	
	public List<Computer> getAllComputers() {
		return jpaJdbcTemplate.query("select id,name,model from computer", new BeanPropertyRowMapper<>(Computer.class));
	}
}
