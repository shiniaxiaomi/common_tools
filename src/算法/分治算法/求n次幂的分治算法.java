package 算法.分治算法;

import 算法._计时工具类.MyTimer;


/**
 * Created by Yingjie.Lu on 2018/8/22.
 */

/**
 * @Title: 这个求n次幂的分治算法可以非常贴切的体现分治算法的思想
 *          因为次幂是可以分解成两个更小的次幂,然后就可以通过分治算法求解
 * @Date: 2018/8/23 16:24
 */
public class 求n次幂的分治算法 extends MyTimer{

    public static Long digui(Long x,int n){
        if(n==1){
            return x;
        }else{
            if(n%2==0){
                Long result=digui(x,n/2);
                return result*result;
            }else{
                return digui(x,(n+1)/2)*digui(x,(n-1)/2);
            }
        }
    }

    /**
     * 所有的运行都写在这里
     */
    @Override
    public void myTimer() {

        for(int i=0;i<10000000;i++){//1秒钟
            digui(2L,60);
        }

    }

    public static void main(String[] args) {
        new 求n次幂的分治算法().start();
    }
}
