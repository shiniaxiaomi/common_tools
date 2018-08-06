package ioc.Demo_16;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by Yingjie.Lu on 2018/8/3.
 */

@Component
public class People {

    @Value("1")
    private int id;

    @Value("张三")
    private String name;

    @Value("12")
    private int age;

    @Autowired  //会从容器中按照类型去匹配
    private Dog dogs;

    @Resource(name = "cat") //会从容器中按照名称去匹配,默认的名称是成员变量中的名称
    private Cat cat;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public Dog getDogs() {
        return dogs;
    }

    public void setDogs(Dog dogs) {
        this.dogs = dogs;
    }

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", dogs=" + dogs +
                ", cat=" + cat +
                '}';
    }
}
