package mycode.day19;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * Created by ls on 17-7-8.
 */
public class Task_01 {
//    	(1)有如下代码：
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("f");
        list.add("b");
        list.add("b");
        list.add("b");
        list.add("b");
        list.add("c");
        list.add("c");
        list.add("c");
        list.add("a");
        list.add("d");
        list.add("ls");
        list.add("LOL");
        uniq(list);
    }

    private static void uniq(List<String> list) {
        HashSet<String> map = new HashSet<>();
        for (String s : list) {
            map.add(s);
        }
        list.clear();
        Iterator<String> iterator = map.iterator();
        while(iterator.hasNext()){
            list.add(iterator.next());
        }
        System.out.println(list);
    }
//        (2)利用HashSet对list集合去重(最终结果:list中没有重复元素)
}
