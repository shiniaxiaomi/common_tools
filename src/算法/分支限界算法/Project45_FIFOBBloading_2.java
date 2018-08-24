package 算法.分支限界算法;
import java.util.*;

/*
 * 装载问题-采用分支限界法完成-FIFO方式
 * Time：2013-1-6
 * 下标从1开始,
 * 采用的FIFO的方式，采用remain剪枝的操作,并且采用了string保存了最佳的路径
 */
public class Project45_FIFOBBloading_2 {
    public static int weight[]={0,10,40,40};  //用来表示集装箱中对应的重量
	public static int n=weight.length-1;    //表示数组的个数
	public static int bestw;    //表示最接近的容量
	public static int c=45; //表示最大的容量
	public static Queue<Node45> que=new LinkedList<Node45>();//初始化FIFO队列
	public static int remain=0;//用来剪枝的操作的时候使用 (初始化剩余质量，用在剪枝函数)
	public static String bestx;//用来保存最佳的路劲
	public static void main(String[] args) {
		for(int i=1;i<=n;i++)
		{
			remain=remain+weight[i];
		}
		fifobbLoading(1);//num代表的是第几层

		//输出
		System.out.println("最接近最大重量 "+c+" 的重量为:"+bestw);
		System.out.println("最佳的路径为"+bestx);
	}


	public static void fifobbLoading(int num)
	{
		remain=remain-weight[1];//在第一层进行判断的操作
		if(weight[num]<=c) //用于是否需要剪去右枝节
		{
			Node45 temp=new Node45(weight[num],"1");//初始化右节点
	    	que.offer(temp);
	    	bestw=bestw+weight[num]; //修改最优质量
		}
		if(remain>=bestw)//用于是否需要剪去左枝节
		{
			Node45 temp=new Node45(0,"0");//初始化左节点
		    que.offer(temp);
		}
		int size=que.size();//初始化在第一层运行结束后队列中的个数
		while(num!=n)     //判断是否达到最后一层
		{
//			System.out.println("============================");
//			System.out.println("num=="+num);
//			System.out.println("remain=="+remain);
//			System.out.println("bestw=="+bestw);
//			System.out.println("size=="+size);
			num++;   //层数加1
			remain=remain-weight[num];  //剩余质量减去当前层的质量
			while(size!=0)   //判断上一层中的队列是否处理完毕
			{
				Node45 temp=que.poll(); //取出节点
//				System.out.println("temp=="+temp);
				if(temp.weight+weight[num]<=c) //用于是否需要剪去右枝节
			    {
					if(temp.weight+weight[num]>bestw) //判断是否需要修改最优质量
					{
					   bestw=temp.weight+weight[num];
					}
					Node45 temp1=new Node45(temp.weight+weight[num],temp.getBestx()+"1");
					que.offer(temp1);
				}
				if(temp.getWeight()+remain>=bestw)//用于是否需要剪去左枝节
				{
					Node45 temp2=new Node45(temp.weight,temp.getBestx()+"0");
					que.offer(temp2);
				}
				size--;
//				System.out.println("bestw=="+bestw);
			}
			size=que.size();
//			System.out.println("============================");
		}
//		System.out.println(" ");	
		while(que.size()!=0) //在最后一层处理完毕后，取出最优的质量以及路径
		{
			Node45 temp=que.poll();
			System.out.println(temp);
			if(temp.weight>=bestw)
			{
				bestw=temp.weight;
			    bestx=temp.bestx;
			}
		}
	}

}
class Node45 //用于保存节点的权值以及路径
{
	int weight;//用来表示在这个节点的权值
	String bestx;//用来存储最佳的路径
	public String toString()
	{
		return "weight=="+weight+",bestx=="+bestx;
	}
	public Node45(int weight,String bestx)
	{
		this.weight=weight;
		this.bestx=bestx;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getBestx() {
		return bestx;
	}
	public void setBestx(String bestx) {
		this.bestx = bestx;
	}
}

