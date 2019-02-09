package task.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2019/2/9.
 */

@Service
public class ScheduledService {

    /**
     * second(秒) ,minute（分）, hour（时）, day of month（日）, month（月）,day of week（周几）
     */
//    @Scheduled(cron = "0 * * * * SUN-SAT")//整点报时
//    @Scheduled(cron = "0,1,2,3,4 * * * * 1-7")//秒为1，2，3，4时执行
//    @Scheduled(cron = "0-4 * * * * 1-7")//秒为1，2，3，4时执行
    @Scheduled(cron = "0/10 * * * * 1-7")//每4秒执行一次
    public void hello(){
        System.out.println("hello....");
    }

}
