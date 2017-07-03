package mycode.day03;

import sun.nio.ch.sctp.SctpNet;

import java.util.Scanner;

/**
 * Created by ls on 17-7-3.
 * 12.需求：
 * 键盘录入x的值，计算出y的并输出。
 * x>=3	y = 2 * x + 1;
 * -1<x<3	y = 2 * x;
 * x<=-1	y = 2 * x - 1;
 */
public class Task5 {
    public static void main(String[] args){
        int x= new Scanner(System.in).nextInt();
        System.out.println((x >= 3 ? 2 * x + 1: x > -1 ? 2 * x : 2 * x - 1));
    }
}
