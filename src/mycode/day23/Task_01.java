package mycode.day23;

import java.io.*;
import java.util.Calendar;
import java.util.Scanner;

/**
 * Created by ls on 17-7-10.
 * 1.从键盘接收两个文件夹路径,把其中一个文件夹中(包含内容)拷贝到另一个文件夹中
 */
public class Task_01 {
    public static void main(String[] args) {
        reciveCopy();
    }

    private static void reciveCopy() {
        String dir1 = new Scanner(System.in).next();
        String dir2 = new Scanner(System.in).next();

        InputStream ins = null;
        OutputStream ous = null;

        File file = new File(dir2);
        // TODO: 17-7-10  注意 Stream并不会为你创建文件夹...
        if(!file.exists()){
            File pFile = file.getParentFile();
            if(!pFile.exists()){
                pFile.mkdirs();
            }
        }
        try {
            ins = new FileInputStream(dir1);
            ous = new FileOutputStream(file);
            int len = 0;
            byte[] bytes = new byte[2048];
            long startTime = Calendar.getInstance().getTimeInMillis();
            while ((len = ins.read(bytes)) != -1) {
                ous.write(bytes,0,len);
            }
            long endTime = Calendar.getInstance().getTimeInMillis();
            System.out.println("总计用时"+(endTime-startTime));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                ous.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    ins.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
