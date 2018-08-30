package 数据结构.线性结构.线性表;

/**
 * Created by Yingjie.Lu on 2018/8/30.
 */

/**
 * @Title: 通过顺序存储实现的线性表
 * @Date: 2018/8/30 9:21
 */
public class MyArrayList {


    private Object[] arr = new Object[10];//默认初始化数组大小为10个

    private int size=0;//记录数组里面的个数

    public int size(){
        return size;
    }

    /**
     * @Title: 添加一个元素
     * @Date: 2018/8/30 9:51
     */
    public void add(Object o){

        if(size==arr.length){
            Object[] buff=new Object[size*2];
            System.arraycopy(arr,0,buff,0,size);
            arr=buff;
        }
        arr[size]=o;

        size++;

    }

    /**
     * @Title: 判断数组是否为空
     * @Date: 2018/8/30 9:51
     */
    public boolean isEmpty(){
        if(size==0){
            return true;
        }else{
            return false;
        }
    }

    /**
     * @Title: 删除一个元素
     * @Date: 2018/8/30 9:51
     */
    public void remove(int index){
        System.arraycopy(arr,index,arr,index-1,size-index);
        size--;
    }

    /**
     * @Title: 通过下标获取一个元素
     * @Date: 2018/8/30 9:52
     */
    public Object get(int index){
        return arr[index];
    }

    /**
     * @Title: 通过下标修改一个元素
     * @Date: 2018/8/30 9:52
     */
    public void update(int index,Object o){
        arr[index]=o;
    }

    public static void main(String[] args) {
        MyArrayList list=new MyArrayList();
        for(int i=0;i<12;i++){
            list.add(i);
        }

        list.remove(6);

        list.update(2,4);
        
        for(int i=0;i<list.size;i++){
            System.out.println(list.get(i));
        }
    }
}
