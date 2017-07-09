package mycode.day07;

/**
 * Created by ls on 17-7-3.
 * 2.分析以下需求，并用代码实现：
 (1)倒着打印九九乘法表
 */
public class Task_2 {
    public static void main(String[] args){
        print99Mult();
    }

    private static void print99Mult() {
        for (int i = 9; i > 0; i--) {
            for (int j = 9; j > 0; j--) {
                if(j<i){
                    break;
                }
                System.out.print(j+" * "+i+" = "+j*i+"   ");
            }
            System.out.println();
        }
    }
}
