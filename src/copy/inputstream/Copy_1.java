package copy.inputstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by ls on 17-7-1.
 * 单字节流copy文件，熟悉流开与流闭的过程
 */
public class Copy_1 {
    public static void main(String[] args){
        funcation_1();

    }

    private static void funcation_1()  {
        //定义输入流与输出流
        FileInputStream ins = null;
        FileOutputStream ous = null;
        try{

        }
        ins = new FileOutputStream("/home/ls/copy/Mac.po");
        ous  = new FileInputStream("/home/ls/Mac.po");
        //读取字节的长度，读一次写一次
        int len = 0;
        while((len = ins.read()) != -1){
            ous.write(len);
        }
    }
}
