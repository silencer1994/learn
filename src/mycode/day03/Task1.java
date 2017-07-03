package mycode.day03;

/**
 * Created by ls on 17-7-3.
 * 7.计算1-100之间的质数有多少个？将质数以及质数总数打印在控制台。
 */
public class Task1 {
    public static void main(String[] args){
//        printPrime(101);
        blackCode(100);
    }

    /**
     * 这种写法的好处是排除了2这种情况
     * @param i
     */
    private static void blackCode(int i) {
        System.out.println(1);
        for (int a = 1 ;  a <=i ; a++){
            int b = 2;
            while(b < a){
                if (a % b == 0){
                    break;
                }
                b++;
            }
            if(a == b){
                System.out.println(b);
            }
        }
    }

    /**
     * 输出count之前的质数
     * @param count
     */
    private static void printPrime(int count) {
        for (int i = 1; i <= count; i++) {
            if(i==1|i==2){
                System.out.println(i);
            }else{
                boolean isPrime = true;
                for (int j = 2;  j< i; j++) {
                    if(i%j==0){
                        isPrime = false;
                        break;
                    }
                }
                if(isPrime){
                    System.out.println(i);
                }
            }
        }
//        if(count==1){
//            System.out.println(count);
//        }else {
//            for (int i = 2; i < count; i++) {
//                
//            }
//        }

    }
}
