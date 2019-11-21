package com.testCollection;

/**
 * @ClassName TestCollection
 * @Description //通过泛型实现集合（或容器）
 * 可以在类的声明处增加泛型列表，如：<T,E,V>
 * List set是Collection类的子接口；ArrayList及LinkedList、HashSet分别是List、Set的实现类
 * @Author liuyw
 * @Date 2019-11-21 21:22
 * @Version 1.0
 **/
public class TestCollection {
    public static void main(String[] args) {
        MyCollection<String> mc  = new MyCollection<String>();
        mc.set("aaa",0);
        mc.set("bbb",2);
        String str = mc.get(2);
        System.out.println(str);
    }

}
/**
 * 通过泛型定义一个容器，及get set方法
 */

class MyCollection<E> {
    Object[] objs = new Object[5];

    public E get(int index){
        return (E)objs[index];
    }
    public void set(E e,int index){
        objs[index] = e;
    }
}
