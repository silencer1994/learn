package mycode.day22;

import java.io.File;
import java.util.*;

/**
 * Created by ls on 17-7-3.
 */
public class Task5 {
    private static Map<String,Integer> fileType = new HashMap<>();
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
               String result = listFiles(path, 0);
               //遍历HashMap
                IteratorKey();
                IteratorEntity();
//                System.out.println(result);
            }
        }

    }

    /**
     * ͨ通过Entity遍历HashMap
     */
    private static void IteratorEntity() {
        for (Map.Entry<String, Integer> entry : fileType.entrySet()) {
            System.out.println(entry.getKey()+"..."+entry.getValue());
        }
    }

    /**
     * ͨ通过key遍历HashMap
     */
    private static void IteratorKey() {
        for (String s : fileType.keySet()) {
            System.out.println(s+"  "+fileType.get(s));
        }
    }

    private static String listFiles(File path, int level) {
        StringBuffer result = new StringBuffer();
        File[] allFiles = path.listFiles();
        for (File allFile : allFiles) {
            if(allFile.isDirectory()){
                if(fileType.get("directory")==null){
                    fileType.put("directory",1);
                }else{
                    fileType.put("directory", fileType.get("directory")+1);
                }
                StringBuffer buffer = new StringBuffer();
                for (int i = 0; i < level; i++) {
                    buffer.append("   ");
                }
                result.append(buffer+allFile.getName()+"\n");
                result.append(listFiles(allFile,++level));
            }else{
                //获得文件名称
//                System.out.println(allFile.getName());
                // TODO: 17-7-3  这里切割的时候需要进行转义操作
                String[] split = allFile.getName().split("\\.");
                String suffix = split[split.length-1];
                if(fileType.get(suffix)==null){
                    fileType.put(suffix,1);
                }else{
                    fileType.put(suffix, fileType.get(suffix)+1);
                }
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
