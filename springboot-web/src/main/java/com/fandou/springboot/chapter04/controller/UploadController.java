/**   
 * @Title: HelloController.java 
 * @Package com.fandou.springboot.chapter01.controller 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年10月27日 下午8:13:22
 * @version V0.0.1  
 */
package com.fandou.springboot.chapter04.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UploadController {
	private Logger logger = LogManager.getLogger(UploadController.class);
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	
	@GetMapping("/upload")
	public ModelAndView toUpload() {
		return new ModelAndView("upload");
	}
	
	@GetMapping("/multiupload")
	public ModelAndView toMutilUpload() {
		return new ModelAndView("multiupload");
	}
	
	/**
	 * @Title: upload 
	 * @Description: 上传一个文件
	 * @param uploadFile
	 * @param req
	 * @return
	 */
	@PostMapping("/upload")
	@ResponseBody
	public String upload(MultipartFile uploadFile,HttpServletRequest req) {
		//磁盘真实路径
		String realPath = req.getSession().getServletContext().getRealPath("/uploadFile/");
		logger.debug("realPath => " + realPath);
		
		//生成日期子目录，便于管理
		String format = sdf.format(new Date());
		File folder = new File(realPath + format);
		//如果不存在，则创建
		if(!folder.isDirectory()) {
			folder.mkdirs();
		}
		
		//表单中file组件name
		logger.debug("fieldName => " + uploadFile.getName());
		
		//文件名字
		String originalFilename = uploadFile.getOriginalFilename();		
		logger.debug("originalFilename => " + originalFilename);
		
		//为避免重名,重命名文件后保存
		String fileName = UUID.randomUUID().toString() + originalFilename.substring(originalFilename.lastIndexOf("."),originalFilename.length());
		logger.debug("fileName => " + fileName);

		//保存到指定目录
		try {
			uploadFile.transferTo(new File(folder,fileName));
			String filePath = req.getScheme()+"://" + req.getServerName() + ":" + req.getServerPort()+"/uploadFile/" + format+"/" + fileName;
			logger.debug("filePath => " + filePath);
			return filePath;
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "上传失败";
	}
	
	/**
	 * @Title: multiUpload 
	 * @Description: 多文件上传
	 * @param uploadFiles
	 * @param req
	 * @return
	 */
	@PostMapping("/multiupload")
	@ResponseBody
	public String[] multiUpload(MultipartFile[] uploadFiles,HttpServletRequest req) {
		String str[] = new String[uploadFiles.length]; 
		
		for(int i = 0; i < uploadFiles.length; i++ ) {
			String filePath = this.upload(uploadFiles[i], req);
			str[i] = filePath;
		}
		
		return str;
	}
}
