package com.wm.project.project;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * 题目二：
 * 随机生成10个百位以内数字并存入集合中(任意集合均可，自行决定)
 * 。利用自己擅长的方式对其10个数字进行排序，排序后按小到大方式输出。
 */


public class shangji2 {


    public static void main(String[] args) {
        new shangji2().test2();


    }
    public void test1(){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i<10 ;i++){
            list.add(new Random().nextInt(100));
        }
        System.out.println("排序前");
        System.out.println(list);

        for (int i = 0; i < list.size(); i++) {
            for (int j = i;j < list.size() ;j ++){
                if(list.get(i) > list.get(j) ){
                    int flag =  list.get(i);
                    list.set(i,list.get(j));
                    list.set(j,flag);
                }
            }
        }
        System.out.println("排序后");
        System.out.println(list);
    }



    public void test2(){
        //1.提示并接收用户输入的行数:
        System.out.println("请输入您要打印星星的行数:");
        int n = new Scanner(System.in).nextInt();

        //2.开始打印图形
        //2.1外层循环控制打印的行数 i的取值范围:[1,n],一共n行
        for(int i=1;i<=n;i++){
            //2.2内层循环1
            //控制每行打印空格的个数 j的取值范围:[0,n-i),即1 2 3...
            for(int j=0;j<n-i;j++){
                System.out.print(" ");
            }
            //2.3内层循环2
            //控制每行打印星星的个数 k的取值范围:[1,2*i-1],即1 3 5 ...
            for(int k=1;k<=2*i-1;k++){
                System.out.print("*");
            }
            //2.4打印完本行所有内容后添加换行
            System.out.println();
        }

    }
}
