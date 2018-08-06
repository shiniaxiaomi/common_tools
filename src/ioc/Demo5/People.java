package ioc.Demo5;

/**
 * Created by Yingjie.Lu on 2018/8/3.
 */
public class People {

    private int id;
    private String name;
    private int age;

    //必须要有属性一一对应的构造方法
    public People(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
