package aop.Demo1;


/**
 * Created by Yingjie.Lu on 2018/8/7.
 */

public class StudentService {

    public void addStudent(String name){
        System.out.println("业务代码 : 添加学生"+name);
        System.out.println("业务代码 : "+1/0);//会抛出异常
    }
}
