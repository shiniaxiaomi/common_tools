package 算法.回溯算法;

/**
 * 使用回溯算法求解排列组合问题
 * @author 陆英杰
 *
 */
public class 排列组合02 {

	
	public static StringBuffer str = new StringBuffer();

    public static int flag=0;

	public static void chuli(String[] s,int n) {
		
		if(n==s.length){//当到达最后一层
			System.out.println(str);
			return ;//返回上一层
		}
		
		for(int i=0;i<s.length;i++){
			str.append(s[i]);
			chuli(s,n+1);//n+1就是进入下一层
			
			str.delete(str.length()-1, str.length());//在return之后，将数据状态返回上一层
			
		}
		
		
		
	}//

	public static void main(String[] args) {

		String[] s={"1","2","3"};
		
		chuli(s,0);
		

	}

}
