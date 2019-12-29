package com.testThreads;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName SyncListAdd
 * @Description //
 * lamada方式起1000个线程；synchronized线程块同步
 * @Author liuyw25167
 * @Date 2019-12-29 18:23
 * @Version 1.0
 **/
public class SyncListAdd {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        for(int i=0;i<1000;i++){
            //lamada方式
            new Thread(()->{
                synchronized (list) {
                    list.add(Thread.currentThread().getName());
                }
            }).start();
        }
        //此处延时，用于等待多线程的完全完成
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
    }
}
