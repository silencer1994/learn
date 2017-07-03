package mycode.day03;

import java.util.Scanner;

/**
 * Created by ls on 17-7-3.
 * 13.键盘录入三个整数，并将三个数据中的最大值打印在控制台。
 */
public class Task6 {
    public static void main(String[] args){
        printMax();
    }

    private static void printMax() {
        int x = new Scanner(System.in).nextInt();
        int y = new Scanner(System.in).nextInt();
        int z = new Scanner(System.in).nextInt();
        System.out.println(Math.max(z,Math.max(x,y)));
    }
}
