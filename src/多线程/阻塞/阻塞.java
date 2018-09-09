package 多线程.阻塞;

/**
 * Created by 陆英杰
 * 2018/9/7 9:58
 */


/**
 * DESC: 当线程被sleep阻塞的时候,那么线程会让出cpu资源,并且当sleep时间到了之后会变成可运行状态,
 *       当这个线程再次得到cpu资源的时候,那么这个线程会从上一次被阻塞的地方开始继续执行代码
 * CREATEBY: luyingjie
 * Date: 2018/9/7 14:23
 */
public class 阻塞{
    public static void main(String[] args) {

        Runnable runnable=new Demo1();
        Thread t1=new Thread(runnable,"线程1");//启动线程
        Thread t2=new Thread(runnable,"线程2");//启动线程
        t1.start();
        t2.start();

    }
}

class Demo1 implements Runnable{


    @Override
    public void run() {
        for(int i=0;i<10;i++){
            try {
                Thread.sleep(100);//使线程阻塞,那么这个被阻塞的线程就会让出CPU资源,然后时间结束之后就会变成可运行状态,直到这个线程再次获取CPU资源,然后再从这个地方继续往下执行多少个时间片
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
        }
    }



}

