package 文件读取;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Yingjie.Lu on 2018/7/26.
 */

/*
* 使用FileWriter类写文本文件
*/

/*
 * 如果写入的文本很少，使用FileWrite类就可以了
 * 但如果需要写入的内容很多，就应该使用更为高效的缓冲器流类BufferedWriter。
 */

public class my_FileWriter {
    public static void main(String[] args) throws Exception {

        FileWriter f=new FileWriter("src\\文件读取\\1.txt");//如果存在1.txt文件，则先把这个文件给删除掉，然后创建新的1.txt
//        FileWriter f=new FileWriter("1.txt",true);//追加文本

        f.write("hello");

        f.close();

    }
}
