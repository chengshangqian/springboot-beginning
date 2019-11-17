/**   
 * @Title: BookController.java 
 * @Package com.fandou.springboot.chapter05.controller 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
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

import com.fandou.springboot.chapter05.model.Book;
import com.fandou.springboot.chapter05.service.BookService;

/**
 * @Title: BookController
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月29日 下午10:27:25
 * @version V0.0.1
 */
@RestController
public class BookController {
	private Logger logger = LogManager.getLogger(BookController.class);
	
	@Autowired
	BookService bookService;
	
	@GetMapping("/books")
	public List<Book> bookOps() {
//		Book cb = new Book();
//		cb.setName("西厢记");
//		cb.setAuthor("王实甫");
//		logger.debug("添加书本数量  ====> " + bookService.addBook(cb));
//		
//		List<Book> books = bookService.selectAllBook();
//		logger.debug("当前库存书本数量  ====> " + books.size() + ", 详细如下：");
//		int i = 0;
//		for(Book cbk : books) {
//			logger.debug((++i) + "、{name:" + cbk.getName() + ",author:"+ cbk.getAuthor()+"}");
//		}
//		
//		Book updateBook = new Book();
//		updateBook.setId(1);
//		updateBook.setName("朝花夕拾");
//		updateBook.setAuthor("鲁迅");
//		logger.debug("更新书本数量  ====> " + bookService.updateBook(updateBook));
//		
//		Book book = bookService.selectBook(1);
//		logger.debug("查看书本详情  ====> {name:" + book.getName() + ",author:"+ book.getAuthor()+"}");
//		
//		logger.debug("删除书本数量  ====> " + bookService.deleteBook(2));
//		
//		books = bookService.selectAllBook();
//		logger.debug("剩余书本数量  ====> " + books.size() + ", 详细如下：");
//		i = 0;
//		for(Book c : books) {
//			logger.debug((++i) + "、{name:" + c.getName() + ",author:"+ c.getAuthor()+"}");
//		}
		
		logger.debug("======> 测试log4j2日志");
		
		return bookService.selectAllBook();
	}
}
