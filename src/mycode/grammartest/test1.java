package mycode.grammartest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ls on 17-7-3.
 */
public class test1 {
    public static void main(String[] args){
        funcation_1();
    }

    private static void funcation_1() {
        Map<String, Integer> map = new HashMap<>();
        int a = map.get("a");
        System.out.println(a);
    }
}
