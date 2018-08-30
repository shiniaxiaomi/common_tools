package 数据结构.线性结构.队列;

/**
 * Created by Yingjie.Lu on 2018/8/30.
 */

/**
 * @Title: 链式存储_队列
 * @Date: 2018/8/30 14:12
 */
public class MyLinkedQueue {


    private Node front;//指向队头节点
    private Node rear;//指向队尾节点
    private int size=0;

    /**
     * @Title: 定义一个元素
     * @Date: 2018/8/30 15:44
     */
    private class Node{
        Object data;//数据
        Node next;//下一个元素的地址
        Node(Object o){
            this.data=o;
        }
    }

    /**
     * @Title: 入队
     * @Date: 2018/8/30 15:55
     */
    public void offer(Object o){
        Node node=new Node(o);

        if(size==0){
            front=node;
            rear=node;
        }else {
            rear.next=node;
            rear=node;
        }

        size++;

    }

    /**
     * @Title: 出队
     * @Date: 2018/8/30 15:55
     */
    public Object poll(){
        if(size==0){
            return null;
        }
        Node node=front.next;//保存下一个节点的地址
        Node needReturn=front;//保存要出队的元素
        front.next=null;//将队头的节点删除(即吧队头的next设为null)
        front=node;//front指向保存的下一个节点
        size--;
        return needReturn.data;
    }

    /**
     * @Title: 判断队列是否为空
     * @Date: 2018/8/30 15:56
     */
    public boolean isEmpty(){
        if(size==0){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {

        MyLinkedQueue myLinkedQueue=new MyLinkedQueue();

        //入队10个元素
        for(int i=0;i<10;i++){
            myLinkedQueue.offer(i);
        }

        //出队5个元素
        for(int i=0;i<5;i++){
            myLinkedQueue.poll();
//           System.out.println(myArrayQueue.poll());
        }

        //再入队5个元素
        for(int i=20;i<25;i++){
            myLinkedQueue.offer(i);
        }

        //再全部出队
        while(!myLinkedQueue.isEmpty()){
            System.out.println(myLinkedQueue.poll());
        }

    }
}
