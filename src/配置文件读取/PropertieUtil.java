package 配置文件读取;

import java.io.*;
import java.net.URL;
import java.util.Properties;

/**
 * Created by Yingjie.Lu on 2018/7/26.
 */
public class PropertieUtil {
    public static void main(String[] args) throws Exception {

        //从文件中读取
        FileReader in=new FileReader("src\\配置文件读取\\pro.txt");//获取输入流

        Properties pro=new Properties();
        pro.load(in);

        String value=pro.getProperty("name");
        System.out.println(value);

        in.close();
    }
}
