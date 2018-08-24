package 算法.回溯算法;

import 算法._计时工具类.MyTimer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yingjie.Lu on 2018/8/23.
 */

/**
 * @Title: 有一个背包，背包容量是M=150kg。有7个物品，物品不可以分割成任意大小。（这句很重要）
            要求尽可能让装入背包中的物品总价值最大，但不能超过总容量。
            物品 A B C D E F G
            重量 35kg 30kg 6kg 50kg 40kg 10kg 25kg
            价值 10 40 30 50 35 40 30

 * @Date: 2018/8/23 11:29
 */
public class 背包问题 extends MyTimer {

    public static int num=0;
    public static int allWeight=150;//最大能装的重量
    public static int jiazhi=0;//总价值

    public static String[] a={"A","B","C","D","E","F","G","H"};//物品
    public static int[]  b={35,30,16,50,40,10,25,19,38};//重量
    public static int[] c={10,40,30,50,35,40,30,20,28};//价值

    public static List<String> list=new ArrayList<>();

    public static void digui(int[] d,int n){

        if(n==d.length){
            int buff=0;
            for(int i=0;i<d.length;i++){
                if(d[i]==1){
                    buff+=c[i];
                }
            }
            if(buff==jiazhi){//如果相等,则可能有两种放法
                String str="";
                for(int i=0;i<d.length;i++){
                    if(d[i]==1){
                        str+=a[i];
                    }
                }
                list.add(str);
            }else
                if(buff>jiazhi){//清空掉原来的所有放法
                jiazhi=buff;
                list.clear();
                String str="";
                for(int i=0;i<d.length;i++){
                    if(d[i]==1){
                        str+=a[i];
                    }
                }
                list.add(str);
            }

//            for( int a:d ){
//                System.out.print(a+",");
//            }
//            System.out.println();
            num++;
            return;
        }
        
        for(int i=0;i<2;i++){

            d[n]=i;

            if(check(d)){
                continue;
            }

            digui(d,n+1);
            d[n]=0;//恢复现场
        }
        
    }

    @Override
    public void myTimer() {
        int[] d=new int[a.length];
        digui(d,0);

//        System.out.println(num);
        System.out.println(list);
        System.out.println(jiazhi);
        String str=list.get(0);
        for(int i=0;i<d.length;i++){
            if(str.contains(a[i])){
                System.out.print(b[i]+",");
            }
        }
        System.out.println();

    }

    //检查是否超重
    public static boolean check(int[] d){

        int sum=0;

        for(int i=0;i<d.length;i++){
            if(d[i]==1){
                sum+=b[i];
            }
        }

        if(sum>allWeight){
            return true;
        }else{
            return false;
        }

    }

    public static void main(String[] args) {
        new 背包问题().start();
    }
}
