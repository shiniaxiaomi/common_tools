package 多线程.同步;

/**
 * Created by 陆英杰
 * 2018/9/7 11:05
 */
public class 同步方法 {

    public static void main(String[] args) {

        Runnable runnable=new Thread2();//new 一个可以被线程运行的类型,因为这个类实现了Runnable接口
        Thread thread1=new Thread(runnable,"线程1");//让thread1线程运行runnable类中的run方法
        Thread thread2=new Thread(runnable,"线程2");//让thread2线程运行runnable类中的run方法
        thread1.start();
        thread2.start();


    }

}



/**
 * DESC: 如果不加同步的话,那么a的值可能会被重复的打印两次
 */
class Thread2 implements Runnable{

    private static int a=20;//共享数据
    @Override
    public void run() {
        while(a>0){
            show();
        }
    }


    public synchronized void show(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" : "+a--);
    }
}