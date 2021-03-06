package ioc.Demo5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Yingjie.Lu on 2018/8/3.
 */

/**
 * @Title: ioc 构造注入
 * @Date: 2018/8/3 9:26
 */
public class Demo {
    
    public static void main(String[] args) {

        ApplicationContext ac=new ClassPathXmlApplicationContext("ioc/Demo5/beans.xml");
        People people= (People) ac.getBean("people");
        System.out.println(people);
    }
    
}
