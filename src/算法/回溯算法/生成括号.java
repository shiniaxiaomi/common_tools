package 算法.回溯算法;

import java.util.ArrayList;
import java.util.List;

/**
 * 生成括号 : 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * @author 陆英杰
 * //
 */
public class 生成括号 {


	public static List<String> generateParenthesis(int n) {
		List<String> list = new  ArrayList<>();
		chuli("", list, n, n);
		return list;
	}

	public static void chuli(String s, List<String> list,int left, int right) {
		if (left>right) {
			return;
		}

		if (left>0) {
			chuli(s+"(", list, left-1, right);
		}
		if (right>0) {
			chuli(s+")", list, left, right-1);
		}
		if (left==0&&right==0) {
			list.add(s);
			return;
		}
	}


	public static void main(String[] args) {

		System.out.println(generateParenthesis(3));

	}

}
