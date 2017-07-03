package mycode.day22;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by ls on 17-7-2.
 * 1.使用文件名称过滤器筛选将指定文件夹下的小于200K的小文件获取并打印。
 */
public class Task1 {
    public static void main(String[] args){
        File[] validFiles = fileFillter("/home/ls/test");
        printFilesContent(validFiles);
    }

    private static void printFilesContent(File[] validFiles) {
        if(validFiles == null){
            System.out.println("对不起,此路径下无有效数据.");
        }else {
            for (File validFile : validFiles) {
                FileInputStream ins = null;
                int len = 0;
                byte[] bytes = new byte[1024];
                StringBuffer stringBuffer = new StringBuffer();
                try {
                    ins = new FileInputStream(validFile);
                    while ((len = ins.read(bytes))!=-1){
                        String string = new String(bytes,0,len);
                        stringBuffer.append(string);
                    }
                    System.out.println(stringBuffer.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    try {
                        ins.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }

    private static File[]  fileFillter(String s) {
        File file = new File(s);
        File[] rFiles = null;
        int rFileSize = 0;
        if(file.exists()){
            if(file.isDirectory()){
                rFiles = getAllTxt(file);
                return rFiles;
            }else {
                if(file.getName().endsWith(".txt")){
                    if(file.length()>=(200*1024)){
                        rFileSize = 1;
                        rFiles = new File[rFileSize];
                        rFiles[rFileSize - 1] = file;
                        return rFiles;
                    }else {
                        return rFiles;
                    }
                }else {
                    return rFiles;
                }
            }
        }else{
            return rFiles;
        }
    }

    /**
     * 获得所有后缀名称为txt的文件，并且大小小于200K
     * @param file
     * @return
     */
    private static File[] getAllTxt(File file) {
        File[] rFiles = null;
        ArrayList<File> validFile = null;
        File[] allFiles = file.listFiles();
        if(allFiles.length == 0){
            return rFiles;
        }else {
            validFile = new ArrayList<>();
            for (File allFile : allFiles) {
                if(allFile.getName().endsWith(".txt")&&allFile.length()<(200*1024)){
                    validFile.add(allFile);
                }
            }
            rFiles = validFile.toArray(new File[validFile.size()]);
            return rFiles;
        }
    }


}