package mycode.day15;

import java.util.Scanner;

/**
 * Created by ls on 17-7-8.
 * 5.分析以下需求，并用代码实现：
 (1)从键盘循环录入录入一个字符串,输入"end"表示结束
 (2)定义一个方法
 public Object[] deleteSubString(String str1,String str2) {

 }
 (3)方法功能描述:从str1中删除所有的str2,并返回删除后的结果,返回结果为Object[]数组
 * 该数组的第一个元素为删除所有的str2后的最终的字符串
 * 该数组的第二个元素为删除的str2的个数
 */
public class Task_4 {
    public static void main(String[] args){
        funcation_1();
    }

    private static void funcation_1() {
        String str1 = new Scanner(System.in).nextLine();
        String str2 = new Scanner(System.in).nextLine();
        int hasStr2 = -1;
        int count = 0;
        while((hasStr2=str1.indexOf(str2))!=-1){
            char[] chars = str1.toCharArray();
            String str1For = new String(chars,0,hasStr2);
             String str1End = new String(chars,hasStr2+str2.length(),chars.length-(hasStr2+str2.length()))  ;
//             System.out.println(str1For);
//             System.out.println(str1End);
            str1 = str1For + str1End;
            count++;
//            System.out.println(str1);
        }
        System.out.println(str1);
        System.out.println("一共删除了"+count+"个"+str2);
    }
}
