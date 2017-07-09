package mycode.day15;

import java.util.ArrayList;

/**
 * Created by ls on 17-7-8.
 */
public class Test01 {
    public static void main(String[] args) {
//        demo1();
//        demo2();
//        demo3();
        demo4();
        demo5();
    }
    private static void demo5() {
        String s1 = "ab";
        String s2 = "abc";
        String s3 = s1 + "c";
        System.out.println(s3 == s2);
        System.out.println(s3.equals(s2)); 		//true
    }
    private static void demo4() {
        //byte b = 3 + 4;						//在编译时就变成7,把7赋值给b,常量优化机制
        String s1 = "a" + "b" + "c";//java中有常量优化机制,在编译时期就能确定s2的值为"abc",所以编译时期,在常量池中创建"abc"
        String s2 = "abc";//执行到这里时常量池中已经有了"abc",所以就不再创建,所以s1和s2指向的是常量池中同一个字符串常量"abc"
        System.out.println(s1 == s2); 			//true,java中有常量优化机制
        System.out.println(s1.equals(s2)); 		//true
    }
    private static void demo3() {//==比较的是地址值
        String s1 = new String("abc");			//录的是堆内存对象的地址值
        String s2 = "abc";						//记录的是常量池中的地址值
        System.out.println(s1 == s2); 			//false
        System.out.println(s1.equals(s2)); 		//true
    }
    private static void demo2() {
        //创建几个对象
        //创建两个对象,一个在常量池中,一个在堆内存中
        String s1 = new String("abc");
        System.out.println(s1);
    }
    private static void demo1() {				//常量池中没有这个字符串对象,就创建一个,如果有直接用即可
        String s1 = "abc";
        String s2 = "abc";
        System.out.println(s1 == s2); 			//==号比较的是地址值,true
        System.out.println(s1.equals(s2)); 		//比较的是字符串的内容:true
    }
}