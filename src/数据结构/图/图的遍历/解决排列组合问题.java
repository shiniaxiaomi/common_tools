package 数据结构.图.图的遍历;

/**
 * Created by Yingjie.Lu on 2018/8/29.
 */

import java.util.LinkedList;

/**
 * @Title: BFS(深度优先搜索)
 * @Date: 2018/8/29 12:40
 */

/*
         __ __ __ __
        |__|__|__|__|__
           |__|__|__|__|

        这样一个图形(8个正方形),从左上角到右下角最短的路径有几种走法
 */

public class 解决排列组合问题 {

    public static int nodeNum=13;

    //使用邻接表(使用链表的方式保存一行的节点连接的情况) 定义一个图
    public static Node node0=new Node(0,1);
    public static Node node1=new Node(1,1);
    public static Node node2=new Node(2,1);
    public static Node node3=new Node(3,1);
    public static Node node4=new Node(4,1);
    public static Node node5=new Node(5,1);
    public static Node node6=new Node(6,1);
    public static Node node7=new Node(7,1);
    public static Node node8=new Node(8,1);
    public static Node node9=new Node(9,1);
    public static Node node10=new Node(10,1);
    public static Node node11=new Node(11,1);
    public static Node node12=new Node(12,1);

    public static int sum=0;


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
     * @Title: 图的遍历(深度优先搜索)
     * @Date: 2018/8/29 13:47
     */
    public static void bianli(Node node,int num){

        if(num==6){
            if(node.num==12){
                sum++;
            }
            return;
        }
        for(Node n:node.linkedList){
            if(node.num<n.num){
                bianli(n,num+1);
            }
        }
    }

    public static void main(String[] args) {

        //添加各点的连接关系,就直接形成了一个图的关系(node1添加node2的连接关系,说明node1执行node2)
        node0.addConnection(new Node[]{node1,node4});
        node1.addConnection(new Node[]{node0,node2,node5});
        node2.addConnection(new Node[]{node1,node3,node6});
        node3.addConnection(new Node[]{node2,node7});
        node4.addConnection(new Node[]{node0,node5});
        node5.addConnection(new Node[]{node1,node4,node6,node9});
        node6.addConnection(new Node[]{node2,node5,node7,node10});
        node7.addConnection(new Node[]{node3,node6,node8,node11});
        node8.addConnection(new Node[]{node7,node12});
        node9.addConnection(new Node[]{node5,node10});
        node10.addConnection(new Node[]{node6,node9,node11});
        node11.addConnection(new Node[]{node7,node10,node12});
        node12.addConnection(new Node[]{node8,node11});

        bianli(node0,0);

        System.out.println(sum);
    }

}
