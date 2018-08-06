package ioc.Demo7;


/**
 * Created by Yingjie.Lu on 2018/8/3.
 */
public class PeopleFactory {

    //定义一个静态的方法,返回一个javabean
    public static People createPeople(){
        People p=new People();
        p.setId(7);
        p.setName("zhangsan");
        p.setAge(77);
        return p;
    }
}
