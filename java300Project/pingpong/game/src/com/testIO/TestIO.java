package com.testIO;

import java.io.*;

/**
 * @ClassName TestIO
 * @Description //字节流读取的标准流程
 * @Author liuyw25167
 * @Date 2019-11-29 9:15
 * @Version 1.0
 **/
public class TestIO {
    public static void main(String[] args) {
        //1、获取源
        File inFile = new File("mmabc.txt");
        InputStream is = null;
        try {
            //2、选择流 (面向接口编程)fileInputStream是InputSteam的子类，FileInputStream通过字节的方式读取文件
            is = new FileInputStream(inFile);
            //3、操作
            int data;
            while(is.read()!=-1){
                data = is.read();
                System.out.println(data);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(null != is){
                    //4、释放资源，关闭流
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
