package 算法._计时工具类;

import java.util.Date;

/**
 * Created by Yingjie.Lu on 2018/8/22.
 */
/**
 * @Title: 一个计时算法时间的计时类
 * @Date: 2018/8/22 14:32
 */
public abstract class MyTimer {

    /**
     * 开始计时,并运行算法
     */
    public void start(){
        Date begin =new Date();

        myTimer();

        Date end =new Date();
        System.out.println("用时：" +String.valueOf(end.getTime()-begin.getTime())+ " 毫秒");

    }

    /**
     * 需要计时的都写在这个里面
     */
    public abstract void myTimer();

}
