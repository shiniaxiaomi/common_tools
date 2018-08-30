package 数据结构.线性结构.线性表;

/**
 * Created by Yingjie.Lu on 2018/8/30.
 */


/**
 * @Title: 通过链表实现的线性表
 * @Date: 2018/8/30 9:21
 */
public class MyLinkedList {

    private Node first=new Node(null);
    private Node last=new Node(null);
    private int size=0;

    public int size(){
        return size;
    }

    /**
     * @Title: 定义节点
     * @Date: 2018/8/30 10:47
     */
    private class Node{
        Object data;//数据
        Node next;//下一个节点

        Node(Object o){
            this.data=o;
        }
    }

    /**
     * @Title: 添加一个元素
     * @Date: 2018/8/30 10:46
     */
    public void add(Object o){
        Node node=new Node(o);
        last.next=node;//将刚添加的节点与上个节点关联
        last=node;//把刚添加的节点设置为最后一个节点
        if(size==0){
            first=last;
        }
        size++;
    }

    /**
     * @Title: 通过index获取一个元素
     * @Date: 2018/8/30 10:47
     */
    public Object get(int index){
        if(index>=size()){//如果index大于所有的总个数,那么直接返回null
            return null;
        }
        Node node=first;
        for(int i=0;i<index;i++){
            node=node.next;
        }
        return node.data;
    }

    /**
     * @Title: 删除一个元素
     * @Date: 2018/8/30 10:48
     */
    public boolean remove(int index){
        if(index>=size()){//如果index大于所有的总个数,那么直接返回null
            return false;
        }
        Node node=first;
        for(int i=0;i<index;i++){
            if(i==index-2){
                Node needDelete=node.next;//先将要删除的节点的地址保存起来
                node.next=node.next.next;//直接将要删除的上一个节点的next指向要删除的节点的下一个节点
                needDelete.next=null;//将要删除的节点的next设置为null
                size--;
                break;
            }
            node=node.next;
        }

        return true;
    }

    /**
     * @Title: 通过index更新一个元素
     * @Date: 2018/8/30 11:13
     */
    public boolean update(int index,Object o){
        if(index>=size()){//如果index大于所有的总个数,那么直接返回null
            return false;
        }
        Node node=first;
        Node needUpdate=new Node(o);
        for(int i=0;i<index;i++){
            if(i==index-2){
                Node needDelete=node.next;//先将要删除的节点的地址保存起来
                needUpdate.next=node.next.next;//将要更新节点的next指向要删除的节点的下一个节点
                node.next=needUpdate;//将要删除的上一个节点的next指向要更新节点
                needDelete.next=null;//将要删除的节点的next设置为null
                break;
            }
            node=node.next;
        }

        return true;
    }

    /**
     * @Title: 获取第一个元素
     * @Date: 2018/8/30 10:47
     */
    public Object getFirst(){
        return first.data;
    }

    /**
     * @Title: 获取最后一个元素
     * @Date: 2018/8/30 10:47
     */
    public Object getLast(){
        return last.data;
    }

    public static void main(String[] args){

        MyLinkedList linkedList=new MyLinkedList();

        for(int i=0;i<10;i++){
            linkedList.add(i);
        }

        linkedList.remove(5);

        linkedList.update(3,4);

        for(int i=0;i<linkedList.size();i++){
            System.out.println(linkedList.get(i));
        }




    }



}
