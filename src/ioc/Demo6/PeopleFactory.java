package ioc.Demo6;


/**
 * Created by Yingjie.Lu on 2018/8/3.
 */
public class PeopleFactory {

    //返回一个javabean
    public People createPeople(){
        People p=new People();
        p.setId(5);
        p.setName("zhangsan");
        p.setAge(22);
        return p;
    }
}
