package 反射; /**
 * Created by Yingjie.Lu on 2018/7/25.
 */


/**
 * 获取Class对象的三种方式
 * 1 Object ——> getClass();
 * 2 任何数据类型（包括基本数据类型）都有一个“静态”的class属性
 * 3 通过Class类的静态方法：forName（String  className）(常用)
 **/


/**
 * 注意：在运行期间，一个类，只有一个Class对象产生。
 三种方式常用第三种，第一种对象都有了还要反射干什么。第二种需要导入类的包，依赖太强，不导包就抛编译错误。一般都第三种，一个字符串可以传入也可写在配置文件中等多种方法。
 */
public class Demo1 {

    public static void main(String[] args) {
        //第一种方式获取class对象
        Student stu=new Student();//这一new 产生一个student对象,一个class对象
        Class stuClass= stu.getClass();//获取class对象
        System.out.println(stuClass);
        
        //第二种方式获取class对象
        Class stuClass2=Student.class;
        System.out.println(stuClass2);

        //第三种方式获取class对象
        try {
            Class stuClass3=Class.forName("反射.Student");//注意此字符串必须是真实路径，就是带包名的类路径，包名.类名
            System.out.println(stuClass3);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
