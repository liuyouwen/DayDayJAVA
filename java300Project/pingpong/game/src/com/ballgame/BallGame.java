package com.ballgame;

import sun.awt.image.ToolkitImage;

import java.awt.*;
import javax.swing.*;

/**
 * @ClassName BallGame
 * @Description //实现动画，小球沿着水平方向移动并做边界检测
 * @Author liuyw
 * @Date 2019-11-04 21:14
 * @Version 1.0
 **/
public class BallGame extends JFrame {

    Image ball = Toolkit.getDefaultToolkit().getImage("images/ball.png");
    Image desk = Toolkit.getDefaultToolkit().getImage("images/desk.jpg");
    //小球横坐标x
    double x =100;
    //小球纵坐标
    double y =100;
    boolean right =true;  //方向
    /**画窗口的方法*/
    @Override
    public void paint(Graphics g){
        System.out.println("窗口被画了一次");
        g.drawImage(desk,0,0,null);
        g.drawImage(ball, (int)x, (int)y, null);
        if(right){
            x = x + 10;
        }else{
            x = x - 10;
        }
        if(x>856-40-30){ //856是窗口宽度，40是桌子边框的宽度，30是小球的直径
            right = false;
        }
        if(x<40){
            right = true;
        }
    }
    //窗口加载
    void launchFrame(){
        setSize(856,500);
        setLocation(50,50);
        setVisible(true);
        //重画窗口，每秒画25次
        while (true){
            repaint();
            try{
                Thread.sleep(40); //40ms
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("DayDayJAVA");
        BallGame game = new BallGame();
        game.launchFrame();
    }

}
