package com.testCollection;

/**
 * @ClassName TestArraylist
 * @Description //手写ArrayList
 * 1、定义数组和size；构造方法；增加元素方法add;为打印元素重写toString;增加泛型
 * 2、数组自动扩容(在add方法中)
 * 3、get，set方法；
 * 4、增加remove移除方法;Size和 isEmpty方法
 *
 * @Author liuyw25167
 * @Date 2019-11-23 13:41
 * @Version 1.0
 **/
public class TestArraylist<E> {
    private Object[] elementData;
    private int size;

    private static final int DEFAULT_CAPACITY=10;

    //两个构造方法
    public TestArraylist(){
        elementData = new Object[DEFAULT_CAPACITY];
    }
    public TestArraylist(int capacity){
        if(capacity < 0){
            throw new RuntimeException("容器容量不能为负数");
        }else if(capacity == 0){
            elementData = new Object[DEFAULT_CAPACITY];
        } else {
            elementData = new Object[capacity];
        }
    }

    public void add(E element){

        //什么时候扩容
        if(size == elementData.length){
            //怎么扩容
            Object[] newArray = new Object[elementData.length+(elementData.length>>1)];
            System.arraycopy(elementData,0,newArray,0,elementData.length);
            elementData = newArray;
        }
        elementData[size++] = element;
    }

    public E get(int index){
        checkRange(index);
        return (E)elementData[index];
    }

    public void set(E element, int index){
        checkRange(index);
        elementData[index] = element;
    }

    public void checkRange(int index){
        if(index < 0|| index> size-1){
            throw new RuntimeException("索引不合法！");
        }
    }

    public void remove(E element){
        for(int i=0;i<size;i++){
            if(element.equals(get(i))){
                remove(i);
            }
        }
    }

    public void remove(int index){
        int numMoved = elementData.length-index-1;
        if(numMoved>0){
            //可以看出ArrayList为啥删除效率低
            System.arraycopy(elementData,index+1,elementData,index,numMoved);
        }
        //删除后，最后一个元素为空,长度减1
        elementData[size-1] = null;
        size --;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        if(size == 0){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String  toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i=0;i<size;i++){
            sb.append(elementData[i] + ",");
        }
        sb.setCharAt(sb.length()-1,']');
        return sb.toString();
    }

    public static void main(String[] args) {
        TestArraylist<String> testList1 = new TestArraylist<>(20);
        for(int i=0; i<40;i++){
            testList1.add("MSN"+i);
        }

        System.out.println(testList1);
        System.out.println(testList1.get(10));
        testList1.set("HaHA",39);
        System.out.println(testList1.get(39));
        testList1.remove(3);
        System.out.println(testList1);
        System.out.println(testList1.size());
        System.out.println(testList1.isEmpty());

    }
}
