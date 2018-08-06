package ioc.Demo3;

/**
 * Created by Yingjie.Lu on 2018/8/2.
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Title: 通过修改配置文件,来达到类的解耦
 * (使用ioc自动注入:spring将配置文件 )
 * @Date: 2018/8/2 11:08
 */
public class Demo {

    public static void main(String[] args) {
        ApplicationContext ac=new ClassPathXmlApplicationContext("ioc/Demo3/beans.xml");
        JavaWork javaWork= (JavaWork) ac.getBean("javaWork");
        javaWork.doTest();
    }


}
