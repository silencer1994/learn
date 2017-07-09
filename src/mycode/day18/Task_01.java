package mycode.day18;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ls on 17-7-8.
 *
 */
public class Task_01 {
    public static void main(String[] args){
//        1.分析以下需求，并用代码实现：
//        (1)有如下代码：
        List<String> list = new ArrayList<>();

        list.add("a");
        list.add("a");
        list.add("a");
        list.add("b");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("d");
        list.add("d");
        list.add("d");
        list.add("d");

        System.out.println(frequency(list, "a"));	// 3
        System.out.println(frequency(list, "b"));	// 2
        System.out.println(frequency(list, "c"));	// 1
        System.out.println(frequency(list, "d"));	// 5
        System.out.println(frequency(list, "xxx"));	// 0
//        (2)定义方法统计集合中指定元素出现的次数，如"a" 3,"b" 2,"c" 1
    }

    private static int frequency(List<String> list, String a) {
        int sum = 0;
        for (String s : list) {
            if (s.equals(a)){
                sum++;
            }
        }
        return sum;
    }
}
