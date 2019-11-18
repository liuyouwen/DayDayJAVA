package com.BubbleSort;

import java.util.Arrays;

/**
 * @ClassName bubbleSort
 * @Description //冒泡排序及其优化；增加flag标志，否则至少需循环找最大值 arr.length-1次
 * @Author liuyw25167
 * @Date 2019-11-15 9:15
 * @Version 1.0
 **/
public class bubbleSort {
    public static void main(String[] args) {
        int[] arr = {2,1,3,5,6,4,9,8,7};
        bubbleSortMethod(arr);

    }
    public static void bubbleSortMethod(int[] arr){  //static方法中不可直接访问非static的成员,所以必须加static
        for (int i=0;i<arr.length-1;i++){
            boolean flag = true;
            for(int j=0; j<arr.length-1 -i ;j++) {
                if(arr[j] > arr[j+1]) {
                    int tmp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = tmp;
                    //本趟发生了交换，表明该数组在本趟处于无序状态，需要继续比较
                    flag = false;
                }
            }
            if(flag){
                break;
            }
            System.out.println(Arrays.toString(arr));
            System.out.println("第"+ i +"次循环");
        }

    }
}


/** 这样一个循环找出里面最大值；冒泡是依次找出9个数中找出最大值9,8个值中找出最大值8, 外层加循环,内层依次减少循环次数
 * for(int j=0; j<arr.length-1 ;j++){
 if(arr[j] > arr[j+1]){
 int tmp = arr[j+1];
 arr[j+1] = arr[j];
 arr[j] = tmp;
 }
 }
 */
