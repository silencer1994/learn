package mycode.grammartest;

import java.util.Random;

/**
 * Created by ls on 17-7-3.
 */
public class Demo
{
    public static void main(String[] args)
    {
//        testCodeStyle();
//        testForBeark();
        testCalculate();
    }

    private static void testCalculate() {
                int x = 4;
                int y = (--x)+(x--)+(x*10);//26
                System.out.println("x = " + x + ",y = " + y);
    }


    private static void testForBeark() {
        uFor:for (int i = 0; i < 3; i++) {
            iFor:
            for (int j = 0; j < 9; j++) {
                if (j == 3) {
                    continue uFor;
                } else
                    System.out.println(j);
            }
        }
    }

    private static void testCodeStyle() {
        System.out.println(15);
        System.out.println(0B1111);
        System.out.println(0xF);
        System.out.println(017);
        System.out.println(true);
        System.out.println(false);
    }
}
