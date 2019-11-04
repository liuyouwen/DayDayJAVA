package com.ballgame;

import sun.awt.image.ToolkitImage;

import java.awt.*;
import javax.swing.*;

/**
 * @ClassName BallGame
 * @Description //TODO
 * @Author liuyw
 * @Date 2019-11-04 21:14
 * @Version 1.0
 **/
public class BallGame extends JFrame {

    Image ball = Toolkit.getDefaultToolkit().getImage("images/ball.png");
    Image desk = Toolkit.getDefaultToolkit().getImage("images/desk.jpg");

    double x =100; //小球横坐标
    double y =100; //小球纵坐标
    //画窗口的方法
    @Override
    public void paint(Graphics g){
        System.out.println("窗口被画了一次");
        g.drawImage(desk,0,0,null);
        g.drawImage(ball, (int)x, (int)y, null);
    }
    //窗口加载
    void launchFrame(){
        setSize(856,500);
        setLocation(50,50);
        setVisible(true);
    }

    public static void main(String[] args) {
        System.out.println("DayDayJAVA");
        BallGame game = new BallGame();
        game.launchFrame();
    }

}
