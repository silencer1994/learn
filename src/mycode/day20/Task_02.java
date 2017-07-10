package mycode.day20;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ls on 17-7-10.
 * 	(1)利用键盘录入，输入一个字符串
 (2)统计该字符串中各个字符的数量
 (3)如：
 用户输入字符串"If~you-want~to~change-your_fate_I_think~you~must~come-to-the-dark-horse-to-learn-java"
 程序输出结果：-(9)I(2)_(3)a(7)c(2)d(1)e(6)f(2)g(1)h(4)i(1)j(1)k(2)l(1)m(2)n(4)o(8)r(4)s(2)t(8)u(4)v(1)w(1)y(3)~(6)
 */
public class Task_02 {
    public static void main(String[] args){
        funcation_1();
    }

    private static void funcation_1() {
//        String str = new Scanner(System.in).nextLine();
        String str2 = "If~you-want~to~change-your_fate_I_think~you~must~come-to-the-dark-horse-to-learn-java";
        char[] chars = str2.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char aChar : chars) {
            if(map.get(aChar)==null){
                map.put(aChar, 1);
            }else {
                //不允许有重复元素但是value值会被覆盖掉
                map.put(aChar, map.get(aChar) + 1);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<Character, Integer> characterIntegerEntry : map.entrySet()) {
            stringBuilder.append(characterIntegerEntry.getKey() + "(" +characterIntegerEntry.getValue()+ ")");
        }
        System.out.println(stringBuilder.toString());
    }
}
