package 数据结构.树;


import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Yingjie.Lu on 2018/8/29.
 */

/**
 * @Title: 二叉树的层序遍历(广度优先搜索)
 * @Date: 2018/8/29 11:23
 */
public class 二叉树层序遍历 {

    public static int[] a={1,2,3,4,5,6,7};

    /**
     * @Title: 定义一个节点类
     * @Date: 2018/8/29 10:32
     */
    private static class Node {
        Node leftChild;
        Node rightChild;
        int data;

        Node(int newData) {
            leftChild = null;
            rightChild = null;
            data = newData;
        }
    }

    public static Node creatTree(int[] a){
        Queue<Node> queue=new LinkedList<>();
        Node treeNode=new Node(a[0]);
        queue.offer(treeNode);
        int i=1;
        while(!queue.isEmpty() && i<a.length){
            Node node=queue.poll();
            Node leftNode=new Node(a[i]);
            node.leftChild=leftNode;
            i++;
            Node rightNode=new Node(a[i]);
            node.rightChild=rightNode;
            i++;
            queue.offer(leftNode);
            queue.offer(rightNode);
        }
        return treeNode;
    }



    public static void 层序遍历(Node node){

       Queue<Node> queue= new LinkedList();
       queue.offer(node);
       while(!queue.isEmpty()){
           Node buff=queue.poll();
           if(buff!=null){
               System.out.println(buff.data);
               queue.offer(buff.leftChild);
               queue.offer(buff.rightChild);
           }
       }
    }

    public static void main(String[] args) {
        Node treeNode=creatTree(a);

        层序遍历(treeNode);

    }

}
