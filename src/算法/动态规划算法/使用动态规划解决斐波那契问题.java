package 算法.动态规划算法;

import 算法._计时工具类.MyTimer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yingjie.Lu on 2018/8/22.
 */
/**
 * @Title: 使用动态规划解决斐波那契问题
 *
 * 动态规划:使用缓存技术,将之前计算过的数据保存起来,当再次用到这个数据的时候,就可以从缓存中直接获取,不需要重新计算,大大的节省了时间
 *
 * @Date: 2018/8/22 15:00
 */
public class 使用动态规划解决斐波那契问题 extends MyTimer{

    public static Map<Integer,Long> map=new HashMap<>();

    public static Long digui(int n){
        if(map.containsKey(n)){
            return map.get(n);
        }

        if(n==1||n==2){
            map.put(n,1L);
            return 1L;
        }else {
            Long a=digui(n-1)+digui(n-2);
            map.put(n,a);
            return a;
        }
    }

    /**
     * 所有的运行都写在这里
     */
    @Override
    public void myTimer() {

        System.out.println(digui(160));//用时2 毫秒   8259707399215967867

    }

    public static void main(String[] args) {
        new 使用动态规划解决斐波那契问题().start();
    }
}
