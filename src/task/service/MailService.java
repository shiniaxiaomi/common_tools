package task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * Created by Administrator on 2019/2/9.
 */

@Service
public class MailService {


    @Autowired
    JavaMailSenderImpl mailSender;

    //发送简单邮件
    public void sendMail(){
        SimpleMailMessage mailMessage=new SimpleMailMessage();
        mailMessage.setSubject("通知：今晚开会");
        mailMessage.setText("今晚8点开会");
        mailMessage.setTo("13566672101@163.com");
        mailMessage.setFrom("806648324@qq.com");

        mailSender.send(mailMessage);
    }

    //发送复杂邮件
    public void sendMimeMail() throws Exception {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
        messageHelper.setSubject("通知：今晚开会");
        messageHelper.setText("<span style='color:red'>今晚8点开会</span>",true);//可以设置html的文本内容
        messageHelper.setTo("13566672101@163.com");
        messageHelper.setFrom("806648324@qq.com");

        //添加附件
        messageHelper.addAttachment("1.jpg",new File("C:\\Users\\Administrator\\Desktop\\社交软件\\个人信息.jpg"));

        mailSender.send(mimeMessage);
    }


}
