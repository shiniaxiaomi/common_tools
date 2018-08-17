package 配置文件读取;

import java.io.*;
import java.net.URL;
import java.util.Properties;

/**
 * Created by Yingjie.Lu on 2018/7/26.
 */
public class PropertieUtil {

    public static Properties getProer(String path){
        Properties pro=null;
        //从文件中读取
        FileReader in= null;//获取输入流
        try {
            in = new FileReader(path);
            pro=new Properties();
            pro.load(in);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(in!=null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return pro;
    }


    public static void main(String[] args) throws Exception {

        Properties pro=PropertieUtil.getProer("src\\配置文件读取\\pro.txt");

        String value=pro.getProperty("name");
        System.out.println(value);
    }
}
