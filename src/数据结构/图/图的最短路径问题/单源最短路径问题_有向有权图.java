package 数据结构.图.图的最短路径问题;

import java.util.*;

/**
 * Created by Yingjie.Lu on 2018/8/29.
 */

/**
 * @Title: 使用Dijkstra算法-----如果是多源最短路径问题,即吧单源调用多遍即可,就是起点不同而已
 * @Date: 2018/8/29 15:29
 */
public class 单源最短路径问题_有向有权图 {

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

    public static List<Node> list=new LinkedList();

    //初始化数组
    static {
        for(int i=0;i<nodeNum;i++){
            dist[i]=Integer.MAX_VALUE;//赋值为无穷大
            path[i]=-1;
        }

        list.add(node1);
        list.add(node2);
        list.add(node3);
        list.add(node4);
        list.add(node5);
        list.add(node6);
        list.add(node7);

    }

    //射线(一个点加一条边)
    private static class Ray{
        Node node;
        int value;
        Ray(Node node,int value){
            this.node=node;
            this.value=value;
        }
    }

    //一个节点,保存了编号,数据,是否已经被访问的信息 和 与该节点相连的所有点的地址
    private static class Node{
        int num;
        int data;
        boolean isVisited=false;
        LinkedList<Ray> linkedList=new LinkedList();
        Node(int num,int data){
            this.num=num;
            this.data=data;
        }

        public void addConnection(Ray[] rays){
            for(Ray r:rays){
                linkedList.add(r);
            }
        }
    }

    /**
     * @Title: 查找在dist数组中的最小值并且对应的node是没有被访问过的
     *          其实是在下一个点还没有访问的时候,就已经在dist数组里面记录了下个点的可能最小值,
     *          所以每次去dist数组中寻找没被访问过的最小值即可
     * @Date: 2018/8/29 19:08
     */
    public static Node findMinNode(){

        int value=Integer.MAX_VALUE;
        Node node=null;
        for(Node n:list){
            if(n.isVisited==false && dist[n.num-1]<value){
                value=dist[n.num-1];
                node=n;
            }
        }
        return node;
    }


    /**
     * @Title: 图的遍历(广度优先搜索)
     * @Date: 2018/8/29 13:47
     */
    public static void bianli(Node node){
        node.isVisited=true;//起点
        dist[node.num-1]=0;
        for(Ray r:node.linkedList){//和起点相邻的点
            dist[r.node.num-1]=r.value;
            path[r.node.num-1]=node.num;
        }

        while(true){
            node=findMinNode();//查找在dist数组中的最小值并且对应的node是没有被访问过的
            if(node==null){//如果不存在node,则退出循环
                break;
            }
            node.isVisited=true;//标记已经访问过
            for(Ray r:node.linkedList){
                if(r.node.isVisited==false){
                    if(dist[node.num-1]+r.value<dist[r.node.num-1]){
                        dist[r.node.num-1]=dist[node.num-1]+r.value;
                        path[r.node.num-1]=node.num;
                    }
                }
            }

        }
    }

    /**
     * @Title: 获取从起点到终点的距离和路径(使用堆栈让path数组逆序遍历)
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

        //添加各点的连接关系,就直接形成了一个图的关系(node1添加node2的Ray,Ray是一条射线,即node1指向node2的射线,这个射线带有权值)
        node1.addConnection(new Ray[]{new Ray(node2,2),new Ray(node4,1)});
        node2.addConnection(new Ray[]{new Ray(node4,3),new Ray(node5,10)});
        node3.addConnection(new Ray[]{new Ray(node1,4),new Ray(node6,5)});
        node4.addConnection(new Ray[]{new Ray(node3,2),new Ray(node5,2),new Ray(node6,8),new Ray(node7,4)});
        node5.addConnection(new Ray[]{new Ray(node7,6)});
        node6.addConnection(new Ray[]{});
        node7.addConnection(new Ray[]{new Ray(node6,1)});

        bianli(node4);//起点为node3

        getPath(node4);//获取从起点到终点的距离和路径


    }
}
