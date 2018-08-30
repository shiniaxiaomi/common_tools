package 配置文件读取;

import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.util.Properties;

/**
 * Created by Yingjie.Lu on 2018/7/26.
 */
public class PropertieUtil2 {

    public static void main(String[] args) throws Exception {

        //默认按照当前路径下查找,如果没有找到,则回到默认定义的路径中取寻找,比如说在java的安装路径下的jre/classes文件夹下
        Properties pro= PropertiesLoaderUtils.loadAllProperties("配置文件读取/pro.txt");
        String value=pro.getProperty("name");
        System.out.println(value);
    }
}
