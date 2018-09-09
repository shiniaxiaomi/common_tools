package 网络编程.TCP.Demo2;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by 陆英杰
 * 2018/9/9 22:10
 */
public class TCPClient {

    public static void main(String[] args) throws IOException {
        /**
         * host是服务器端的ip,通过ip才可以找到服务器,才能够建立起连接;client端的端口是client端的系统自动随机指定的端口
         * 直接new一个socket就相当于直接与服务器端建立了一个连接
         */
        Socket s=new Socket("127.0.0.1",10000);

        /**
         * 拿到与服务器端建立了连接的socket的输出流,这样client端就可以通过这个输出流往服务器端发送信息
         */
        DataOutputStream dos=new DataOutputStream(s.getOutputStream());
        dos.writeUTF(new Scanner(System.in).nextLine());
        dos.flush();//将输出流中缓冲区的信息全部输出
        dos.close();//关闭输出流

        /**
         * 关闭socket连接
         */
        s.close();
    }
}
