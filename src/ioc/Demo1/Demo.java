package ioc.Demo1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Yingjie.Lu on 2018/8/2.
 */
/**
 * @Title: spring ioc helloworld
 * @Date: 2018/8/2 10:59
 */
public class Demo {

    public static void main(String[] args) {
        ApplicationContext ac=new ClassPathXmlApplicationContext("ioc/Demo1/beans.xml");
        HelloWorld helloWorld= (HelloWorld) ac.getBean("helloWorld");
        helloWorld.say();
    }
}
