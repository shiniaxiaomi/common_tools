package 反射;

import java.lang.reflect.Field;

/**
 * Created by Yingjie.Lu on 2018/7/25.
 */

/*
 * 获取成员变量并调用：
 *
 * 1.批量的
 * 		1).Field[] getFields():获取所有的"公有字段"
 * 		2).Field[] getDeclaredFields():获取所有字段，包括：私有、受保护、默认、公有；
 * 2.获取单个的：
 * 		1).public Field getField(String fieldName):获取某个"公有的"字段；
 * 		2).public Field getDeclaredField(String fieldName):获取某个字段(可以是私有的)
 *
 * 	 设置字段的值：
 * 		Field --> public void set(Object obj,Object value):
 * 					参数说明：
 * 					1.obj:要设置的字段所在的对象；
 * 					2.value:要为字段设置的值；
 *
 */

public class Demo3 {

    public static void main(String[] args) throws Exception {

        //1.获取class对象
        Class stuClass=Class.forName("反射.Student2");

        //2.获取字段
        System.out.println("************获取所有公有的字段********************");
        Field[]  fields=stuClass.getFields();
        for(Field f:fields){
            System.out.println(f);
        }

        System.out.println("************获取所有的字段(包括私有、受保护、默认的)********************");
        Field[] fields1=stuClass.getDeclaredFields();
        for(Field f:fields1){
            System.out.println(f);
        }

        System.out.println("*************获取公有字段**并调用***********************************");
        Field f=stuClass.getField("sex");
        System.out.println(f);

        //获取一个对象
        Object obj=stuClass.getConstructor().newInstance();//产生Student对象--》Student stu = new Student();
//        //为字段设置值
//        f.set(obj,"sfsdf");
//        //验证
//        Student2 stu= (Student2) obj;
//        System.out.println(stu);

        Student2 stu= (Student2) obj;
        stu.setName("s11111");
        System.out.println(stu);
    }

}
