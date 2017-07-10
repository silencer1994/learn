package mycode.grammartest;

import java.io.*;

/**
 * Created by ls on 17-7-10.
 */
public class Test2 {
    public static void main(String[] args){
//        catch01();
        fileName();
    }

    private static void fileName() {
        File file = new File("/home/ls/unzip");
        System.out.println(file.getName());
    }

    private static void catch01() {
        InputStream ins = null;
        try {
//            String str = null;
//            str.length();
            ins = new FileInputStream("/home/ls");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                System.out.println("我要关流");
                ins.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                System.out.println("不管怎么样我都把输入流给关闭了");
            }
        }
    }
}
