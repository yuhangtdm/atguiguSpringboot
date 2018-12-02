package com.atguigu.task;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootTaskApplicationTests {

    @Autowired
    private JavaMailSenderImpl mailSender;

    @Test
    public void contextLoads() {

        SimpleMailMessage mailMessage=new SimpleMailMessage();
        mailMessage.setSubject("通知-今晚开会");
        mailMessage.setText("今晚十一点来我房里开会");
        mailMessage.setTo("1908715959@qq.com");
        mailMessage.setFrom("649411629@qq.com");
        mailSender.send(mailMessage);
    }

    @Test
    public void test1()throws Exception {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper=new MimeMessageHelper(mimeMessage,true);
        helper.setSubject("小幸运");
        helper.setText("<html><h1>青花瓷<h1><center><p>天青色等烟雨</p><p>而我在等你</p></center></html>",true);
        helper.addAttachment("1.jpg",new File("C:\\Users\\yuhang\\Pictures\\Camera Roll\\1.jpg"));
        helper.addAttachment("2.jpg",new File("C:\\Users\\yuhang\\Pictures\\Camera Roll\\2.jpg"));
        helper.setTo("1908715959@qq.com");
        helper.setFrom("649411629@qq.com");
        mailSender.send(mimeMessage);

    }

}
