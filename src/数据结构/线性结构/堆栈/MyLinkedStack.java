package 数据结构.线性结构.堆栈;

/**
 * Created by Yingjie.Lu on 2018/8/30.
 */

/**
 * @Title: 链式存储_堆栈
 * @Date: 2018/8/30 11:22
 */
public class MyLinkedStack{

    private Node top=new Node(null);

    private int size=0;

    /**
     * @Title: 定义一个节点
     * @Date: 2018/8/30 13:29
     */
    private class Node{
        private Object data;
        private Node last;//上一个节点
        private Node next;//下一个节点
        Node(Object o){
            this.data=o;
        }
    }


    public void push(Object o){
        Node node=new Node(o);
        if(size==0){
            top=node;
        }else {
            node.last=top;//新来的元素的last要指向上一个元素
            top=node;//然后将top指向新来的元素
        }
        size++;
    }


    public Object pop(){
        if(size==0){
            return null;
        }
        Node node=top;
        top=top.last;//将top的last指向上一个节点
        size--;
        return node.data;
    }

    public boolean isEmpty(){
        if(size==0){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {

        MyLinkedStack myLinkedStack=new MyLinkedStack();

        //压入10个元素
        for(int i=0;i<10;i++){
            myLinkedStack.push(i);
        }
        //弹出5个元素
        for(int i=0;i<5;i++){
            myLinkedStack.pop();
        }
        //再压入5个元素
        for(int i=10;i<15;i++){
            myLinkedStack.push(i);
        }

        //最后弹出所有元素
        while(!myLinkedStack.isEmpty()){
            System.out.println(myLinkedStack.pop());
        }

    }
}
