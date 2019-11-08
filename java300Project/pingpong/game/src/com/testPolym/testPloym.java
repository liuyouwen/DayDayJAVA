package com.testPolym;

/**
 * @ClassName testPloym
 * @Description //测试多态
 * 多态的要点：
    1. 多态是方法的多态，不是属性的多态(多态与属性无关)。
    2. 多态的存在要有3个必要条件：继承，方法重写，父类引用指向子类对象。
    3. 父类引用指向子类对象后，用该父类引用调用子类重写的方法，此时多态就出现了。
 * @Author liuyw
 * 多态最为多见的一种用法，即父类引用做方法的形参，实参可以是任意的子类对象，可以通过不同的子类对象实现不同的行为方式
 * @Date 2019-11-08 9:38
 * @Version 1.0
 **/
public class testPloym {

    public static void main(String[] args){
        Animal a = new Animal();
        a.shout();
        Animal b = new Dog(); // 向上可以自动转型
        b.shout(); //b为编译类型，Dog对象才是运行时类型

        Animal a1 = new Dog(); // 向上可以自动转型
        AnimalShout(a1);
        Animal a2 = new Cat();
        AnimalShout(a2);

    }
    // 有了多态，只需要让增加的这个类继承Animal类就可以了
    static void AnimalShout(Animal a){
        a.shout();
    }
    /* 如果没有多态，我们这里需要写很多重载的方法。
     * 每增加一种动物，就需要重载一种动物的喊叫方法。非常麻烦。
    static void animalCry(Dog d) {
        d.shout();
    }
    static void animalCry(Cat c) {
        c.shout();
    }*/

}
class Animal{
    public void shout(){
        System.out.println("叫一声");
    }
}

class Dog extends Animal{
    @Override
    public void shout(){
        System.out.println("汪汪汪");
    }
}

class Cat extends Animal{
    @Override
    public void shout(){
        System.out.println("喵喵喵");
    }
}
