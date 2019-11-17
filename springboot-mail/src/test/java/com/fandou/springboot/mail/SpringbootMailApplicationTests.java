package com.fandou.springboot.mail;

import java.io.File;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fandou.springboot.mail.service.MailService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMailApplicationTests {

	@Autowired
	MailService mailService;
	
	@Test
	public void contextLoads() {
		String to  = "chengshangqian@foxmail.com";
		String from = "173030513@qq.com";
		String cc = "chengshangqian@126.com";
		String subject = "账号激活通知";
		String simpleContent = "你好！欢迎使用项目交付管理系统的邮件服务！";
		
		String[] resPaths = {"C:/Users/cheng/Pictures/图片1.png","C:/Users/cheng/Pictures/图片2.png","C:/Users/cheng/Pictures/图片3.png"};
		String[] resIds = {"p1","p2","p3"};
		String richContent = "<div>你好！欢迎使用项目交付管理系统的邮件服务！</div>"
		+ "<div><label>这是图片1:</label><img src='cid:p1' /></div>"
		+ "<div><label>这是图片2:</label><img src='cid:p2' /></div>"
		+ "<div><label>这是图片3:</label><img src='cid:p3' /></div>";
		
		File[] files = new File[resPaths.length];
		for(int i = 0; i < resPaths.length; i++) {
			files[i] = new File(resPaths[i]);
		}
		
		String template = "mailtemplate.html";
		
		mailService.sendSimpleMail(subject, simpleContent, from, to, cc);
		mailService.sendAttachmentMail(subject, simpleContent, from, to, files, cc);
		mailService.sendRichMail(subject, richContent, from, to, resPaths, resIds, cc);
		mailService.sendHtmlMail(subject, template, from, to, files, cc);
		
	}

}
