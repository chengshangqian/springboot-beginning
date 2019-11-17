/**   
 * @Title: MailServiceImpl.java 
 * @Package com.fandou.springboot.mail.service.impl 
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月5日 下午3:37:28
 * @version V0.0.1  
 */
package com.fandou.springboot.mail.service.impl;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.fandou.springboot.mail.service.MailService;

/**
 * @Title: MailServiceImpl
 * @Description: TODO(一句话描述该类的业务或功能)  
 * @Copyright: ©2019
 * @Company: Fandou Technology Co., Ltd.
 * @author 成尚谦
 * @email chengshangqian@foxmail.com
 * @date 2019年11月5日 下午3:37:28
 * @version V0.0.1
 */
@Service
public class MailServiceImpl implements MailService {
	private Logger logger = LogManager.getLogger(MailServiceImpl.class);
	
	@Autowired
	JavaMailSender sender;
	
	@Autowired
	TemplateEngine templateEngine;

	/**
	 * @Title: sendSimpleMail 
	 * @Description: 发送简单文本内容的邮件
	 * @param subject 主题
	 * @param content 内容
	 * @param from 发件人
	 * @param to 收件人
	 * @param cc 抄送
	 */
	@Override
	public void sendSimpleMail(String subject, String content, String from, String to, String cc) {
		SimpleMailMessage mimeMessage = new SimpleMailMessage();
		mimeMessage.setFrom(from);
		mimeMessage.setTo(to);
		if(null != cc) {
			mimeMessage.setCc(cc);
		}
		mimeMessage.setSubject(subject);
		mimeMessage.setText(content);
		sender.send(mimeMessage);
		
		logger.info("简单文本邮件发送成功!");
	}

	/**
	 * @Title: sendAttachFileMail 
	 * @Description: 发送带附件的邮件
	 * @param subject 主题
	 * @param content 内容
	 * @param from 发件人
	 * @param to 收件人
	 * @param files 附件列表
	 * @param cc 抄送
	 */
	@Override
	public void sendAttachmentMail(String subject, String content, String from, String to, File[] files, String cc) {
		try {
			MimeMessage mimeMessage = sender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
			helper.setFrom(from);
			helper.setTo(to);
			if(null != cc) {
				helper.setCc(cc);
			}
			helper.setSubject(subject);
			helper.setText(content);
			if(null != files) {
				for(File file:files) {
					helper.addAttachment(file.getName(), file);
				}
			}
			sender.send(mimeMessage);
		} catch (MailException | MessagingException e) {
			logger.error("发送附件邮件失败  => "+e.getMessage());
			e.printStackTrace();
		}
		
		logger.info("附件邮件发送成功!");
	}

	/**
	 * @Title: sendRichContentMail 
	 * @Description: 发送带图片的邮件
	 * @param subject 主题
	 * @param content 内容
	 * @param from 发件人
	 * @param to 收件人
	 * @param resPaths 图片本地路径
	 * @param resIds 图片资源id
	 * @param cc 抄送
	 */
	@Override
	public void sendRichMail(String subject, String content, String from, String to, String[] resPaths, String[] resIds,
			String cc) {
		if(resPaths.length != resIds.length) {
			logger.error("发送富文本邮件失败  => 资源文件参数resPaths与resIds长度不一致.");
			return;
		}
		
		try {
			MimeMessage mimeMessage = sender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
			helper.setFrom(from);
			helper.setTo(to);
			if(null != cc) {
				helper.setCc(cc);
			}
			helper.setSubject(subject);
			helper.setText(content,true);
			for(int i = 0; i < resPaths.length; i++) {
				FileSystemResource res = new FileSystemResource(new File(resPaths[i]));
				helper.addInline(resIds[i], res);
			}
			sender.send(mimeMessage);
		} catch (MailException | MessagingException e) {
			logger.error("发送富文本邮件失败  => "+e.getMessage());
			e.printStackTrace();
		}
		
		logger.info("富文本邮件发送成功!");
	}

	/**
	 * @Title: sendHtmlMail 
	 * @Description: 使用Thymeleaf模板发送html邮件
	 * @param subject 主题
	 * @param template html模板
	 * @param from 发件人
	 * @param to 收件人
	 * @param files 附件列表
	 * @param cc 抄送
	 */
	@Override
	public void sendHtmlMail(String subject,String template, String from, String to, File[] files, String cc) {
		//TODO 使用Thymeleaf模板发送html邮件
		String _template = null == template ? "mailtemplate.html" : template;
		//TODO context的内容应设计为业务参数传入
		Context context = new Context();
		context.setVariable("username", "成九五");
		context.setVariable("email", "男");
		String content = templateEngine.process(_template, context);
		//logger.debug("HTML邮件内容  => " + content);
		
		try {
			MimeMessage mimeMessage = sender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
			helper.setFrom(from);
			helper.setTo(to);
			if(null != cc) {
				helper.setCc(cc);
			}
			helper.setSubject(subject);
			helper.setText(content,true);
			if(null != files) {
				for(File file:files) {
					helper.addAttachment(file.getName(), file);
				}
			}
			sender.send(mimeMessage);
		} catch (MailException | MessagingException e) {
			logger.error("发送HTML邮件失败  => "+e.getMessage());
			e.printStackTrace();
		}
		
		logger.info("HTML邮件发送成功!");
	}

}
