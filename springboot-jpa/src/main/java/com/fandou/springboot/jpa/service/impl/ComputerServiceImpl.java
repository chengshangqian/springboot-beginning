/**   
 * @Title: ComputerServiceImpl.java 
 * @Package com.fandou.springboot.jpa.service.impl 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月31日 上午12:17:47
 * @version V0.0.1  
 */
package com.fandou.springboot.jpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fandou.springboot.jpa.dao.readonly.ReadOnlyComputerDao;
import com.fandou.springboot.jpa.dao.writeonly.WriteOnlyComputerDao;
import com.fandou.springboot.jpa.model.Computer;
import com.fandou.springboot.jpa.service.ComputerService;

/**
 * @Title: ComputerServiceImpl
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月31日 上午12:17:47
 * @version V0.0.1
 */
@Service
public class ComputerServiceImpl implements ComputerService {
	@Autowired
	ReadOnlyComputerDao readOnlyComputerDao;
	
	@Autowired
	WriteOnlyComputerDao writeOnlyComputerDao;
	
	/** 
	 * @Title: getMaxIdComputer 
	 * @Description: 一句话描述方法的作用
	 * @return
	 */
	@Override
	public Computer getMaxIdComputer() {
		return readOnlyComputerDao.getMaxIdComputer();
	}

	/** 
	 * @Title: getLastComputer 
	 * @Description: 一句话描述方法的作用
	 * @return
	 */
	@Override
	public Computer getLastComputer() {
		return writeOnlyComputerDao.getLastComputer();
	}

	/** 
	 * @Title: addComputer 
	 * @Description: 一句话描述方法的作用
	 * @param computer
	 * @return
	 */
	@Override
	public Computer addComputer(Computer computer) {
		return writeOnlyComputerDao.save(computer);
	}

}
