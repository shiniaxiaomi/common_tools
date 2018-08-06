package 文件读取;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by Yingjie.Lu on 2018/7/26.
 */
public class my_BufferedReader {
    public static void main(String[] args) throws Exception{

        BufferedReader in =new BufferedReader(new FileReader("src\\文件读取\\1.txt"));//用FileReader读取,用BufferedReader做缓冲

        String line=in.readLine();
        while(line!=null){//如果为null,表示结束
            System.out.println(line);
            line=in.readLine();//一行一行读取
        }

        in.close();
    }
}
