package com.testCollection;

/**
 * @ClassName TestHashMap
 * @Description //手写HashMap；本质就是“数组+链表”
 * 1、基本结构；Put方法(按情况理解，HashMap数组+链表组合的特性)
 * 2、重写toString方法（两层循环）
 * 3、get方法
 * @Author liuyw25167
 * @Date 2019-11-27 18:42
 * @Version 1.0
 **/
public class TestHashMap<K,V> {
    //位桶数组 bucket array
    Node2[] table;
    int size;

    /**
     * 无参构造方法
     */
    public TestHashMap(){
        table = new Node2[16];
    }
    public void put(K key, V value){

        // 此处完善要考虑数组扩容

        Node2 newNode = new Node2();
        newNode.hash = myHash(key.hashCode(),16);
        newNode.key = key;
        newNode.value = value;
        newNode.next = null;

        //可以理解为 temp为对应位桶数组[hash]的头结点
        Node2 temp = table[newNode.hash];
        if(temp == null){  //该数组元素为空
            table[newNode.hash] = newNode;
            size++;
        } else{
            //注意不能写 while(temp.next!=null) 会影响单节点链表情况下的遍历
            while(temp != null){
                if(temp.key.equals(newNode.key)){
                    temp.value = newNode.value;
                    //key 相等，则value写入后 跳出循环
                    break;
                }else{
                    //key 不重复，遍历下一个
                    temp = temp.next;
                    //情况是temp.next == null ，正好是链表的最后一个结点;新节点加入链表
                    if(temp == null){
                        temp.next = newNode;
                        size++;
                    }
                }
            }
        }
    }

    public V get(K key) {
        int hash = myHash(key.hashCode(), table.length);
        Node2 temp = table[hash];
        V value = null;
        while (temp != null) {
            if (temp.key.equals(key)) {
                value = (V)temp.value;
                //此处break必须用，1、正常程序一个入口一个返回；2、不break会死循环
                break;
            } else {
                temp = temp.next;
            }
        }
        return value;
    }

        //两层循环遍历是蠢方法
//        for(int i=0;i<table.length;i++){
//            Node2 temp = table[i];
//            while(temp!=null){
//                if(temp.key.equals(key)){
//                    return temp.value;
//                }else{
//                    temp = temp.next;
//                }
//            }
//        }
//    }

    public int myHash(int v, int length){
        return v&(length-1);
        //或者是v%length效率低， 位操作效率高
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        //遍历bucket数组，获得的node2可理解为数组[hash]的头结点
        for(Node2 node2: table){
            while(node2!=null){
                sb.append(node2.key +":" +node2.value +",");
                node2 = node2.next;
            }
        }
        sb.setCharAt(sb.length()-1,'}');
        return sb.toString();

    }

    public static void main(String[] args) {
        TestHashMap<Integer,String> testHashMap = new TestHashMap<>();
        testHashMap.put(10,"AA");
        testHashMap.put(20,"BB");
        testHashMap.put(30,"CC");
        testHashMap.put(20,"GG");
        testHashMap.put(30,"MM");

        System.out.println(testHashMap);
        System.out.println(testHashMap.get(30));


    }
}
