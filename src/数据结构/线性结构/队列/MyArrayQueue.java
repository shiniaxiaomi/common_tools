package 数据结构.线性结构.队列;

/**
 * Created by Yingjie.Lu on 2018/8/30.
 */

/**
 * @Title: 顺序存储_循环队列
 * @Date: 2018/8/30 14:12
 */
public class MyArrayQueue {

    private static int MaxSize=10;

    private Object[] arr=new Object[MaxSize];

    private int rear=0;//后面的

    private int front=0;//前面的

    private int size=0;//记录队列中的个数

    /**
     * @Title: 入队
     * @Date: 2018/8/30 14:15
     */
    public boolean offer(Object o){
        if(rear==front && size!=0){//队列已满
            return false;
        }
        arr[rear]=o;
        rear=(rear+1)%MaxSize;//如果达到最大个数之后,将会回到数组的最前面开始
        size++;
        return true;
    }

    /**
     * @Title: 出队
     * @Date: 2018/8/30 14:15
     */
    public Object poll(){
        if(front==rear && size==0){//队列已空
            return null;
        }
        Object obj=arr[front];
        front=(front+1)%MaxSize;//如果达到最大个数之后,将会回到数组的最前面开始
        size--;
        return obj;
    }

    /**
     * @Title: 判断队列是否为空
     * @Date: 2018/8/30 15:41
     */
    public boolean isEmpty(){
        if(size==0){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {

        MyArrayQueue myArrayQueue=new MyArrayQueue();

        //入队10个元素
       for(int i=0;i<10;i++){
           myArrayQueue.offer(i);
       }

        //出队5个元素
       for(int i=0;i<5;i++){
           myArrayQueue.poll();
//           System.out.println(myArrayQueue.poll());
       }

       //再入队5个元素
        for(int i=20;i<25;i++){
            myArrayQueue.offer(i);
        }

        //再全部出队
        while(!myArrayQueue.isEmpty()){
            System.out.println(myArrayQueue.poll());
        }

    }

}
