package com.testCollection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName TestLinkedlist
 * @Description /手写链表（增删很快，查找慢）。此处是一个双向链表（除头尾节点未串起来，其余节点是双向链）
 * 1、定义前后Node 和size(链表不关注具体的element，element由每个Node存储);重写toString打印
 * 2、add方法；get、set方法
 * 3、remove方法（注意删除首位末位的特殊性）
 * 4、insert方法（首末位处理）
 * 5、方法封装，加泛型
 * @Author liuyw
 * @Date 2019-11-23 14:41
 * @Version 1.0
 **/
public class TestLinkedList<E> {
    private Node first;
    private Node last;

    private int size;

    public void add(E obj){
        Node node= new Node(obj);
        if(first == null){
            first = node;
            last = node;
        }else{
            //把新节点 前部链入链表
            node.previous = last;
            node.next = null;

            //把新节点 后部链入链表
            last.next = node;
            last = node;
        }
        size++;
    }

    public Object get(int index){
        rangeCheck(index);
        Node temp = getNode(index);
        return (E)temp.element;
    }

    //查找方法 多地方要用，封装一下
    public Node getNode(int index){
        Node temp = null;
        //这里是 链表查找效率低的原因；为提高一些效率，增加条件，如果index大于一半,从last开始找
        if(index <= (size>>1)){
            temp =first;
            for(int i=0;i <index;i++){
                temp=temp.next;
            }
        }else {
            temp = last;
            for(int i=size-1;i >index;i--){
                temp=temp.previous;
            }
        }
        return temp;
    }

    public void set(E obj,int index){
        rangeCheck(index);
        Node temp = getNode(index);
        temp.element = obj;
    }

    public void remove(int index){
        rangeCheck(index);
        Node temp = getNode(index);
        if(temp!=null){
            Node up = temp.previous;
            Node down = temp.next;
            //再次拉手
            if(up!=null){
                up.next = down;
            }
            if(down != null){
                down.previous = up;
            }
            //首个 把first赋值null
            if(index ==0){
                first = down;
            }
            //最后一个，把当前Node的上一个为最后一个
            if(index == size-1){
                last = up;
            }
        }
        size --;
    }

    public void  insert (E obj, int index){
        Node newNode = new Node(obj);
        Node temp = getNode(index);
        if(temp!=null){
            Node up = temp.previous;
            if(up!=null){
                up.next = newNode;
                newNode.previous = up;

                newNode.next = temp;
                temp.previous = newNode;
            }
        }
        //首位末位插入时 特殊处理
        if(index == 0){
            first = newNode;
            newNode.next = temp;
            temp.previous = newNode;
        }
        if(index == size-1){
            last = newNode;
            newNode.previous = temp;
            temp.next = newNode;
        }
        size ++;
    }

    public void rangeCheck(int index){
        if(index < 0||index > size-1){
            throw new RuntimeException("索引数字不合法！");
        }
    }

    @Override
    public String  toString(){
        StringBuilder sb = new StringBuilder("[");
        Node temp = first;
        while(temp != null){
            sb.append(temp.element+",");
            temp = temp.next;
        }
        sb.setCharAt(sb.length()-1,']');
       return sb.toString();
    }

    public static void main(String[] args) {
        TestLinkedList<String> linked = new TestLinkedList<>();

        linked.add("a");
        linked.add("b");
        linked.add("c");
        linked.add("d");

        System.out.println(linked);
        System.out.println(linked.get(2));
        linked.set("dedede",2);
        System.out.println(linked);
        linked.remove(0);
        System.out.println(linked);
        linked.insert("HAHAHA",0);
        System.out.println(linked);

    }
}
