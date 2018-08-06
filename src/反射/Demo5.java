package 反射;

import java.lang.reflect.Method;

/**
 * Created by Yingjie.Lu on 2018/7/26.
 */
public class Demo5 {

    public static void main(String[] args) throws Exception {

        //1.获取Student对象的字节码
        Class clazz=Class.forName("反射.Student4");//包名加类名

        //2.获取main方法
        //第一个参数，对象类型，因为方法是static静态的，所以为null可以，第二个参数是String数组
        Method m=clazz.getMethod("main",String[].class);//第一个参数:方法名称;第二个参数:方法形参的类型

        //3.调用main方法
        m.invoke(null, (Object) new String[]{"a","b","c"});


    }
}
