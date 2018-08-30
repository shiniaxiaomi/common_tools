package 数据结构.树;


import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Yingjie.Lu on 2018/8/29.
 */
public class 二叉树深度遍历 {

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

    public static void 先序遍历(Node node){

        if(node==null){//已经到了子结点
            return;
        }
        System.out.println(node.data);//遍历根节点
        先序遍历(node.leftChild);//遍历左子树
        先序遍历(node.rightChild);//遍历右子树
    }

    public static void 中序遍历(Node node){

        if(node==null){//已经到了子结点
            return;
        }
        中序遍历(node.leftChild);//遍历左子树
        System.out.println(node.data);//遍历根节点
        中序遍历(node.rightChild);//遍历右子树
    }

    public static void 后序遍历(Node node){

        if(node==null){//已经到了子结点
            return;
        }
        后序遍历(node.leftChild);//遍历左子树
        后序遍历(node.rightChild);//遍历右子树
        System.out.println(node.data);//遍历根节点
    }

    public static void main(String[] args) {
        Node treeNode=creatTree(a);

//        先序遍历(treeNode);
//        中序遍历(treeNode);
        后序遍历(treeNode);

    }

}
