package com.testClimbLadders;

/**
 * @ClassName testClimbLadders
 * @Description //有n阶台阶，上楼可以一步上1阶,2阶，3阶，编程序计算共有多少种不同的走法；
 *                递归、动态规划(用数组)、迭代（不用数组）实现
 * @Author
 * @Date 2019-11-19 20:23
 * @Version 1.0
 **/
public class testClimbLadders {
    public static void main(String[] args) {
        int mm = 40;
        long time1 = System.currentTimeMillis();
        System.out.println(countWays1(mm));
        long time2 = System.currentTimeMillis();
        System.out.println("递归方式耗时"+(time2-time1)+"ms");

        long time3 = System.currentTimeMillis();
        System.out.println(countWays2(mm));
        long time4 = System.currentTimeMillis();
        System.out.println("递归方式耗时"+(time4-time3)+"ms");

        long time5 = System.currentTimeMillis();
        System.out.println(countWays3(mm));
        long time6 = System.currentTimeMillis();
        System.out.println("递归方式耗时"+(time6-time5)+"ms");
    }

    /**
     * 递归方法
     * @param n
     * @return
     */
    private static long countWays1(int n){
        if(n <= 0){
            return 0;
        }else if(n == 1){
            return 1;
        }else if(n == 2){
            return 2;
        }else if(n == 3){
            return 4;
        }else {
            return countWays1(n-1) + countWays1( n-2)+countWays1(n-3);
        }
    }

    /**
     * 动态规划法 (利用数组来存储);当一个问题可以分解成若干重复的子问题时，运用动态规划的思想;
     * 子问题的中间计算结果保存，避免每次递归去重复计算
     * @param n
     * @return
     */
    private static long countWays2(int n){
        long[] arr = new long[n+1];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;
        for(int i =4;i<=n;i++){
            arr[i] = arr[i-1] +arr[i-2] +arr[i-3];
        }
        return arr[n];
    }

    /**
     * 不使用数组保存中间结果，降低空间复杂度
     * @param n
     * @return
     */
    private static long countWays3(int n){
        long num1 = 1;
        long num2 = 2;
        long num3 = 4;
        for(int i=4; i<=n; i ++){
            //通过变量交换的形式实现,f(n)=f(n-1)+f(n-2)+f(n-3)状态转移方程
            long tmp = num3 + num2 +num1;
            long tmp1 = num3;
            long tmp2 = num2;
            num3 = tmp;
            num2 = tmp1;
            num1 =tmp2;
        }
        return num3;
    }

}

