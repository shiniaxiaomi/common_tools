package 算法.分治算法;

import 算法._计时工具类.MyTimer;

/**
 * Created by Yingjie.Lu on 2018/8/23.
 */

/**
 * @Title: 使用分治算法来求 解逆序数对,时间复杂度为nlogn,即归并排序的时间复杂度
 * @Date: 2018/8/24 11:20
 */
public class 求逆序对 extends MyTimer {

    public static long sum=0;//记录总对数

    //分
    private static void sort(int[] arr,int left,int right,int[] temp){
        if(left < right){
            int mid = (left+right)/2;
            sort(arr,left,mid,temp);//左边归并排序，使得左子序列有序
            sort(arr,mid+1,right,temp);//右边归并排序，使得右子序列有序
            merge(arr,left,mid,right,temp);//将两个有序子数组合并操作
        }
    }

    //治---将被分成小份的数组排好序
    private static void merge(int[] arr,int left,int mid,int right,int[] temp){//以mid为分割两个数组分成左右两个,left~mid为左边数组,mid+1~right为右边数组
        int left_index=left;//记录左边数组的游标
        int right_index=mid+1;//记录右边数组的游标
        int temp_index=left;//标记临时数组的游标

        //每次从左右两个已经排好序的数组中选出每个数组最左边的最小值放入临时数组中
        while(left_index<=mid && right_index<=right){
            if(arr[left_index]>arr[right_index]){//这里的大于号还是小于号控制了数组是降序排列还是升序排列
                temp[temp_index++]=arr[left_index++];
                /**
                 * 累加逆序数对 : 因为左右两边数组都是已经按降序排列好的,所以只要左边有一个数大于右边,那么就会有右边数组个数的逆序数对
                 */
                sum += right - right_index+1;
            }else{
                temp[temp_index++]=arr[right_index++];
            }
        }




        //如果左边数组有剩余,则全部复制到临时数组中
        while(left_index<=mid){
            temp[temp_index++]=arr[left_index++];
        }

        //如果右边数组有剩余,则全部复制到临时数组中
        while(right_index<=right){
            temp[temp_index++]=arr[right_index++];
        }

        //复制对应的数据到原来的数组中
        for(int i=left;i<=right;i++){
            arr[i]=temp[i];
        }

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
        int[] arr = getRandomArray(1000000);
//        int[] arr=new int[]{5,3,1,7,4,9,8,11};
        int[] temp=new int[arr.length];

        sort(arr,0,arr.length-1,temp);
        System.out.println(sum);
//        for( int a:arr ){
//            System.out.print(a+",");
//        }
    }

    public static void main(String[] args) {
        new 求逆序对().start();
    }
}
