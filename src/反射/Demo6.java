package 反射;

import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * Created by Yingjie.Lu on 2018/7/26.
 */

/*
 * 我们利用反射和配置文件，可以使：应用程序更新时，对源码无需进行任何修改
 * 我们只需要将新类发送给客户端，并修改配置文件即可
 */

public class Demo6 {

    public static void main(String[] args) throws Exception {

        //1.通过反射获取class对象
        Class stuClass=Class.forName(getValue("className"));

        //2.获取show()方法
        Method m=stuClass.getMethod(getValue("methodName"));

        //3.调用show方法
        m.invoke(stuClass.getConstructor().newInstance());

    }


    public static String getValue(String key) throws Exception {

        Properties pro=new Properties();//获取配置文件的对象
        FileReader in=new FileReader("src\\反射\\pro.txt");//获取输入流
        pro.load(in);
        in.close();
        return pro.getProperty(key);//返回根据key获取的value值

    }


}
