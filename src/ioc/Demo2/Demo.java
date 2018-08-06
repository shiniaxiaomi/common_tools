package ioc.Demo2;

/**
 * Created by Yingjie.Lu on 2018/8/2.
 */


/**
 * @Title: 利用多态实现类的解耦,模拟ioc的功能
 * @Date: 2018/8/2 11:00
 */
public class Demo {
    public static void main(String[] args) {
//        JavaWork javaWork=new JavaWork();
//        javaWork.doTest();

        JavaWork javaWork=new JavaWork();
        javaWork.setTester(new LiSi());
        javaWork.doTest();

    }
}
