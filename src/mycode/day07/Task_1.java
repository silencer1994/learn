package mycode.day07;

/**
 * Created by ls on 17-7-3.
 * 1.分析以下需求，并用代码实现：
 (1)按照从大到小的顺序输出四位数中的个位+百位=十位+千位(3553,2332,1166,8228,3773)的数字及个数
 (2)每行输出5个满足条件的数，之间用空格分隔
 (3)如：9999 9988 9977 9966 9955

 */
public class Task_1 {
//    特定
    public static void main(String[] args){
        printSpecificNumber(1000,9999);
    }
    
    private static void printSpecificNumber(int start, int end) {
        int count = 0;
        for (int i = start; i <= end; i++) {
            //todo 刘双你这里的逻辑是错误的
            if(((i%1000/100)+(i%10))==((i%100/10)+(i/1000))){
                System.out.print(i+"   ");
                count++;
                if(count%5==0){
                    System.out.println();
                }
            }
        }
    }
}
