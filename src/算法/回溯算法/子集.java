package 算法.回溯算法;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title: 子集 : 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * @Date: 2018/8/20 9:57
 */ 
public class 子集 {

    public static List<List<Integer>> subsets(int[] nums) {
    	
    	List<List<Integer>> list = new ArrayList<>();
    	
    	List<Integer> single = new ArrayList<>();
    	
    	//标记数组
    	boolean[] a = new boolean[nums.length];
    	digui(list,single,nums,a,0);
    	return list;
    }
    public static void digui(List<List<Integer>> list,List<Integer> single,int[] nums,boolean[] a,int n) {
    	if (n == nums.length) {
    		//吧标记了取的元素放进single队列里
    		for (int i = 0; i < a.length; i++) {
				if (a[i]) {
					single.add(nums[i]);
				}
			}
    		//注意一定要new一个，不然只是复制一个引用
			list.add(new ArrayList<Integer>(single));
			//清空队列
			single.removeAll(single);
			return;
		}
    	else {
    		//取n的情况，准备看下一个
			a[n] = false;//通过这个来选择到底是去几个数作为其中的一个子集,如果全为false,则取零个,那么子集为空集,如果全为true,那么子集为{1,2,3}
			digui(list, single, nums, a, n+1);
			//不取n的情况，看下一个
			a[n] =true;
			digui(list, single, nums, a, n+1);
		}//
    }

    public static void main(String[] args) {
		System.out.println(subsets(new int[]{1,2,3}));
    }
}