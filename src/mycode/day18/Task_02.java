package mycode.day18;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.sort;

/**
 * Created by ls on 17-7-8.
 */
public class Task_02 {
//    public static void main(String[] args){
//        (1)有如下代码：
        public static void main(String[] args) {
            List<String> list = new ArrayList<>();
            list.add("b");
            list.add("f");
            list.add("e");
            list.add("c");
            list.add("a");
            list.add("d");
            sort(list);
            System.out.println(list);	// a, b, c, d, e, f
        }
//        (2)要求对集合中添加的元素排序

}
