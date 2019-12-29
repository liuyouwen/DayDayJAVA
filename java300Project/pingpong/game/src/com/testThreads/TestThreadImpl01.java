package com.testThreads;

/**
 * @ClassName TestThreadImpl
 * @Description //多线程的实现方式
 *  01|继承Thread类，重写run方法（不推荐，因JAVA中类的单继承）
 *  02|实现Runable接口，重写run方法（推荐）
 * @Author liuyw25167
 * @Date 2019-12-29 17:29
 * @Version 1.0
 **/
public class TestThreadImpl01 extends Thread{
    public static void main(String[] args) {
        Thread thread01 = new TestThreadImpl01();
        Thread thread02 = new TestThreadImpl01();
        thread01.start();
        thread02.start();

    }

        /**
         * 线程体
         */
        @Override
        public void run() {
            for(int i =0;i<100;i++){
                System.out.println("->"+ i );
            }
        }
}


