/**   
 * @Title: BookServiceImpl.java 
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
import org.springframework.stereotype.Service;

import com.fandou.springboot.chapter05.dao.BookMapper;
import com.fandou.springboot.chapter05.model.Book;
import com.fandou.springboot.chapter05.service.BookService;

/**
 * @Title: BookServiceImpl
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月29日 下午10:24:13
 * @version V0.0.1
 */
@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookMapper bookMapper;
	
	/** 
	 * @Title: addBook 
	 * @Description: 一句话描述方法的作用
	 * @param book
	 * @return
	 */
	@Override
	public int addBook(Book book) {
		return bookMapper.addBook(book);
	}

	/** 
	 * @Title: deleteBook 
	 * @Description: 一句话描述方法的作用
	 * @param id
	 * @return
	 */
	@Override
	public int deleteBook(Integer id) {
		return bookMapper.deleteBook(id);
	}

	/** 
	 * @Title: updateBook 
	 * @Description: 一句话描述方法的作用
	 * @param book
	 * @return
	 */
	@Override
	public int updateBook(Book book) {
		return bookMapper.updateBook(book);
	}

	/** 
	 * @Title: selectBook 
	 * @Description: 一句话描述方法的作用
	 * @param id
	 * @return
	 */
	@Override
	public Book selectBook(Integer id) {
		return bookMapper.selectBook(id);
	}

	/** 
	 * @Title: selectAllBook 
	 * @Description: 一句话描述方法的作用
	 * @return
	 */
	@Override
	public List<Book> selectAllBook() {
		return bookMapper.selectAllBook();
	}

}
