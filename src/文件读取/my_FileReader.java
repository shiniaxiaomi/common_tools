package 文件读取;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by Yingjie.Lu on 2018/7/26.
 */
public class my_FileReader {
    public static void main(String[] args) throws Exception {

        FileReader reader=new FileReader("src\\文件读取\\1.txt");

        int c=reader.read();
        while(c!=-1){//如果是-1,则表示读取结束
            System.out.print((char)c);//需要把字符编码转化成字符
            c=reader.read();
        }
        reader.close();

    }
}
