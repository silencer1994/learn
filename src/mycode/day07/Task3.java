package mycode.day07;

/**
 * Created by ls on 17-7-4.
 * (1)倒着打印九九乘法表
 */
public class Task3 {
    public static void main(String[] args){
        printMulite(9,9);
    }
    
    private static void printMulite(int row,int clo) {
        for (int i = row; i >= 1; i--) {
            for (int j = clo; j > 1; j--) {
                if(j<i){
                    break;
                }
                System.out.print(j+"*"+i+"="+j*i+"   ");
            }
            System.out.println();
        }
    }
}
