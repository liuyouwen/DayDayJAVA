package com.testString;

/**
 * @ClassName testString
 * @Description //TODO
 * @Author liuyw
 * @Date 2019-11-13 21:21
 * @Version 1.0
 **/
public class testString {
    public static void main(String[] args) {
        String s1 = "core Java";
        String s2 = "Core Java";
        System.out.println(s1.charAt(3));
        System.out.println(s2.length());
        System.out.println(s1 == s2);
        //比较两个字符串是否相等
        System.out.println(s1.equals(s2));
        System.out.println(s1.equalsIgnoreCase(s2));
        System.out.println(s1.indexOf("JAVA"));
        String s =s1.replace(' ','&');
        System.out.println("result is:"+ s);

        String s3 = "";
        //""是String；''是char
        String s4 = "How are you?";
        System.out.println(s4.startsWith("How"));
        System.out.println(s4.endsWith("you"));
        s3 = s4.substring(4);
        System.out.println(s3);
        //[4,7)
        s3 = s4.substring(4,7);
        System.out.println(s3);
        s3 = s4.toLowerCase();
        System.out.println(s3);
        String s5 = "How are you?   ";
        s3 = s5.trim();
        System.out.println(s3);
    }
}
