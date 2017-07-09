package mycode.day15;

/**
 * Created by ls on 17-7-5.
 * 	(1)定义数字字符串数组{"010","3223","666","7890987","123123"}
 (2)判断该数字字符串数组中的数字字符串是否是对称(第一个数字和最后一个数字相等，第二个数字和倒数第二个数字是相等的，依次类推)的，并逐个输出
 (3)如：010 是对称的，3223 是对称的，123123 不是对称的
 (4)最终打印该数组中对称字符串的个数

 提示：循环获取字符串的每一个字符，依次比较第一个和最后一个，第二个和倒数第二个。。。
 */
public class Task_2 {
    public static void main(String[] args){
        String[] num =
                {"010", "3223", "666", "7890987", "123123"};
//                {"123123"};
        task(num);
    }

    private static void task(String[] num) {
        for (String s : num) {
//            if(s.length()%2==0){
                int count = 0;
                for (int i=0;i<s.length()/2;i++){
                    if(s.charAt(i)==s.charAt(s.length()-1-i)){
                        count++;
                    }
                }
                System.out.println(s+"中相等的个数为"+count+"个");
//            }else {
//                //奇数的对比
//                int count = 0;
//                for (int i=0;i<s.length()/2;i++){
//                    if(s.charAt(i)==s.charAt(s.length()-1-i)){
//                        count++;
//                    }
//                }
//                System.out.println(s+"中相等的个数为"+count+"个");
//            }
        }
    }
}
