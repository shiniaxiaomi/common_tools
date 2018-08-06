package 反射;

import java.lang.reflect.Method;

/**
 * Created by Yingjie.Lu on 2018/7/25.
 */

/*
 * 获取成员方法并调用：
 *
 * 1.批量的：
 * 		public Method[] getMethods():获取所有"公有方法"；（包含了父类的方法也包含Object类）
 * 		public Method[] getDeclaredMethods():获取所有的成员方法，包括私有的(不包括继承的)
 * 2.获取单个的：
 * 		public Method getMethod(String name,Class<?>... parameterTypes):
 * 					参数：
 * 						name : 方法名；
 * 						Class ... : 形参的Class类型对象
 * 		public Method getDeclaredMethod(String name,Class<?>... parameterTypes)
 *
 * 	 调用方法：
 * 		Method --> public Object invoke(Object obj,Object... args):
 * 					参数说明：
 * 					obj : 要调用方法的对象；
 * 					args:调用方式时所传递的实参；
):
 */

public class Demo4 {

    public static void main(String[] args) throws Exception {

        //1.获取class对象
        Class stu=Class.forName("反射.Student3");

        //2.获取所有公有方法
        System.out.println("***************获取所有的”公有“方法*******************");
        Method[] methondArray= stu.getMethods();
        for(Method m:methondArray){
            System.out.println(m);
        }

        System.out.println("***************获取所有的方法，包括私有的*******************");
        methondArray=stu.getDeclaredMethods();
        for(Method m:methondArray){
            System.out.println(m);
        }

        System.out.println("***************获取公有的show1()方法*******************");
        Method m=stu.getMethod("show1", String.class);
        System.out.println(m);
        //实例化一个Student3对象
        Object obj=stu.getConstructor().newInstance();
        m.invoke(obj,"liudehua");

        System.out.println("***************获取私有的show4()方法******************");
        m=stu.getDeclaredMethod("show4", int.class);
        System.out.println(m);
        m.setAccessible(true);//解除私有限定
        Object result=m.invoke(obj,20);//需要两个参数,一个是要调用的对象(获取有反射),一个是实参,result是方法的返回值
        System.out.println(result);

    }

}
