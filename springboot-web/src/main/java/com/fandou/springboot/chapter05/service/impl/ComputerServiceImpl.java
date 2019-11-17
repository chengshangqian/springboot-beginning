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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fandou.springboot.chapter04.model.Computer;
import com.fandou.springboot.chapter05.dao.ComputerDao;
import com.fandou.springboot.chapter05.service.ComputerService;

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
public class ComputerServiceImpl implements ComputerService {
	
	@Autowired
	ComputerDao computerDao;

	/** 
	 * @Title: addComputer 
	 * @Description: 一句话描述方法的作用
	 * @return
	 */
	@Override
	public void addComputer(Computer computer) {
		computerDao.save(computer);
	}

	/** 
	 * @Title: getComputerByPage 
	 * @Description: 一句话描述方法的作用
	 * @param pageable
	 * @return
	 */
	@Override
	public Page<Computer> getComputerByPage(Pageable pageable) {
		return computerDao.findAll(pageable);
	}	

	/** 
	 * @Title: getComputerByNameStartingWith 
	 * @Description: 一句话描述方法的作用
	 * @param name
	 * @return
	 */
	@Override
	public List<Computer> getComputerByNameStartingWith(String name) {
		return computerDao.getComputerByNameStartingWith(name);
	}

	/** 
	 * @Title: getMaxIdComputer 
	 * @Description: 一句话描述方法的作用
	 * @return
	 */
	@Override
	public Computer getMaxIdComputer() {
		return computerDao.getMaxIdComputer();
	}

	/** 
	 * @Title: getComputerByIdAndName 
	 * @Description: 一句话描述方法的作用
	 * @param id
	 * @param name
	 * @return
	 */
	@Override
	public List<Computer> getComputerByIdAndName(Integer id, String name) {
		return computerDao.getComputerByIdAndName(id, name);
	}

	/** 
	 * @Title: getComputerByNameAndId 
	 * @Description: 一句话描述方法的作用
	 * @param name
	 * @param id
	 * @return
	 */
	@Override
	public List<Computer> getComputerByNameAndId(String name, Integer id) {
		return computerDao.getComputerByNameAndId(name, id);
	}
}
