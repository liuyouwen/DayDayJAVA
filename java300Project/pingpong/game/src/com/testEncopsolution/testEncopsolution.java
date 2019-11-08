package com.testEncopsolution;

/**
 * @ClassName com.testEncopsolution
 * @Description //测试封装
 * 1. 一般使用private访问权限。
   2. 提供相应的get/set方法来访问相关属性，这些方法通常是public修饰的，以提供对属性的赋值与读取操作(注意：boolean变量的get方法是is开头!)。
   3. 一些只用于本类的辅助性方法可以用private修饰，希望其他类调用的方法用public修饰。
 * @Author liuyw25167
 * @Date 2019-11-08 9:12
 * @Version 1.0
 **/
public class testEncopsolution {
    public static void main(String[] args) {
        Person liugong = new Person();
        liugong.setName("liugong");
        liugong.setAge(18);
        liugong.setSex("male");

        System.out.println(liugong.getName()+" " +liugong.getAge() +" "+ liugong.getSex());
    }


}

  class Person{
    private String name;
    private int age;
    private String  sex;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getAge(){
        return age;
    }
     public void setAge(int age){
        this.age = age;
     }

     public String getSex(){
         return sex;
     }
     public void setSex(String sex){
         this.sex = sex;
     }
}
