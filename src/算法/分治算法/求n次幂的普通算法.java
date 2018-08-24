package 算法.分治算法;

import 算法._计时工具类.MyTimer;


/**
 * Created by Yingjie.Lu on 2018/8/22.
 */

public class 求n次幂的普通算法 extends MyTimer{

    public static Long cimi(Long x,int y){
        Long sum=1L;
        for(int i=0;i<y;i++){
            sum=sum*x;
        }
        return sum;
    }


    /**
     * 所有的运行都写在这里
     */
    @Override
    public void myTimer() {
        for(int i=0;i<10000000;i++){//3.7秒钟
            cimi(2L,60);
        }
    }

    public static void main(String[] args) {
        new 求n次幂的普通算法().start();
    }
}
