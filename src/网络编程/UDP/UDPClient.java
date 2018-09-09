package 网络编程.UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * Created by 陆英杰
 * 2018/9/9 23:13
 */
public class UDPClient {

    public static void main(String[] args) throws Exception {
        /**
         * 将要发送的数据转化成字节数组
         */
        byte[] buf=(new String("hello")).getBytes();

        /**
         * new一个DatagramPacket(一个数据包),里面封装了数据,还有要发送的ip地址和端口号
         */
        DatagramPacket dp=new DatagramPacket(buf,buf.length,new InetSocketAddress("127.0.0.1",10000));

        /**
         * new一个DatagramSocket,通过DatagramSocket来进行将数据包发送到目的地
         */
        DatagramSocket ds=new DatagramSocket(9999);

        /**
         * 发送数据包
         */
        ds.send(dp);

        /**
         * 关闭连接
         */
        ds.close();
    }
}
