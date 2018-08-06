package ioc.Demo_13;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Yingjie.Lu on 2018/8/3.
 */

/**
 * @Title: 自动装配(byType)
 * @Date: 2018/8/3 13:41
 */ 
public class Demo {

    public static void main(String[] args) {

        ApplicationContext ac=new ClassPathXmlApplicationContext("ioc/Demo_13/beans.xml");
        People people= (People) ac.getBean("people");
        System.out.println(people);

        People2 people2= (People2) ac.getBean("people2");
        System.out.println(people2);
    }
}
