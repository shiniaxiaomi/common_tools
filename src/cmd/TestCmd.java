package cmd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Yingjie.Lu on 2018/11/26.
 */

/**
 * 使用java调用cmd命令
 */
public class TestCmd {

    public static void main(String[] args) {
//        String cmd = "C:\\User\s\\Yingjie.lu\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe http://localhost:8080";//用浏览器打开网址
        String cmd = "cmd /c dir";//执行dir命令
        Runtime run = Runtime.getRuntime();
        BufferedReader br=null;
        try{
            Process process = run.exec(cmd);
            br = new BufferedReader(new InputStreamReader(process.getInputStream(),"GB2312"));//解决中文乱码问题
            String msg = null;
            while ((msg = br.readLine()) != null) {
                System.out.println(msg);
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



}
