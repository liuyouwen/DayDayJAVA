package com.testIO;

import java.io.*;

/**
 * @ClassName TestFileInputOutput
 * @Description //使用文件字节流输入、输出，实现文件拷贝
 * @Author liuyw25167
 * @Date 2019-12-12 22:03
 * @Version 1.0
 **/
public class TestFileInputOutput {
    public static void main(String[] args) {
        //1、获取源
        File src = new File("mmabc.txt");
        File dest = new File("mmabc-copy.txt");
        InputStream is = null;
        OutputStream os = null;
        try {
            //2、选择流
            is = new FileInputStream(src);
            os = new FileOutputStream(dest);
            //3、操作 用byte[]缓冲数组 一段段读，read方法的返回是读的长度
            byte[] flush = new byte[1024];
            int len = -1; //接收长度
            while((len=is.read(flush))!=-1){
                os.write(flush,0,len);
            }
            os.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭，先开的先关
            if(null!=is){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(null!=os){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
