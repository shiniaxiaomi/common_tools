package ioc.Demo_16;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by Yingjie.Lu on 2018/8/6.
 */

//可以指定名称,如果不指定名称,则默认为类名的首字母小写
@Component("cat")
public class Cat {

    @Value("Jam")
    private String name;

    @Value("121")
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
