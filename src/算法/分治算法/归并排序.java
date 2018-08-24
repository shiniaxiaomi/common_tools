package 算法.分治算法;

import 算法._计时工具类.MyTimer;

import java.util.Arrays;

/**
 * Created by chengxiao on 2016/12/8.
 */


//算法图解: https://www.cnblogs.com/chengxiao/p/6194356.html
public class 归并排序 extends MyTimer{

	@Override
	public void myTimer() {
		int []arr = getRandomArray(1000000);
//		int []arr = {9,8,7,6,5,4,3,2,1};
		sort(arr);
//		System.out.println(Arrays.toString(arr));
	}

	public static void main(String []args){
		new 归并排序().start();
	}

	//获取一个随机数数组
	public static int[] getRandomArray(int n) {
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

	public static void sort(int[] arr){
		int []temp = new int[arr.length];//在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
		sort(arr,0,arr.length-1,temp);
	}

	//分
	private static void sort(int[] arr,int left,int right,int[] temp){
		if(left<right){
			int mid = (left+right)/2;
			sort(arr,left,mid,temp);//左边归并排序，使得左子序列有序
			sort(arr,mid+1,right,temp);//右边归并排序，使得右子序列有序
			merge(arr,left,mid,right,temp);//将两个有序子数组合并操作
		}
	}

	//治---将被分成小份的数组排好序
	private static void merge(int[] arr,int left,int mid,int right,int[] temp){//以mid为分割两个数组分成左右两个,left~mid为左边数组,mid+1~right为右边数组
		int i = left;//左序列指针
		int j = mid+1;//右序列指针
		int t = 0;//临时数组指针
		while (i<=mid && j<=right){//比较左右数组最左端的值,把最小值按顺序装在临时数组中
			if(arr[i]<=arr[j]){
				temp[t++] = arr[i++];
			}else {
				temp[t++] = arr[j++];
			}
		}
		while(i<=mid){//如果右边先装完,那么就将左边剩余元素填充进temp中
			temp[t++] = arr[i++];
		}
		while(j<=right){//如果左边先装完,那么就将右序列剩余元素填充进temp中
			temp[t++] = arr[j++];
		}
		t = 0;//清零
		//将temp中的元素全部拷贝到原数组中
		while(left <= right){
			arr[left++] = temp[t++];
		}
	}


}