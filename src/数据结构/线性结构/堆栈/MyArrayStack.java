package 数据结构.线性结构.堆栈;

/**
 * Created by Yingjie.Lu on 2018/8/30.
 */

/**
 * @Title: 顺序存储_堆栈
 * @Date: 2018/8/30 11:22
 */
public class MyArrayStack {

    private static int MaxSize=100;

    private Object[] arr=new Object[MaxSize];

    private int top=-1;

    public int size(){
        return top+1;
    }

    /**
     * @Title: 入栈
     * @Date: 2018/8/30 13:25
     */
    public void push(Object o){
        if(top>=MaxSize){
            return;
        }
        arr[top+1]=o;
        top++;

    }

    /**
     * @Title: 出栈
     * @Date: 2018/8/30 13:25
     */
    public Object pop(){
        if(top==-1){
            return null;
        }
        Object obj=arr[top];
        top--;
        return obj;
    }

    /**
     * @Title: 判断栈是否为空
     * @Date: 2018/8/30 13:25
     */
    public boolean isEmpty(){
        if(top==-1){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {

        MyArrayStack myArrayStack=new MyArrayStack();

        //压入10个元素
        for(int i=0;i<10;i++){
            myArrayStack.push(i);
        }
        //弹出5个元素
        for(int i=0;i<5;i++){
            myArrayStack.pop();
        }
        //再压入5个元素
        for(int i=10;i<15;i++){
            myArrayStack.push(i);
        }

        //最后弹出所有元素
        while(!myArrayStack.isEmpty()){
            System.out.println(myArrayStack.pop());
        }

    }

}
