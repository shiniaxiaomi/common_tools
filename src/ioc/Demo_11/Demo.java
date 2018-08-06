package ioc.Demo_11;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Yingjie.Lu on 2018/8/3.
 */

/**
 * @Title: 注入参数: 集合类型属性(List,Set,Map)
 * @Date: 2018/8/3 13:41
 */ 
public class Demo {

    public static void main(String[] args) {

        ApplicationContext ac=new ClassPathXmlApplicationContext("ioc/Demo_11/beans.xml");
        People people= (People) ac.getBean("people");
        System.out.println(people);
    }
}
