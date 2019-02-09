package task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import task.service.AsynService;

/**
 * Created by Administrator on 2019/2/9.
 */

@RestController
public class AsynController {

    @Autowired
    AsynService asynService;

    @RequestMapping("/hello")
    public String hello(){
        asynService.hello();
        return "success";
    }



}
