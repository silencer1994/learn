package mycode.day19;

/**
 * Created by ls on 17-7-10.
 * 将"goOd gooD stUdy dAy dAy up"
 每个单词的首字母转换成大写其余还是小写字母(不许直接输出good good study day day up 要用代码实现)
 */
public class Task_03 {
    public static void main(String[] args){
        printSlogan();
    }

    private static void printSlogan() {
        String slogan = "good good study day day up";
        String[] splits = slogan.split(" ");
        slogan = "";
        for (int i = 0; i < splits.length; i++) {
            char[] chars = splits[i].toCharArray();
            if(chars[0]>='a'&&chars[0]<='z'){
                chars[0] -= 32;
            }
            splits[i] = new String(chars);
            slogan = slogan + splits[i] + " ";
        }
//        try {
//            slogan = new String(slogan.getBytes(), "utf-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
        System.out.println(slogan);

    }
}
