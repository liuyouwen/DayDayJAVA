package com.testExtends;

/**
 * @ClassName TestExtends
 * @Description //测试 继承、重写、带参构造方法、对象与类的关系
 * @Author liuyw25167
 * @Date 2019-11-07 9:07
 * @Version 1.0
 **/
public class TestExtends {

    public static void main(String[] args){
        Student stu1 = new Student();
        stu1.name = "小刘";
        stu1.age = 18;
        stu1.major = "挖掘机";
        stu1.introduce();

        Student stu2 = new Student("刘工",18,"挖掘机2");
        //能减少像stu1的赋值操作
        stu2.introduce();

        //对象是类的实例
        System.out.println(stu1 instanceof Student);
        System.out.println(stu1 instanceof Person);
        System.out.println(stu1 instanceof Object);
        System.out.println(new Person() instanceof Student);

    }
}

    class Person{
        String name;
        int age;
        public void introduce() {
            System.out.println("I am" + name + age);
        }
    }

    class Student extends Person{
        String major;
        @Override
        //重写
        public void introduce(){
            System.out.println("I am student"+ name + age + major);
        }
        //带参的构造方法，注意不用定义返回类型(返回值的类型肯定是本类)
        public Student(String name, int age, String major){
            this.name = name;
            this.age = age;
            this.major = major;
        }
        //自带的无参数构造方法，默认会创建
        public Student(){
        }
    }

