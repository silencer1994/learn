package mycode.day24;

import java.io.*;

/**
 * Created by ls on 17-7-13.
 * 3.利用转换流将GBK格式文件以UTF-8输出
 */
public class Task_02 {
    public static void main(String[] args) {
//        readWrite();
        try {
            changeEncoding("GBK","UTF-8","/home/ls/black1/Car.java","/home/ls/test/a.java");
        } catch (IOException e) {
            System.out.println("发生了错误");
            e.printStackTrace();
        }
    }

    public static void changeEncoding(String inEncoding, String outEncoding, String inFileName, String outFileName) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inFileName), inEncoding));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFileName), outEncoding));
        String s = null;
        while ((s = reader.readLine()) != null) {
            writer.write(s, 0, s.length());
            writer.newLine();
            writer.flush();
        }
        writer.close();
        reader.close();
    }

    private static void readWrite() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("/home/ls/black1/*.java");
            fos = new FileOutputStream("/home/ls/test.a.java");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
