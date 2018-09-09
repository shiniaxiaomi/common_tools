package 网络编程.TCP.Demo1;

import java.io.IOException;
import java.net.Socket;

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
    }
}
