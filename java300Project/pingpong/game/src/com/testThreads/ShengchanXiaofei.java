package com.testThreads;

import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * @ClassName ShengchanXiaofei
 * @Description //协作模型：生产者消费者模式实现方式一：管程法
 * @Author liuyw25167
 * @Date 2019-12-29 18:59
 * @Version 1.0
 **/
public class ShengchanXiaofei {
    public static void main(String[] args) {
        syncStack ssStack = new syncStack();
        Shengchan sc = new Shengchan(ssStack);
        Xiaofei xf = new Xiaofei(ssStack);
        sc.start();
        xf.start();
    }
}

class ManTou{
    int id;
    public ManTou(int id){
        this.id = id;
    }
}

/**
 * 缓冲区
 */
class syncStack{
    int index = 0;
    ManTou[] ms = new ManTou[100];

    //生产者的处理情况
    synchronized void push(ManTou m){
        while (index == ms.length){ //说明缓冲区满了，生产者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 唤醒在当前对象等待池中等待的第一个线程。
        this.notify();
        ms[index]= m;
        index ++;
    }
    //消费者的处理情况
    synchronized ManTou pop(){
        while(index == 0){ //缓冲为空
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notify();
        index --;
        return ms[index];
    }
}

//生产者
class Shengchan extends Thread{
    syncStack ss = null;
    public Shengchan(syncStack ss){
        this.ss = ss;
    }

    @Override
    public void run() {
        for(int i=0;i<100;i++){
            System.out.println("生产馒头"+i);
            ManTou m = new ManTou(i);
            ss.push(m);
        }
    }
}

class Xiaofei extends Thread{
    syncStack ss = null;

    public Xiaofei(syncStack ss){
        this.ss = ss;
    }

    @Override
    public void run() {
        for(int i=0;i< 100; i++){
            ManTou m = ss.pop();
            System.out.println("消费馒头"+ i);
        }
    }
}


