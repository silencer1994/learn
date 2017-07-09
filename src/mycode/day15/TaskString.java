package mycode.day15;

/**
 * Created by ls on 17-7-5.
 * 1.用代码演示String类中的以下方法的用法
 * (1)boolean isEmpty(): 判断字符串是不是空串,如果是空的就返回true
 * (2)char charAt(int index): 返回索引上的字符
 * (3)String toLowerCase(): 字符串转成小写
 * (4)String toUpperCase(): 字符串转成大写
 * (5)String repalce(char oldChar, char newChar): 将字符串中的老字符,替换为新字符
 * (6)String repalce(String old, String newstr): 将字符串中的老字符串,替换为新字符串
 * (7)String trim(): 去掉字符串两端空格
 */
public class TaskString {
    //    public static void main(String[] args){
//        testMethod();
//    }
//
//    private static void testMethod() {
//            String empty = "";
//            assert (true==empty.isEmpty());
//            String charAt = "liushuang";
////            System.out.println(charAt.charAt(2));
//            assert ("u".equals(charAt.charAt(2)+""));
//            String a = "abc";
//            assert ("ABC".equals(a.toUpperCase()));
//            String A = "ABC";
//            assert ("abc".equals(A.toLowerCase()));
//            String repalce = "liushuang";
//            assert ("liUshUang".equals(repalce.replace("u","U")));
//            String repalce2 = "aabbccaa";
//            assert ("AAbbccAA".equals(repalce2.replace("aa","AA")));
//            String trim = "  aa  ";
//            assert ("aa".equals(trim.trim()));
//    }
    public static void main(String[] args) {
        String str = getPropertyGetMethodName("ttttttt");
        System.out.println(str);
    }

    public static String getPropertyGetMethodName(String property) {
        String str = "get" + property.substring(0, 1).toUpperCase();
        System.out.println(str);
        str += property.substring(1, property.length());
        return str;
    }
}
