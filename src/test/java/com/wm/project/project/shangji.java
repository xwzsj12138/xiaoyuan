package com.wm.project.project;

import java.io.*;
import java.util.Scanner;

/**
 * 从控制台中读入一个文件名，判断该文件是否存在你的某个盘下。
 * 如果该文件存在，则在原文件相同路径下创建一个文件名为“copy_原文件名”的新文件，
 * 该文件内容为原文件的拷贝。
 */
public class shangji {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个文件名：");
        String fileName = "C:/summerjava/" + sc.next();
        boolean flag = false;
        try {
            flag = copyFile(fileName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(flag);//创建成功
    }

    private static boolean copyFile(String fileName) throws IOException {
        File copyFile = createFile(fileName);
        //判断拷贝是否为空
        if (copyFile == null) {
            return false;
        }
        InputStream inputStream = new FileInputStream(fileName);//读源文件
        OutputStream outputStream = new FileOutputStream(copyFile);//写到复制出的文件中
        int len = 0;
        while ((len = inputStream.read()) != -1) {
            outputStream.write(len);
        }
        inputStream.close();
        outputStream.close();
        return true;
    }

    private static File createFile(String fileName) throws IOException {
        File file = new File(fileName);
        if (file.exists()) {
            //获取父路径并拼接
            File copyFile = new File(file.getParent() + "/copy_" + file.getName());
            //复制后的路径
            System.out.println(copyFile);
            //创建文件
            copyFile.createNewFile();
            //返回创建的文件
            return copyFile;
        } else {
            System.out.println("你输入的文件不存在");
        }
        return null;
    }

}

