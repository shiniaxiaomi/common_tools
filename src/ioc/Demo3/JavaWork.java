package ioc.Demo3;

/**
 * Created by Yingjie.Lu on 2018/8/2.
 */
public class JavaWork {

    private Tester tester;

    public Tester getTester() {
        return tester;
    }

    public void setTester(Tester tester) {
        this.tester = tester;
    }

    public void doTest(){
//        ZhangSan zhangSan=new ZhangSan();
//        zhangSan.test();

        tester.test();//测试员做测试
    }
}
