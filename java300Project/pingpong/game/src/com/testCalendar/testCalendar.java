package com.testCalendar;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * @ClassName testCalendar
 * @Description //输入一个字符串，根据此生成当月日历
 * @Author liuyw25167
 * @Date 2019-11-19 9:18
 * @Version 1.0
 **/
public class testCalendar {
    public static void main(String[] args) throws ParseException {
        System.out.print("请输入一个日期：格式为(2019-11-19)");
        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.nextLine();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = df.parse(inputStr);
        //###转成date对象，再转成日历类
        Calendar c = new GregorianCalendar();
        c.setTime(date);

        int initWeekday = c.get(Calendar.DAY_OF_WEEK);
        int initDay = c.get(Calendar.DAY_OF_MONTH);
        int maxDays = c.getActualMaximum(Calendar.DATE);
        //打印日历头
        System.out.println("日\t一\t二\t三\t四\t五\t六");

        c.set(Calendar.DAY_OF_MONTH,1);
        //处理第一个日期前面的空格
        for(int i=0;i< initWeekday-1;i++) {
            System.out.print("\t");
        }

        //循环从当月第一天开始
        for(int ii=0;ii<maxDays;ii++) {
            if(c.get(Calendar.DAY_OF_MONTH)==initDay){
                System.out.print(c.get(Calendar.DAY_OF_MONTH)+"*\t");
            }else{
                System.out.print(c.get(Calendar.DAY_OF_MONTH)+"\t");
            }

            if(c.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY){
                System.out.println();
            }
            c.add(Calendar.DAY_OF_MONTH,1);
        }
    }

}
