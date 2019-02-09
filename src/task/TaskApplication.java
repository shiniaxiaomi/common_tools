package task;

/**
 * Created by Administrator on 2019/2/9.
 */


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 任务启动类
 */

/**
 * 1.异步任务
 * 2.定时任务
 * 3.邮件任务
 */
@EnableAsync    //开启异步
@EnableScheduling   //开启定时任务
@SpringBootApplication
public class TaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskApplication.class, args);
    }
}
