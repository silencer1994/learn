package mycode.day07;

/**
 * Created by ls on 17-7-5.
 * (1) 计算15+25+35+....+1005的和
 */
public class Task_4 {
    public static void main(String[] args){
        int sum = 0;
        for (int i=15;i<=1005;i+=10){
//        for (int i=15;i<=15;i+=10){
            sum += i;
        }
        System.out.println(sum);

        int sum2 = 0;
        for (int a = 5 ; a <= 1005 ; a += 10){
            sum2 += a;
        }
        System.out.println("黑马sum: "+sum);
    }
}
