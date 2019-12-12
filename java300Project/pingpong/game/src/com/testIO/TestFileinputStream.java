package com.testIO;

import java.io.*;

/**
 * @ClassName TestFileinputStream
 * @Description //文件字节流FileInputStream读取的标准流程
 * @Author liuyw25167
 * @Date 2019-11-29 9:15
 * @Version 1.0
 **/
public class TestFileinputStream {
    public static void main(String[] args) {
        //1、获取源
       // File inFile = new File("D:/codeHub/DayDayJAVA/java300Project/pingpong/game/src/com/testIO/mmabc.txt");
        //工程的路径，确定文件 绝对路径
        System.out.println(System.getProperty("user.dir"));
        File inFile = new File("mmabc.txt");
        InputStream is = null;
        try {
            //InputStream 是IO中4大基本抽象类，其余都是继承实现
            //2、选择流 (面向接口编程)fileInputStream是InputSteam的子类，FileInputStream通过字节的方式读取文件
            is = new FileInputStream(inFile);
            //3、操作
            int data;
            //tip现在是一个个字节读，返回是数据的ASCII码；应该用byte[] 一段段读，read方法的返回是读的长度
            while((data = is.read())!=-1){
                //返回字符的 ASCII码
                System.out.println((char)data);
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
