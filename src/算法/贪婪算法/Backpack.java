package 算法.贪婪算法;

/**
 * 贪心算法－背包算法：
 */
public class Backpack {
    // 现有一个背包容量150kg
// 有一个宝藏里面有很多物品，物品的重量和价值分别为：
// 25kg--20
// 30kg--40
// 60kg--45
// 35kg--50
// 20kg--10
// 50ke--45
// 40ke--50
    private int[] weights = new int[] {35,30,16,50,40,10,25,19,38};// 物品重量
    private int[] values = new int[] {10,40,30,50,35,40,30,20,28};// 物品价值
    private int capacity = 150;
    /**
     * 根据物品重量和物品价值，求出每个物品的性价比－》将性价比进行排序－》选取性价比最高的物品添加到背包中－》直到背包不能再添加
     */
    public void backpack() {
// step1:求物品性价比－》并从大到小排序
        int size = weights.length;// 物品数量
        double[] prices = new double[size];// 每个物品的性价比(每kg的价值)
// 用一个数组用于保存排序后的性价比和最开始的物品重量的下标
        int[] tags = new int[size];
        for (int i = 0; i < size; i++) {
            prices[i] = (double) values[i] /weights[i] ;
            tags[i] = i;//默认排序
        }
// 选择排序
        for (int i = 0; i < size; i++) {
            for (int j = i+1; j < size; j++) {
                if (prices[i] < prices[j]) {
// 交换
                    double temp = prices[i];
                    prices[i] = prices[j];
                    prices[j] = temp;
                    int tag = tags[i];
                    tags[i] = tags[j];
                    tags[j] = tag;
                }
            }
        }
// 根据已经从大到小排好序的性价比，和相对应的重量和价值，添加到背包中
        for (int i = 0; i < size; i++) {
// 根据tags数组中重量的下标，拿到重量
            if (weights[tags[i]] < capacity) {
                System.out.println("添加物品" + weights[tags[i]]);
                capacity = capacity - weights[tags[i]];
            }
        }
    }
    public static void main(String[] args) {
        Backpack backpack = new Backpack();
        backpack.backpack();
    }
}