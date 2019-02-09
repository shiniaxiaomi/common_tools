package task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import task.service.MailService;

/**
 * Created by Administrator on 2019/2/9.
 */

@RestController
public class MailController {


    @Autowired
    MailService mailService;

    @RequestMapping("/sendMail")
    public String sendMail(){
        mailService.sendMail();
        return "success";
    }

    @RequestMapping("/sendMimeMail")
    public String sendMimeMail() throws Exception {
        mailService.sendMimeMail();
        return "success";
    }

}
