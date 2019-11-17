/**   
 * @Title: UserServiceImpl.java 
 * @Package com.fandou.springboot.oauth2.service.impl 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月6日 下午2:56:25
 * @version V0.0.1  
 */
package com.fandou.springboot.oauth2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fandou.springboot.oauth2.dao.UserMapper;
import com.fandou.springboot.oauth2.model.User;
import com.fandou.springboot.oauth2.service.UserService;

/**
 * @Title: UserServiceImpl
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月6日 下午2:56:25
 * @version V0.0.1
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	/** 
	 * @Title: loadUserByUsername 
	 * @Description: 查询登录用户信息，如果用户存在，将同时加载用户的角色信息
	 * @param username
	 * @return
	 * @throws UsernameNotFoundException
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userMapper.loadUserByUsername(username);
		
		if(null == user) {
			throw new UsernameNotFoundException("账户不存在");
		}
		
		user.setRoles(userMapper.getUserRolesByUid(user.getId()));
		
		return user;
	}

}
