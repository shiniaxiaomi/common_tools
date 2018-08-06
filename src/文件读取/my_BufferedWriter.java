package 文件读取;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Yingjie.Lu on 2018/7/26.
 */

/*
* 使用BufferedWriter类写文本文件,用于写入较多的文本
*/
public class my_BufferedWriter {
    public static void main(String[] args) throws Exception {

        BufferedWriter out =new BufferedWriter(new FileWriter("src\\文件读取\\1.txt"));//新建文本
//        BufferedWriter out =new BufferedWriter(new FileWriter("1.txt",true));//追加文本

        out.write("hello sadada");
        out.newLine();//注意\n不一定在各种计算机上都能产生喊喊的效果,所以保险起见,使用newLine()
        out.write("sdfsdfsdfsdfsd");

        out.close();

    }
}
