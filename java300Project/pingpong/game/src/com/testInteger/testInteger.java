package com.testInteger;

/**
 * @ClassName testInteger
 * @Description //. JDK1.5以后，增加了自动装箱与拆箱功能，如：
  Integer i = 100;  int j = new Integer(100);
 2. 自动装箱调用的是valueOf()方法，而不是new Integer()方法。
 3. 自动拆箱调用的xxxValue()方法。
 4. 包装类在自动装箱时为了提高效率，对于-128~127之间的值会进行缓存处理。
    超过范围后，对象之间不能再使用==进行数值的比较，而是使用equals方法。
 * @Author liuyw
 * @Date 2019-11-18 9:36
 * @Version 1.0
 **/
public class testInteger {
    public static void main(String[] args){
        Integer num1 = -128;
        Integer num2 = -128;
        //true 因-128在IntegerCache范围内[-128,127],指向同一对象
        System.out.println(num1 == num2);
        System.out.println(num1.equals(num2));
        Integer num3 = 1234;
        Integer num4 = 1234;
        //false 不在缓存范围内，相当于new integer(i)
        System.out.println(num3 == num4);
        System.out.println(num3.equals(num4));
    }
}
