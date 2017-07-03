package mycode.day22;

import java.io.File;
import java.util.Scanner;

/**
 * Created by ls on 17-7-2.
 * 2.从键盘接收一个文件夹路径,统计该文件夹大小。
 */
public class Task2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(true){
            String path = scanner.nextLine();

            if(path.equals("exit")){
                System.exit(0);
            }
            long size = getFileSize(path);
            if(size == -1)
                System.out.println("此文件不存在");
            else
                System.out.println("此文件夹的大小为: "+size+"字节");
        }

    }

    private static long getFileSize(String path) {
        File file = new File(path);
        if(!file.exists()){
            return -1;
        }
        return file.length();
    }
}

