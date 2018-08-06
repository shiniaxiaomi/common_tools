package 自定义注解; /**
 * Created by Yingjie.Lu on 2018/7/26.
 */

import java.lang.annotation.*;

/**
 * 水果名称注解
 */
@Target(ElementType.FIELD)  //在类的字段中使用
@Retention(RetentionPolicy.RUNTIME) //运行时
@Documented //注解是否将包含在JavaDoc中
public @interface FruitName {

    String value() default "";

}
