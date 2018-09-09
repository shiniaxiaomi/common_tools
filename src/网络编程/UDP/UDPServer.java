package 网络编程.UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Created by 陆英杰
 * 2018/9/9 23:20
 */
public class UDPServer {
    public static void main(String[] args) throws Exception {
        /**
         * 定义一个字节数组,大小为1024
         */
        byte[] buf=new byte[1024];

        /**
         * new一个DatagramPacket(数据包),数据是存放在buf字节数组中,buf字节数组的大小决定了服务器端每次接收的数据包的最大值
         */
        DatagramPacket dp=new DatagramPacket(buf,buf.length);

        /**
         * new了一个DatagramSocket,服务器端的监听的端口号是10000
         */
        DatagramSocket ds=new DatagramSocket(10000);

        //循环接收
        while(true){
            /**
             * 阻塞式方法,通过服务器端的socket进行接收client端发送过来的数据包
             * 只要client端发送数据,那么就收过来之后,就把数据包扔到之前服务器端定义的数据包当中
             */
            ds.receive(dp);

            //将client端的地址和端口,和接收到的数据包中的字节数组中的数据打印出来
            System.out.println(dp.getSocketAddress()+":"+new String(buf,0,dp.getLength()));
        }
    }
}
