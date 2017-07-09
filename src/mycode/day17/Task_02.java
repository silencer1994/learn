package mycode.day17;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;

/**
 * Created by ls on 17-7-8.
 * 1 1 2 3 5 8 13 21
 */
public class Task_02 {
    public static void main(String[] args){
        long startTime = Calendar.getInstance().getTimeInMillis();
        long count = 8l;
        BigInteger sum = getSum(count);
        long endTime = Calendar.getInstance().getTimeInMillis();
        System.out.println("第"+count+"次循环的总和是"+sum+",总共用时:"+(endTime-startTime));
    }

    private static BigInteger getSum(long count) {
//        BigInteger sum = new BigInteger(0);
        BigInteger sum = new BigInteger("0");
        BigInteger sum_1 = new BigInteger("1");
        BigInteger sum_2 = new BigInteger("1");

//        long sum_1 = 1;
//        long sum_2 = 1;
        for (long i = 1; i <= count; i++) {
            if(i==1|i==2){
                sum.add(BigInteger.valueOf(1));
//                sum += 1;
//                sum_1 = 1;
//                sum_2 = 1;
            }else {
                sum = sum_1.add(sum_2);
                sum_2 = sum_1;
                sum_1 = sum;
            }
        }
        return sum;
    }
}
