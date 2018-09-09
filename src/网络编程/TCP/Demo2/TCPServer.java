package 网络编程.TCP.Demo2;

import java.io.DataInputStream;
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
         * 如果通过一个while循环一直获取到client端的连接的话,那么,这个服务器端就可以获取到多个client端的连接
         */
        while(true){
            /**
             * 是一个阻塞式的方法,接收一个socket连接;如果client端发起连接之后,那么在服务器端就可以通过accept()这个方法拿到socket,从而进行通讯
             */
            Socket s=ss.accept();

            /**
             * 拿到一个与client端建立了连接的socket的输入流
             */
            DataInputStream dis=new DataInputStream(s.getInputStream());
            String str = dis.readUTF();//读取输入流中的数据
            System.out.println("a client connected:"+str);//打印

        }
    }
}
