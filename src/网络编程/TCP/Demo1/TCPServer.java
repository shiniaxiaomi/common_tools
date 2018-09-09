package 网络编程.TCP.Demo1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by 陆英杰
 * 2018/9/9 22:09
 */
public class TCPServer {


    public static void main(String[] args) throws IOException {
        /**
         * 设定服务器端的端口号,来接收client端的信息(client端会通过ip找到这台服务器,然后在通过client端设置好的端口号,
         * 就可以知道这个服务器是监听在哪一个端口上,从而能够将消息送到正确的位置)
         */
        ServerSocket ss=new ServerSocket(10000);

        /**
         * 是一个阻塞式的方法,接收一个socket连接;如果client端发起连接之后,那么在服务器端就可以通过accept()这个方法拿到socket,从而进行通讯
         */
        Socket s=ss.accept();

        System.out.println("a client connected:"+s);
    }
}
