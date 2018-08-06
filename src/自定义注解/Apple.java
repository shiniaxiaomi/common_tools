package 自定义注解;

/**
 * Created by Yingjie.Lu on 2018/7/26.
 */
public class Apple {

    @FruitName(value = "sdfsdfs")
    private String appleName;

    @FruitColor(fruitColor = FruitColor.Color.BLUE)
    private String appleColor;

}
