package mycode.day26;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ls on 17-7-18.
 */
public class FanXing<T> {
    public T getName(){
        return null;
    }
    public static void main(String[] args){
        ExecutorService service = Executors.newFixedThreadPool(5);
        service.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return null;
            }
        });
        List<String> list = new ArrayList<String>();
    }
}
