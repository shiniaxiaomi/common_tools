package 数据结构.图.图的遍历;

/**
 * Created by Yingjie.Lu on 2018/8/29.
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Title: BFS(广度优先搜索)
 * @Date: 2018/8/29 12:40
 */
public class 广度优先搜索 {

    public static int nodeNum=6;

    //使用邻接表(使用链表的方式保存一行的节点连接的情况) 定义一个图
    public static Node node0=new Node(0,1);
    public static Node node1=new Node(1,1);
    public static Node node2=new Node(2,1);
    public static Node node3=new Node(3,1);
    public static Node node4=new Node(4,1);
    public static Node node5=new Node(5,1);

    //使用邻接矩阵(二维数组,其实也可以使用一维数组) 定义一个图(有6个顶点,每个顶点都联通,顶点3和顶点4不连通)
//    public static int[][] a={
//            {0 ,1 ,0 ,0 , 1 ,1},
//            {1 ,0 ,1 ,0 , 0 ,0},
//            {0 ,1 ,0 ,1 , 0 ,1},
//            {0 ,0 ,1 ,0 , 0 ,1},
//            {1 ,0 ,0 ,0 , 0 ,1},
//            {1 ,0 ,1 ,1 , 1 ,0},
//    };


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
        node.isVisited=true;
        System.out.println(node.num);

        while(!queue.isEmpty()){
            Node firstNode = (Node) queue.poll();
            for(Node n:firstNode.linkedList){
                if(!n.isVisited){
                    queue.offer(n);
                    n.isVisited=true;
                    System.out.println(n.num);
                }
            }
        }

    }

    public static void main(String[] args) {

        //添加各点的连接关系,就直接形成了一个图的关系(node1添加node2的连接关系,说明node1执行node2)
        node0.addConnection(new Node[]{node1,node4,node5});
        node1.addConnection(new Node[]{node0,node2});
        node2.addConnection(new Node[]{node1,node3,node5});
        node3.addConnection(new Node[]{node2,node5});
        node4.addConnection(new Node[]{node0,node5});
        node5.addConnection(new Node[]{node0,node2,node3,node5});


        bianli(node0);
    }

}
