package com.testThreads;

/**
 * @ClassName TestThreadImpl02
 * @Description //
 * 02|实现Runable接口，重写run方法（推荐）
 * @Author liuyw25167
 * @Date 2019-12-29 17:47
 * @Version 1.0
 **/
public class TestThreadImpl02 implements Runnable {
    @Override
    //线程体
    public void run() {
        for(int i =0 ;i<100;i++){
            System.out.println("->"+i);
        }
    }

    public static void main(String[] args) {
        Thread thread01 = new Thread(new TestThreadImpl02());
        Thread thread02 = new Thread(new TestThreadImpl02());
        thread01.start();
        thread02.start();

    }
}
