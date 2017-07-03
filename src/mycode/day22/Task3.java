package mycode.day22;

import java.io.File;
import java.util.Scanner;

/**
 * Created by ls on 17-7-2.
 * 3.从键盘接收一个文件夹路径,删除该文件夹。
 */
public class Task3 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(true){
            File path = new File(scanner.nextLine());
            if(path.getName().equals("exit")){
                System.exit(0);
            }
            long size = getFileSize(path);
            if(size == -1)
                System.out.println("此文件不存在");
            else{
                System.out.println("此文件夹的大小为: "+size+"字节");
                boolean isDelete = path.delete();
                System.out.println("删除文件: "+isDelete);
            }

        }

    }

    private static long getFileSize(File file) {
        if(!file.exists()){
            return -1;
        }
        return file.length();
    }
}
