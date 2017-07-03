package mycode.day03;

/**
 * Created by ls on 17-7-3.
 */
public class Task3 {
    public static void main(String[] args){
//        printJava1();
//        printJava2();
        printJava3();
    }

    private static void printJava3() {
        for (int x = 1; x <= 10; x++) {
            if (x % 3 == 0) {
                System.out.println("Java基础班");
            }
            System.out.println("Java基础班");
        }
//        我想在控制台输出13次:“Java基础班“
    }

    private static void printJava2() {
        for (int x = 1; x <= 10; x++) {
            if (x % 3 == 0) {
                continue;
            }
            System.out.println("Java基础班");
        }
//        我想在控制台输出7次:“Java基础班“
    }

    private static void printJava1() {
        for(int x=1; x<=10; x++) {
            if(x%3==0) {
                if (x / 3 == 1){
                    break;
                }
            }
            System.out.println("Java基础班");
        }

//        我想在控制台输出2次:“Java基础班“
    }
}
