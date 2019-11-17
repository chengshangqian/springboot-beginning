/**   
 * @Title: CatController.java 
 * @Package com.fandou.springboot.chapter05.controller 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @color 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月29日 下午10:27:25
 * @version V0.0.1  
 */
package com.fandou.springboot.chapter05.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fandou.springboot.chapter04.model.Cat;
import com.fandou.springboot.chapter05.service.CatService;

/**
 * @Title: CatController
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @color 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月29日 下午10:27:25
 * @version V0.0.1
 */
@RestController
public class CatController {
	private Logger logger = LogManager.getLogger(CatController.class);
	
	@Autowired
	CatService catService;
	
	@GetMapping("/cats")
	public List<Cat> cats() {
		logger.debug("======> cats");
		return catService.getAllCats();
	}
	
	@GetMapping("/cat/test")
	public List<Cat> catOps() {
		Cat cb = new Cat();
		cb.setName("西厢记");
		cb.setColor("王实甫");
		logger.debug("添加猫咪数量  ====> " + catService.addCat(cb));
		
		List<Cat> cats = catService.getAllCats();
		logger.debug("当前库存猫咪数量  ====> " + cats.size() + ", 详细如下：");
		int i = 0;
		for(Cat cbk : cats) {
			logger.debug((++i) + "、{name:" + cbk.getName() + ",color:"+ cbk.getColor()+"}");
		}
		
		Cat updateCat = new Cat();
		updateCat.setId(1);
		updateCat.setName("朝花夕拾");
		updateCat.setColor("鲁迅");
		logger.debug("更新猫咪数量  ====> " + catService.updateCat(updateCat));
		
		Cat cat = catService.getCat(1);
		logger.debug("查看猫咪详情  ====> {name:" + cat.getName() + ",color:"+ cat.getColor()+"}");
		
		logger.debug("删除猫咪数量  ====> " + catService.deleteCat(2));
		
		cats = catService.getAllCats();
		logger.debug("剩余猫咪数量  ====> " + cats.size() + ", 详细如下：");
		i = 0;
		for(Cat c : cats) {
			logger.debug((++i) + "、{name:" + c.getName() + ",color:"+ c.getColor()+"}");
		}
		
		logger.debug("======> catOps");
		
		return catService.getAllCats();
	}
}
