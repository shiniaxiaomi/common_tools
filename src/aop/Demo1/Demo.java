package aop.Demo1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext; /**
 * Created by Yingjie.Lu on 2018/8/3.
 */

/**
 * @Title: aop xml配置
 * @Date: 2018/8/3 13:41
 */ 
public class Demo {

    public static void main(String[] args) {

        ApplicationContext ac=new ClassPathXmlApplicationContext("aop/Demo1/beans.xml");
        StudentService studentService= (StudentService) ac.getBean("studentService");
        studentService.addStudent("张三");

    }
}
