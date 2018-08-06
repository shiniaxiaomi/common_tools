package ioc.Demo_14;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Yingjie.Lu on 2018/8/3.
 */

/**
 * @Title: bean之间的关系: 继承
 * @Date: 2018/8/3 13:41
 */ 
public class Demo {

    public static void main(String[] args) {

        ApplicationContext ac=new ClassPathXmlApplicationContext("ioc/Demo_14/beans.xml");
        People people= (People) ac.getBean("zhangsan");
        System.out.println(people);

        People people2= (People) ac.getBean("lisi");
        System.out.println(people2);
    }
}
