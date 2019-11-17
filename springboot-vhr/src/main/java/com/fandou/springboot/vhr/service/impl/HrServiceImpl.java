/**   
 * @Title: HrServiceImpl.java 
 * @Package com.fandou.springboot.vhr.service.impl 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月9日 下午10:13:17
 * @version V0.0.1  
 */
package com.fandou.springboot.vhr.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fandou.springboot.vhr.mapper.HrMapper;
import com.fandou.springboot.vhr.model.Hr;
import com.fandou.springboot.vhr.service.HrService;

/**
 * @Title: HrServiceImpl
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月9日 下午10:13:17
 * @version V0.0.1
 */
@Service
public class HrServiceImpl implements HrService {
	
	@Autowired
	private HrMapper hrMapper;

	/** 
	 * @Title: loadUserByUsername 
	 * @Description: 一句话描述方法的作用
	 * @param username
	 * @return
	 * @throws UsernameNotFoundException
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Hr hr = hrMapper.loadHrByUsername(username);
		
		if(null == hr) {
			throw new UsernameNotFoundException("用户 " + username + " 不存在.");
		}
		
		hr.setRoles(hrMapper.getHrRolesByHid(hr.getId()));
		
		return hr;
	}

}
