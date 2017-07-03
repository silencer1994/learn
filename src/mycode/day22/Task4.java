package mycode.day22;

import java.io.File;
import java.util.Scanner;

/**
 * Created by ls on 17-7-2.
 * 4.从键盘接收一个文件夹路径,把文件夹中的所有文件以及文件夹的名字按层级打印
 */
public class Task4 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(true){
            File path = new File(scanner.nextLine());
            if(path.getName().equals("exit")){
                System.exit(0);
            }
            if(!path.exists()){
                System.out.println("此文件不存在");
            }else {
               System.out.println(listFiles(path, 0));
            }
        }

    }

    private static String listFiles(File path, int level) {
        StringBuffer result = new StringBuffer();
        File[] allFiles = path.listFiles();
        for (File allFile : allFiles) {
            if(allFile.isDirectory()){
                StringBuffer buffer = new StringBuffer();
                for (int i = 0; i < level; i++) {
                    buffer.append("   ");
                }
                result.append(buffer+allFile.getName()+"\n");
                result.append(listFiles(allFile,++level));
            }else{
                StringBuffer buffer = new StringBuffer();
                for (int i = 0; i < level; i++) {
                    buffer.append("   ");
                }
                result.append(buffer+allFile.getName()+"\n");
            }
        }
        return result.toString();
    }


}
