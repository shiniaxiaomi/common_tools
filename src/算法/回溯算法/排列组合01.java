package 算法.回溯算法;

/**
 * 使用回溯算法求解排列组合问题
 * @author 陆英杰
 *
 */
public class 排列组合01 {


	public static StringBuffer str = new StringBuffer();

	public static void zuhe(int[][] arr, int n) {

		if (n==arr.length) {//当遍历的层数达到之后，就返回
            System.out.println(str);
			return;
		}//

		for (int i = 0; i < arr[n].length; i++) {

			str.append(String.valueOf(arr[n][i]));

			/*
			 * 在这里遍历第二层的东西，因为n+1作为参数再次传入了函数，然后遍历的是arr[n]里面的数据，所以当n=0时，
			 * 遍历的是第一层，当n=1是，遍历的是第二层，然后第一层相当于是父节点，第二层是子节点，然后形成了树状的结构，
			 * 然后当不满足条件返回时，就相当于是回溯到上一个状态，并继续下一个遍历
			 */
			zuhe(arr, n+1);
			

			str.deleteCharAt(str.length() - 1);//清空上一次完成的，相当于回溯到上一层，然后在接下去穷举

		}

	}

	public static void main(String[] args) {

		int[][] arr = new int[][] {

			{1,2,3},{4,5,6}

		};

		zuhe(arr, 0);

	}

}
