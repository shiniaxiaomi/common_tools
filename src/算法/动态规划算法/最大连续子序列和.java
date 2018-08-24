package 算法.动态规划算法;

import 算法._计时工具类.MyTimer;

/**
 * Created by Yingjie.Lu on 2018/8/23.
 */

/**
 * @Title: 使用动态规划算法求解
 *          重复大量的子问题求解最好的办法就是使用动态规划算法,将需要重复计算的数据缓存起来,大大的提高了效率
 * @Date: 2018/8/23 19:34
 */
public class 最大连续子序列和 extends MyTimer{

    public static int maxSubSum(int[] a) {
        int maxSum = a[0];
        int tempSum = 0;
        int buff = 0;
        int begin=0;
        int end=0;

        for (int i = 0; i < a.length; i++) {
            //为什么在这里判断tempSum大于0即可,因为如果tempSum小于0,那么会让tempSum+后面的一个值更小,所以如果tempSum<0,则直接抛弃,将下一个值作为目前的和的最大值
            if (tempSum> 0)
                tempSum += a[i];
            else {
                tempSum = a[i];//如果tempSum<0,则直接抛弃,并重新赋值
                buff = i;  //_标记
            }

            if (tempSum > maxSum) {
                //记录最大值
                maxSum = tempSum;
                //可以在这里获取最佳连续子序列和的起点位置begin和重点位置i
                begin=buff;
                end=i;

            }

        }
        System.out.println("从"+begin+"开始,到"+end+"结束");
        return maxSum;
    }

    //获取一个随机数数组
    public int[] getRandomArray(int n) {
        int[] result = new int[n];
        for(int i = 0;i < n;i++) {
            if((int)(Math.random()*10)>5){
                result[i] = (int)( Math.random() * 50);  //生成0~50之间的随机数
            }else{
                result[i] = -(int)( Math.random() * 50);  //生成0~50之间的随机数
            }

        }
        return result;
    }

    @Override
    public void myTimer() {
        int[] a = getRandomArray(50000);
//        int[] a=new int[]{ 1, -3, 7, -8, 4, -12, 10, -6 };

        System.out.println("最大连续子序列和为 : "+maxSubSum(a));
    }

    public static void main(String[] args) {
        new 最大连续子序列和().start();
    }

}
