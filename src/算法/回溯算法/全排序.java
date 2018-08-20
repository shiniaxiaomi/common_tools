package 算法.回溯算法;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title: 实现全排列 : 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * @Date: 2018/8/20 9:35
 */ //
public class 全排序 {


    public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
        List<Integer> aIntegers = new ArrayList<>();
        chuli(aIntegers, 0 , nums,list);
        return list;
    }
 
	private static void chuli(List<Integer> aIntegers, int n , int[] nums, List<List<Integer>> list) {
		if (n == nums.length) {
			list.add(new ArrayList<Integer>(aIntegers));
			return;//如果搜索到最后一层,且条件符合,那么将结果保存,然后上一层,然后通过最后的remove方法恢复状态
		}
		
		for (int i = 0; i < nums.length; i++) {
			if (aIntegers.contains(nums[i])) {
				continue;//使用continue可以直接结束掉当前分支(即防止进入下一层)
			}
			aIntegers.add(nums[i]);
			chuli(aIntegers, n+1, nums, list);//进入下一层
			aIntegers.remove(aIntegers.size()-1);//删除掉最后一次添加的,恢复现场
		}
	}

	public static void main(String[] args) {
		System.out.println(permute(new int[]{1,2,3}));
	}
}