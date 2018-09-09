package 多线程.创建;

/**
 * Created by 陆英杰
 * 2018/9/7 9:58
 */

/**
 * DESC: 继承Thread类
 * CREATEBY: luyingjie
 * Date: 2018/9/7 10:22
 */
public class 继承Thread extends Thread{


    @Override
    public void run() {
        for(int i=0;i<10;i++){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("我是子线程-------------");
        }
    }


    public static void main(String[] args) {

        new 继承Thread().start();//直接启动线程

        for(int i=0;i<10;i++){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("我是主线程");
        }
    }
}
