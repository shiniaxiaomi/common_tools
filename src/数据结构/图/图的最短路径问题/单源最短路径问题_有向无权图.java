package 数据结构.图.图的最短路径问题;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Yingjie.Lu on 2018/8/29.
 */

/**
 * @Title: 使用广度优先搜索(BFS)
 * @Date: 2018/8/29 14:38
 */
public class 单源最短路径问题_有向无权图 {

    public static int nodeNum=7;
    
    public static int[] dist=new int[7];//保存起点到终点的最短路径
    public static int[] path=new int[7];//保存起点到终点的最短路径的走法

    //使用邻接表(使用链表的方式保存一行的节点连接的情况) 定义一个图
    //定义一系列的点,再通过点的连接形成图
    public static Node node1=new Node(1,1);
    public static Node node2=new Node(2,1);
    public static Node node3=new Node(3,1);
    public static Node node4=new Node(4,1);
    public static Node node5=new Node(5,1);
    public static Node node6=new Node(6,1);
    public static Node node7=new Node(7,1);
    
    //初始化数组
    static {
        for(int i=0;i<nodeNum;i++){
            dist[i]=-1;
            path[i]=-1;
        }
    }


    //一个节点,保存了编号,数据,是否已经被访问的信息 和 与该节点相连的所有点的地址
    private static class Node{
        int num;
        int data;
        boolean isVisited=false;
        LinkedList<Node> linkedList=new LinkedList();
        Node(int num,int data){
            this.num=num;
            this.data=data;
        }

        public void addConnection(Node[] nodes){
            for(Node n:nodes){
                linkedList.add(n);
            }
        }
    }


    /**
     * @Title: 图的遍历(广度优先搜索)
     * @Date: 2018/8/29 13:47
     */
    public static void bianli(Node node){

        Queue queue=new LinkedList();

        queue.offer(node);
        dist[node.num-1]=0;

        while(!queue.isEmpty()){
            Node firstNode = (Node) queue.poll();
            for(Node n:firstNode.linkedList){//遍历这个节点的邻接点
                if(dist[n.num-1]==-1){//如果为-1,说明这个点还没有经过
                    dist[n.num-1]=dist[firstNode.num-1]+1;//从上一步的基础上加一(dist里面记录的是到上一点的最短距离)
                    path[n.num-1]=firstNode.num;//记录的是上一步是谁
                    queue.offer(n);
                }
            }
        }
    }

    /**
     * @Title: 获取从起点到终点的距离和路径
     * @Date: 2018/8/29 15:24
     */
    public static void getPath(Node node){
        System.out.print("dist:");
        for(int a:dist){System.out.print(a+",");}
        System.out.println();
        System.out.print("path:");
        for(int a:path){System.out.print(a+",");}
        System.out.println();

        System.out.println();
        System.out.println("最短路径距离为:"+dist[node.num-1]);//dist数组里记录的就是起点到该终点的最短距离
        System.out.print("最短路径的走法:");
        Stack stack=new Stack();//定义一个堆栈,起到逆序的作用
        int num=node.num;
        stack.push(node.num);//首先把自身的位置入栈
        while(path[num-1]!=-1){//如果不是-1,说明还没有到地起点
            stack.push(path[num-1]);
            num=path[num-1];
        }
        while(!stack.empty()){//将堆栈中的数据全部pop出来,并打印,就是最后的路径
            System.out.print(stack.pop()+",");
        }
    }

    public static void main(String[] args) {

        //添加各点的连接关系,就直接形成了一个图的关系(node1添加node2的连接关系,说明node1执行node2)
        node1.addConnection(new Node[]{node2,node4});
        node2.addConnection(new Node[]{node4,node5});
        node3.addConnection(new Node[]{node1,node6});
        node4.addConnection(new Node[]{node3,node5,node6,node7});
        node5.addConnection(new Node[]{node7});
        node6.addConnection(new Node[]{});
        node7.addConnection(new Node[]{node6});

        bianli(node3);//起点为node3

        getPath(node7);//获取从起点到终点的距离和路径


    }
}
