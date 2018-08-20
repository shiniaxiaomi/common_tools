package 算法.回溯算法;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by Yingjie.Lu on 2018/8/20.
 *///
public class a {

    public static boolean isExist(List list, boolean[][] a){

        return false;
    }

    //拷贝数组
    private static boolean[][] arraycopy(boolean[][] board) {
        boolean[][] a=new boolean[board.length][board.length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                a[i][j] = board[i][j];
            }
        }
        return a;
    }

    public static void digui(Set set,boolean[][] aaa,int n){
        if(n==aaa.length){

            set.add(arraycopy(aaa));
            return;
        }

        for(int i=0;i<aaa.length;i++){
            for(int t=0;t<aaa.length;t++){
                if(aaa[i][t]==true){
                    continue;
                }
                aaa[i][t]=true;
                digui(set,aaa,n+1);
                aaa[i][t]=false;//恢复现场
            }
        }

    }

    public static void syso(boolean[][] arr){
        for(int i=0;i<arr.length;i++){
            for(int t=0;t<arr.length;t++){
                System.out.print(arr[i][t]+",");
            }
            System.out.println();
        }
        System.out.println("===============================");
    }

    public static void main(String[] args) {
        boolean[][] aaa=new boolean[][]{
                {false,false},
                {false,false}
        };

        Set set=new HashSet();

        digui(set,aaa,0);

        Iterator<boolean[][]> it = set.iterator();
        while (it.hasNext()) {
//            boolean[][] arr = it.next();
//            syso(arr);
            System.out.println(it.next());
        }

    }


}
