package 反射;

import java.lang.reflect.Constructor;

/**
 * Created by Yingjie.Lu on 2018/7/25.
 */

/**
 * 通过反射获取构造方法并使用
 */
public class Demo2 {

    
    public static void main(String[] args) throws Exception {
        
        //1.加载class对象
        Class clazz=Class.forName("反射.Student");//这个就是反射,通过Student.class文件就可以吧内容读取到内存中
        
        //2.获取所有共有构造方法
        System.out.println("**********************所有公有构造方法*********************************");
        Constructor[] constructors=clazz.getConstructors();
        for(Constructor c:constructors){
            System.out.println(c);
        }
        
        System.out.println("*****************获取公有、无参的构造方法*******************************");
        //因为是无参的构造方法,座椅类型是一个null,不写也可以,这里需要的是一个参数的类型,切记是类型;返回的是描述这个无参构造函数的类对象
        Constructor con=clazz.getConstructor(null);
        
        System.out.println(con);
        Object obj =con.newInstance();//调用无参的构造方法
        System.out.println(obj);
        Student stu= (Student) obj;
        stu.setAge(10);
        System.out.println(stu);

        System.out.println("******************获取私有构造方法，并调用*******************************");
        con=clazz.getDeclaredConstructor(char.class);//获取
        System.out.println(con);
        //调用构造方法
        con.setAccessible(true);//暴力访问(忽略掉访问修饰符,跳过安全检查)
        obj=con.newInstance('男');

    }
}
