package com.wm.project.project;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

class A{
    public void aHelloA(){
        System.out.println("A1");
    }
    {
        System.out.println("A2");
    }
    static {
        System.out.println("A3");
    }
}
public class B extends A{
    public  void aB(){
        System.out.println("B1");
    }
    {
        System.out.println("B2");
    }
    static {
        System.out.println("B3");
    }

    public static void main(String[] args) {
//       String s1 = "A";
//       String s2 = "A";
//       String s3 = s1;
//        System.out.println(s3==s2);
        //1 计算两个int的触发，保留两位小数
            int a = 2;
            int b = 62;
        float num= (float)a/b;
        DecimalFormat df = new DecimalFormat("0.00");//格式化小数
        String s = df.format(num*100);
        System.out.println(s+"%");


        // 获取当前时间
        LocalDateTime now = LocalDateTime.now();

        // 获取当前时间的前24小时
        LocalDateTime before24Hours = now.withHour(0).withMinute(0).withSecond(0).withNano(0);

        // 格式化时间
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedTime = now.format(formatter);

        // 输出时间范围
        System.out.println("当前时间：" + formattedTime);
        System.out.println("前24小时时间范围：" + before24Hours);


    }


}
