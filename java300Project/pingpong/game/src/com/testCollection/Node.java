package com.testCollection;

/**
 * @ClassName Node
 * @Description //Node节点类，LinkedList使用
 * @Author liuyw25167
 * @Date 2019-11-23 14:43
 * @Version 1.0
 **/
public class Node {
    //上一节点
    Node previous;
    //下一节点
    Node next;
    //元素数据
    Object element;

    public Node(Node previous, Node next, Object element) {
        super();
        this.previous = previous;
        this.next = next;
        this.element = element;
    }

    public Node(Object element) {
        this.element = element;
    }
}
