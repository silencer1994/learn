package mycode.day25;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Properties;

/**
 * Created by ls on 17-7-14.
 */
public class Task_02 {
    public static void main(String[] args){
//        function_01();
//        function_02();
//        function_03();
        System.out.println(0x100);
    }

    private static void function_03() {
        Properties properties = new Properties();
//        properties.setProperty(null, "a");
//        properties.setProperty("a", null);


        System.out.println(properties);
    }

    private static void function_02() {
        Hashtable<String, String> table = new Hashtable<>();
//        table.put(null, "a");
        table.put("null", "b");
        table.put("b", "null");
//        table.put("c", null);
        System.out.println(table);
    }

    private static void function_01() {
        HashMap<String, String> map = new HashMap<>();
//        map.put(null, "a");
//        map.put("a","b");
//        //相当于更新了里面的内容
//        map.put("a", null);
        map.put(null, "a");
        map.put("null", "b");
        map.put("b", null);
        map.put("c", null);
        System.out.println(map);
        System.out.println("----------------------------");
    }
}
