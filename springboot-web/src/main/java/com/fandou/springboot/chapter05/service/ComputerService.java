/**   
 * @Title: ComputerDao.java 
 * @Package com.fandou.springboot.chapter05.dao 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月30日 下午7:20:11
 * @version V0.0.1  
 */
package com.fandou.springboot.chapter05.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.fandou.springboot.chapter04.model.Computer;

/**
 * @Title: ComputerDao
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月30日 下午7:20:11
 * @version V0.0.1
 */
public interface ComputerService{
	
	void addComputer(Computer computer);
	
	Page<Computer> getComputerByPage(Pageable pageable);
	
	List<Computer> getComputerByNameStartingWith(String name);
	
	Computer getMaxIdComputer();
	
	List<Computer> getComputerByIdAndName(Integer id,String name);
	
	List<Computer> getComputerByNameAndId(String name,Integer id);
	
}
