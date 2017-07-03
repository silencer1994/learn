package mycode.day03;

/**
 * Created by ls on 17-7-3.
 * 8.编写程序，打印1到100之内的整数，但数字中包含7的要跳过
 */
public class Task2 {
    public static void main(String[] args){
        skip7(100);
    }

    /**
     * 整数里面包含7就跳过
     * @param count
     */
    private static void skip7(int count) {
        for (int i = 1; i < count; i++) {
            String number = String.valueOf(i);
            if(number.contains("7")){
                System.out.println(i);
            }
        }
    }
}
