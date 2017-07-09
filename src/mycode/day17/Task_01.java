package mycode.day17;

import java.util.Calendar;

/**
 * Created by ls on 17-7-8.
 * 1.用循环实现不死神兔
 故事得从西元1202年说起，话说有一位意大利青年，名叫斐波那契。
 在他的一部著作中提出了一个有趣的问题：假设一对刚出生的小兔一个月后就能长成大兔，
 再过一个月就能生下一对小兔，并且此后每个月都生一对小兔，一年内没有发生死亡，
 问：一对刚出生的兔子，一年内繁殖成多少对兔子?

 1 1 2 3 5 8 13 21

 2.第100个月繁殖多少对兔子?(利用BigInteger完成)
 */
public class Task_01 {
    public static void main(String[] args){
        long startTime = Calendar.getInstance().getTimeInMillis();
        long count = 50l;
        long sum = recursion(count);
        long endTime = Calendar.getInstance().getTimeInMillis();
        System.out.println("第"+count+"次循环的总数是"+sum+",总共用时:"+(endTime-startTime));
    }

    private static long recursion(long count) {
        if(count==2|count==1){
            return 1;
        }else {
//            System.out.println(recursion(count-1));
            return recursion(count - 1) + recursion(count-2);
        }
    }
}
