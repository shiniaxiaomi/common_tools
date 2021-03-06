package ioc.Demo7;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Yingjie.Lu on 2018/8/3.
 */

/**
 * @Title: 静态工厂方法注入
 * @Date: 2018/8/3 14:02
 */ 
public class Demo {

    public static void main(String[] args) {

        ApplicationContext ac=new ClassPathXmlApplicationContext("ioc/Demo7/beans.xml");
        People people= (People) ac.getBean("people");
        System.out.println(people);
    }
}
