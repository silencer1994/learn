package mycode.day15;


import java.util.Scanner;

/**
 * Created by ls on 17-7-5.
 * 4.分析以下需求，并用代码实现：
 (1)从键盘循环录入录入一个字符串,输入"end"表示结束
 (2)将字符串中大写字母变成小写字母，小写字母变成大写字母，其它字符用"*"代替,并统计字母的个数
 举例:
 键盘录入：Hello12345World
 输出结果：hELLO*****wORLD
 总共10个字母
 */
public class Task_3 {
    public static void main(String[] args){
        //刘双啊,脑子一定要长全再去编写程序
        test();
    }

    private static void test() {
        String test = new Scanner(System.in).next();
        String newString = test.replaceAll("[\\d]", "*");
        char[] chars = newString.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i]>=65&&chars[i]<=91){
                //代表A-Z
                chars[i] += 32;
                continue;
            }
            if (chars[i]>=97&&chars[i]<=123){
                chars[i] -= 32;
                continue;
            }
        }
        System.out.println(new String(chars));
    }
}
