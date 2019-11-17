/**   
 * @Title: ComputerServiceImpl.java 
 * @Package com.fandou.springboot.jdbc.service.impl 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月30日 下午9:59:08
 * @version V0.0.1  
 */
package com.fandou.springboot.jdbc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fandou.springboot.jdbc.dao.JpaComputerDao;
import com.fandou.springboot.jdbc.dao.TestComputerDao;
import com.fandou.springboot.jdbc.model.Computer;
import com.fandou.springboot.jdbc.service.ComputerService;

/**
 * @Title: ComputerServiceImpl
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月30日 下午9:59:08
 * @version V0.0.1
 */
@Service
public class ComputerServiceImpl implements ComputerService {
	@Autowired
	JpaComputerDao jpaComputerDao;
	
	@Autowired
	TestComputerDao testComputerDao;
	/** 
	 * @Title: addComputer 
	 * @Description: 一句话描述方法的作用
	 * @param computer
	 * @return
	 */
	@Override
	public int addComputer(Computer computer) {
		return jpaComputerDao.addComputer(computer) + testComputerDao.addComputer(computer);
	}

	/** 
	 * @Title: getAllComputers 
	 * @Description: 一句话描述方法的作用
	 * @return
	 */
	@Override
	public List<Computer> getAllComputers() {
		List<Computer> list = new ArrayList<Computer>();
		list.addAll(jpaComputerDao.getAllComputers());
		list.addAll(testComputerDao.getAllComputers());
		return list;
	}

}
