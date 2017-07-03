package mycode.day05;

/**
 * Created by ls on 17-7-3.
 * 打印nn乘法表
 */
public class Task1 {
    public static void main(String[] args){
        nnMult(9,9);
    }

    private static void nnMult(int n, int m) {
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(j+" * "+i+" = "+j*i+"   ");
            }
            System.out.println("\n");
        }
    }
}
