package 自定义注解;

import java.lang.annotation.*;

/**
 * Created by Yingjie.Lu on 2018/7/26.
 */

/**
 * 水果颜色注解
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitColor {

    /**
     * 颜色枚举
     */
    public enum Color{BLUE,RED,GREEN};

    Color fruitColor() default Color.GREEN;

}
