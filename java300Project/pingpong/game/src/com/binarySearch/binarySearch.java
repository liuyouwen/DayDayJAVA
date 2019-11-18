package com.binarySearch;

import java.util.Arrays;

/**
 * @ClassName binarySearch
 * @Description //TODO
 * @Author liuyw25167
 * @Date 2019-11-18 9:01
 * @Version 1.0
 **/
public class binarySearch {

    public static int binarySearMethod(int[] arr,int target){
        int low = 0;
        int high = arr.length-1;
        while(low <= high){
            //地板除
            int mid = (low+high)/2;
            if(arr[mid] == target){
                return mid;
            }
            if(arr[mid] > target){
                high = mid -1;
            }
            if(arr[mid] < target){
                low = mid + 1;
            }
        }
        //循环结束未找到
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {10,9,20,40,69,76,55,88,98};
        int search = 88;
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(binarySearMethod(arr, search));
    }
}
