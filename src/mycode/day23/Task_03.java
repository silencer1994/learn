package mycode.day23;

import java.io.*;
import java.util.Calendar;
import java.util.Scanner;

/**
 * Created by ls on 17-7-10.
 * 2.获取指定目录及子目录下所有txt文件的个数，并将这些txt文件复制到D盘下任意目录
 */
public class Task_03 {
    public static void main(String[] args){
        String dirFrom = new Scanner(System.in).next();
        String dirTo = new Scanner(System.in).next();
        reciveCopy(dirFrom,dirTo);
    }

    private static void reciveCopy(String dirFrom,String dirTo) {
        File from = new File(dirFrom);
        File to = new File(dirTo);
        if(!from.exists()){
            throw new RuntimeException("输入的来源文件夹有误,请确认后重新输入");
        }
        if(!to.exists()){
            to.mkdirs();
        }
        File[] files = from.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".jpg");
            }
        });
        for (File file : files) {
            long startTime = Calendar.getInstance().getTimeInMillis();
            copyFile(file,to);
            long endTime = Calendar.getInstance().getTimeInMillis();
            System.out.println("复制总共用时"+(endTime-startTime));
        }

    }

    public static void copyFile(File file,File to) {
        if(file.isDirectory()){
            reciveCopy(file.getAbsolutePath(),to.getAbsolutePath()+File.separator+file.getName());
            return;
        }
        InputStream ins = null;
        OutputStream ous = null;

        try {
            ins = new FileInputStream(file);
            ous = new FileOutputStream(to.getAbsolutePath()+File.separator+file.getName());
            System.out.println("我开启了流准备将"+file.getAbsolutePath()+"  复制到  "+to.getAbsolutePath()+File.separator+file.getName());
            int len = 0;
            byte[] bytes = new byte[2048];
            while ((len = ins.read(bytes)) != -1) {
                ous.write(bytes,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                ous.close();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    ins.close();
                    System.out.println("关闭输入输出流");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
