package com.myInterface;

/**
 * @ClassName testInterface
 * @Description //定义接口的详细说明：
    1. 访问修饰符：只能是public或默认。
    2. 接口名：和类名采用相同命名机制。
    3. extends：接口可以多继承。
    4. 常量：接口中的属性只能是常量，总是：public static final 修饰。不写也是。
    5. 方法：接口中的方法只能是：public abstract。 省略的话，也是public abstract。
    要点
    1. 子类通过implements来实现接口中的规范。
    2. 接口不能创建实例，但是可用于声明引用变量类型。
    3. 一个类实现了接口，必须实现接口中所有的方法，并且这些方法只能是public的。
    4. JDK1.7之前，接口中只能包含静态常量、抽象方法，不能有普通属性、构造方法、普通方法。
    5. JDK1.8后，接口中包含普通的静态方法。
    区别：
    1. 普通类：具体实现
    2. 抽象类：具体类实现，规范(抽象方法)
    3. 接口：规范!
 * @Author liuyw
 * @Date 2019-11-12 9:21
 * @Version 1.0
 **/
interface Volant{
    /**
    总是：public static final类型的;只能是常量
     */
    int FLY_HEIGHT = 880;
    /**
    总是：public abstract void fly();一定是抽象方法
     */
    void fly();
}

interface Honest{
    void helpOthers();
}

/**
 * Angle类实现飞行接口和善良接口
 */
class angel implements Volant,Honest{
    @Override
    public void fly(){
       System.out.println("天使能飞");
    }
    @Override
    public void helpOthers(){
        System.out.println("扶老人过马路");
    }
}

class goodMan implements Honest{
    @Override
    public void helpOthers() {
        System.out.println("好人会帮助他人");
    }
}

interface classA{
    void classA();
}

interface classB {
    void classB();
}

interface classC extends classA,classB{   //接口类可以多继承，普通类只能单继承！
    void classC();
}

class test implements classC{
    @Override
    public void classA() {
    }

    @Override
    public void classB() {

    }

    @Override
    public void classC() {

    }
}
public class testInterface {
    public static void main(String[] args) {
        Volant volant = new angel();   //接口不能创建实例，但是可用于声明引用变量类型
        volant.fly();
        angel ang = new angel();
        ang.fly();

        Honest hon = new goodMan();
        hon.helpOthers();

    }


}

