/**   
 * @Title: CatController.java 
 * @Package com.fandou.springboot.api.controller 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月4日 下午11:10:55
 * @version V0.0.1  
 */
package com.fandou.springboot.api.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fandou.springboot.api.model.Cat;
import com.fandou.springboot.api.support.Result;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * @Title: CatController
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月4日 下午11:10:55
 * @version V0.0.1
 */
@RestController
@Api(tags="猫咪数据接口")
@RequestMapping("/api/cats")
public class CatController {
	private Logger logger = LogManager.getLogger(CatController.class);
	
	/**
	 * @Title: addCat 
	 * @Description: 添加猫咪信息，http://localhost:8080/api/cats
	 * @param cat
	 * @return
	 */
	@ApiOperation(value="添加猫咪",notes="新添加一只猫咪的信息",httpMethod = "POST")
	@PostMapping("/")
	public Cat addCat(@RequestBody Cat cat) {
		cat.setId(1);
		cat.setCreateDate(new Date());
		logger.debug("添加猫咪成功：id => " + cat.getId());		
		return cat;
	}
	
	/**
	 * @Title: updateCat 
	 * @Description: 更新猫咪信息，http://localhost:8080/api/cats
	 * @param cat
	 * @return
	 */
	@ApiOperation(value="更新猫咪",notes="根据主键id更新猫咪信息",httpMethod = "PUT")
	@PutMapping("/")
	public Cat updateCat(@RequestBody Cat cat) {
		cat.setUpdateDate(new Date());
		logger.debug("更新猫咪成功：id => " + cat.getId());		
		return cat;
	}
	
	/**
	 * @Title: deleteCat 
	 * @Description: 删除猫咪,http://localhost:8080/api/cats/1
	 * @param id
	 * @return
	 */
	@ApiOperation(value="删除猫咪",notes="根据主键id删除猫咪信息",httpMethod = "DELETE")
	@ApiImplicitParam(name = "id",value = "主键id", paramType = "path", required = true)
	@DeleteMapping("/{id}")
	public Result deleteCat(@PathVariable Integer id) {
		//TODO 从数据库中删除id匹配的猫咪
		logger.debug("删除猫咪成功：id => " + id);		
		//return Result.SUCCESS;
		Result deleteResult = new Result("success","200","删除猫咪成功");
		deleteResult.setResult(id);
		return deleteResult;
	}
	
	/**
	 * @Title: findCat 
	 * @Description:查找猫咪,http://localhost:8080/api/cats/1
	 * @param id
	 * @return
	 */
	@ApiOperation(value="查找猫咪",notes="根据主键id查找猫咪信息",httpMethod = "GET")
	@ApiImplicitParam(name = "id",value = "主键id", paramType = "path", required = true)
	@GetMapping("/{id}")
	public Cat findCat(@PathVariable Integer id) {
		logger.debug("查找猫咪: id => " + id);
		//TODO 从数据库中查询id匹配的猫咪
		System.out.println();
		Cat c = new Cat();
		c.setId(id);
		c.setName("Jerry");
		c.setColor("Yellow");
		return c;
	}
	
	/**
	 * @Title: findCat 
	 * @Description: 根据猫咪名称全匹配查找：http://localhost:8080/api/cats/search/name?name=Jerry
	 * @param name
	 * @return
	 */
	@ApiOperation(value="查找特定名字的猫咪",notes="通过名称name全匹配查找猫咪信息",httpMethod = "GET")
	@ApiImplicitParam(name = "name",value = "猫咪名字", paramType = "query",dataType = "string", required = true)	
	@GetMapping("/search/name")
	public Cat findCat(@RequestParam String name) {
		logger.debug("查找猫咪: name => " + name);
		//TODO 从数据库中查询名字匹配的猫咪
		Cat c = new Cat();
		c.setId(1);
		c.setName("Jerry");
		c.setColor("Yellow");
		return c;
	}
	
	/**
	 * @Title: findCats 
	 * @Description: 根据颜色模糊查找：http://localhost:8080/api/cats/search/color?color=Yellow
	 * @param model
	 * @return
	 */
	@GetMapping("/search/color")
	@ApiOperation(value="查找颜色相同的猫咪",notes="通过颜色color模糊查找颜色相同的猫咪信息",httpMethod = "GET")
	@ApiImplicitParam(name = "color",value = "猫咪颜色", paramType = "query",dataType = "string", required = true)	
	public List<Cat> findCats(@RequestParam String color){
		logger.debug("查找颜色相同的猫咪: color => " + color);
		//TODO 从数据库中查询颜色相同的猫咪
		List<Cat> cats = new ArrayList<>();
		for(int i = 0; i < 5; i++) {
			Cat c = new Cat();
			Integer id = i + 1;
			c.setId(id);
			c.setName("Jerry::" + id);
			c.setColor(color);
			cats.add(c);
		}
		
		return cats;
	}
}
