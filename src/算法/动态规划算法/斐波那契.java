package 算法.动态规划算法;

import 算法._计时工具类.MyTimer;

/**
 * Created by Yingjie.Lu on 2018/8/22.
 */
public class 斐波那契 extends MyTimer{

    public static int digui(int n){
        if(n==1||n==2){
            return 1;
        }else {
            return digui(n-1)+digui(n-2);
        }
    }

    /**
     * 所有的运行都写在这里
     */
    @Override
    public void myTimer() {

        System.out.println(digui(45));//用时4416 毫秒  1134903170

    }

    public static void main(String[] args) {
        new 斐波那契().start();
    }
}
