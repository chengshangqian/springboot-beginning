/**   
 * @Title: CatController.java 
 * @Package com.fandou.springboot.valid.controller 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月4日 下午7:32:15
 * @version V0.0.1  
 */
package com.fandou.springboot.valid.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fandou.springboot.valid.model.Cat;

/**
 * @Title: CatController
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月4日 下午7:32:15
 * @version V0.0.1
 */
@RestController
public class CatController {
	private Logger logger = LogManager.getLogger(CatController.class);
	
	@PostMapping("/cat")
	public List<String> addCat(@RequestBody@Validated Cat cat,BindingResult result) {
		List<String> errors = new ArrayList<>();
		
		if(result.hasErrors()) {
			List<ObjectError> allErrors = result.getAllErrors();
			for(ObjectError o : allErrors) {
				logger.info("o.getDefaultMessage() => " + o.getDefaultMessage());
				logger.info("o.getObjectName() => " + o.getObjectName());
				logger.info("o.getCode() => " + o.getCode());
				for(Object arg : o.getArguments()) {
					logger.info("o.getArguments() => " + arg.toString() );
				}
				for(String c : o.getCodes()) {
					logger.info("o.getCodes() => " + c.toString() );
				}
				errors.add(o.getDefaultMessage());
			}
		}
		
		return  errors;
	}
}
