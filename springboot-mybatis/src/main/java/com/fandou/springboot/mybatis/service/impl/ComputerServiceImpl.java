/**   
 * @Title: ComputerServiceImpl.java 
 * @Package com.fandou.springboot.mybatis.service.impl 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月30日 下午9:59:08
 * @version V0.0.1  
 */
package com.fandou.springboot.mybatis.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fandou.springboot.mybatis.dao.readonly.ReadOnlyComputerMapper;
import com.fandou.springboot.mybatis.dao.writeonly.WriteOnlyComputerMapper;
import com.fandou.springboot.mybatis.model.Computer;
import com.fandou.springboot.mybatis.service.ComputerService;

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
	WriteOnlyComputerMapper writerOnlyComputerMapper;
	
	@Autowired
	ReadOnlyComputerMapper readOnlyComputerMapper;
	
	/** 
	 * @Title: addComputer 
	 * @Description: 一句话描述方法的作用
	 * @param computer
	 * @return
	 */
	@Override
	public int addComputer(Computer computer) {
		return writerOnlyComputerMapper.addComputer(computer);
	}

	/** 
	 * @Title: getAllComputers 
	 * @Description: 一句话描述方法的作用
	 * @return
	 */
	@Override
	public List<Computer> getAllComputers() {
		return readOnlyComputerMapper.getAllComputers();
	}

}
