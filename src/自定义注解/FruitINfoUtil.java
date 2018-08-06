package 自定义注解;

/**
 * Created by Yingjie.Lu on 2018/7/26.
 */

import java.lang.reflect.Field;

/**
 * 注解解析器
 */
public class FruitINfoUtil {

    public static void getFruitInfo(Class<?> clazz){
        Field[] fields=clazz.getDeclaredFields();

        for(Field f:fields){
            if(f.isAnnotationPresent(FruitName.class)){
                FruitName fruitName = (FruitName) f.getAnnotation(FruitName.class);//获得注解里的值
                System.out.println(fruitName.value());
            }else if(f.isAnnotationPresent(FruitColor.class)){
                FruitColor fruitColor= (FruitColor) f.getAnnotation(FruitColor.class);
                System.out.println(fruitColor.fruitColor());
            }
        }

    }

    public static void main(String[] args) throws Exception {

        getFruitInfo(Class.forName("自定义注解.Apple"));
    }

}
