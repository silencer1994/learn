package mycode.day06;

import javax.swing.text.InternationalFormatter;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by ls on 17-7-3.
 */
public class Task1 {
    public static void main(String[] args){
        test_1();
    }

    private static void test_1() {
        ArrayList arr = new ArrayList();
//        arr.add("刘双");
//        arr.add("江航");
//        arr.add("李亚娟");
//        arr.add("贲驰");
//        arr.add("杨莹");
//        arr.add("王超");
        Iterator iterator = arr.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
