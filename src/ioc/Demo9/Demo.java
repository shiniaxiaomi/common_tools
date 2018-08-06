package ioc.Demo9;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Yingjie.Lu on 2018/8/3.
 */

/**
 * @Title: 注入已经定义的bean
 * @Date: 2018/8/3 13:41
 */ 
public class Demo {

    public static void main(String[] args) {

        ApplicationContext ac=new ClassPathXmlApplicationContext("ioc/Demo9/beans.xml");
        People people= (People) ac.getBean("people");
        System.out.println(people);
    }
}
