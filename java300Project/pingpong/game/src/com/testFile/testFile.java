package com.testFile;

import java.io.File;

/**
 * @ClassName com.testFile
 * @Description //递归打印文件目录
 * @Author liuyw
 * @Date 2019-11-19 19:45
 * @Version 1.0
 **/
public class testFile {

    public static void main(String[] args) {
        File file = new File("d:/codeHub");
        printFile(file,0);


    }
    private static void printFile(File file, int level){
        for(int i =0;i<level;i++){
            System.out.print("-");
        }
        System.out.println(file.getName());

        if(file.isDirectory()) {
            File[] files = file.listFiles();
            for(File tmp: files){
                //此处做的 与之前步骤一样，递归
                printFile(tmp,level +1);
            }
        }
    }
}
