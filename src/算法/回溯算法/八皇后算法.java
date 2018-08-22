package 算法.回溯算法;

import java.util.*;

/**
 * Created by Yingjie.Lu on 2018/8/20.
 *///
public class 八皇后算法 {

    public static int count=0;
    public static Long allCount=0L;

    public static void main(String[] args) {

        Date begin =new Date();

        int N=6;
        //x表示不能填写,y表示已经有棋子,0表示可以填写
        char[][] aaa=new char[N][N];
        for(int i=0;i<aaa.length;i++){
            for(int t=0;t<aaa.length;t++){
                aaa[i][t]='-';
            }
        }

        List list=new ArrayList();

        digui(list,aaa,0);

        for(int i=0;i<list.size();i++){
            char[][] a= (char[][]) list.get(i);
            syso(a);
        }

        Date end =new Date();
        System.out.println(count);
        System.out.println(allCount);
        System.out.println("用时：" +String.valueOf(end.getTime()-begin.getTime())+ "毫秒，计算结果："+list.size());
    }

    public static void digui(List list,char[][] aaa,int n){

        if(n==aaa.length){//如果是8皇后,那么这个只执行92次,其实时间可以忽略不计

            if(!isExist(list,aaa)){
                list.add(arraycopy(aaa));//这里不能直接放aaa的引用
            }
            count++;
            return;
        }

        for(int i=0;i<aaa.length;i++){
            for(int t=0;t<aaa.length;t++){
                allCount++;

                if(aaa[i][t]=='y' || aaa[i][t]=='x'){//这里就已经在剪枝了,直接continue,那么就是在这个节点的下一个节点就直接跳过了,也就是所谓的剪枝
                    continue;
                }

                char[][] buff=arraycopy(aaa);
                aaa[i][t]='y';
                biaoji(aaa,i,t);//经过标记处理

                digui(list,arraycopy(aaa),n+1);
                aaa=arraycopy(buff);//恢复现场


            }
        }

    }

    public static boolean isExist(List list, char[][] a){

        for(int i=0;i<list.size();i++){
            char[][] o = (char[][]) list.get(i);

            int flag=0;//是否相同的标记
            for(int x=0;x<o.length;x++){
                if(flag==1) break;
                for(int y=0;y<o.length;y++){
                    if(o[x][y]==a[x][y]){//如果相等,则继续判断下一个
                        continue;
                    }else{
                        flag=1;
                    }
                }
            }
            if(flag==0){
                return true;
            }
        }

        return false;
    }

    //拷贝数组
    private static char[][] arraycopy(char[][] board) {
        char[][] a=new char[board.length][board.length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                a[i][j] = board[i][j];
            }
        }
//        char[][] a=new char[board.length][board.length];
//        a=board.clone();
        return a;
    }



    //标记已经不能下的位置
    public static char[][] biaoji(char[][] aaa,int i,int t){
        int x=i,y=t;
        while(true){//右下对角线
            x++;
            y++;
            if(isYueJie(aaa,x,y)){
                break;
            }else{
                if(aaa[x][y]=='-'){
                    aaa[x][y]='x';
                }
            }
        }

        x=i;y=t;
        while(true){//左上对角线
            x--;
            y--;
            if(isYueJie(aaa,x,y)){
                break;
            }else{
                if(aaa[x][y]=='-'){
                    aaa[x][y]='x';
                }
            }
        }

        x=i;y=t;
        while(true){//左下对角线
            x--;
            y++;
            if(isYueJie(aaa,x,y)){
                break;
            }else{
                if(aaa[x][y]=='-'){
                    aaa[x][y]='x';
                }
            }
        }

        x=i;y=t;
        while(true){//右上对角线
            x++;
            y--;
            if(isYueJie(aaa,x,y)){
                break;
            }else{
                if(aaa[x][y]=='-'){
                    aaa[x][y]='x';
                }
            }
        }

        x=i;y=t;
        while(true){//竖线向上
            y--;
            if(isYueJie(aaa,x,y)){
                break;
            }else{
                if(aaa[x][y]=='-'){
                    aaa[x][y]='x';
                }
            }
        }

        x=i;y=t;
        while(true){//竖线向下
            y++;
            if(isYueJie(aaa,x,y)){
                break;
            }else{
                if(aaa[x][y]=='-'){
                    aaa[x][y]='x';
                }
            }
        }

        x=i;y=t;
        while(true){//横线向左
            x--;
            if(isYueJie(aaa,x,y)){
                break;
            }else{
                if(aaa[x][y]=='-'){
                    aaa[x][y]='x';
                }
            }
        }

        x=i;y=t;
        while(true){//横线向右
            x++;
            if(isYueJie(aaa,x,y)){
                break;
            }else{
                if(aaa[x][y]=='-'){
                    aaa[x][y]='x';
                }
            }
        }

        return aaa;
    }

    //标记已经不能下的位置
    public static char[][] huifubiaoji(char[][] aaa,int i,int t){
        int x=i,y=t;
        while(true){//右下对角线
            x++;
            y++;
            if(isYueJie(aaa,x,y)){
                break;
            }else{
                if(aaa[x][y]=='x'){
                    aaa[x][y]='-';
                }
            }
        }

        x=i;y=t;
        while(true){//左上对角线
            x--;
            y--;
            if(isYueJie(aaa,x,y)){
                break;
            }else{
                if(aaa[x][y]=='x'){
                    aaa[x][y]='-';
                }
            }
        }

        x=i;y=t;
        while(true){//左下对角线
            x--;
            y++;
            if(isYueJie(aaa,x,y)){
                break;
            }else{
                if(aaa[x][y]=='x'){
                    aaa[x][y]='-';
                }
            }
        }

        x=i;y=t;
        while(true){//右上对角线
            x++;
            y--;
            if(isYueJie(aaa,x,y)){
                break;
            }else{
                if(aaa[x][y]=='x'){
                    aaa[x][y]='-';
                }
            }
        }

        x=i;y=t;
        while(true){//竖线向上
            y--;
            if(isYueJie(aaa,x,y)){
                break;
            }else{
                if(aaa[x][y]=='x'){
                    aaa[x][y]='-';
                }
            }
        }

        x=i;y=t;
        while(true){//竖线向下
            y++;
            if(isYueJie(aaa,x,y)){
                break;
            }else{
                if(aaa[x][y]=='x'){
                    aaa[x][y]='-';
                }
            }
        }

        x=i;y=t;
        while(true){//横线向左
            x--;
            if(isYueJie(aaa,x,y)){
                break;
            }else{
                if(aaa[x][y]=='x'){
                    aaa[x][y]='-';
                }
            }
        }

        x=i;y=t;
        while(true){//横线向右
            x++;
            if(isYueJie(aaa,x,y)){
                break;
            }else{
                if(aaa[x][y]=='x'){
                    aaa[x][y]='-';
                }
            }
        }

        return aaa;
    }

    //检查是否越界,true为越界
    public static boolean isYueJie(char[][] aaa,int x,int y){
        if(x<0 ||y<0 ||x>aaa.length-1||y>aaa.length-1){
            return true;
        }else{
            return false;
        }
    }

    public static void syso(char[][] arr){
        for(int i=0;i<arr.length;i++){
            for(int t=0;t<arr.length;t++){
                if(arr[i][t]=='x'){
                    System.out.print('-'+"  ");
                }else if(arr[i][t]=='y'){
                    System.out.print('O'+"  ");
                }
            }
            System.out.println();
        }
        System.out.println("===============================");
    }




}
