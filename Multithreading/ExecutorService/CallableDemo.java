package Multithreading.ExecutorService;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class CallExample implements Callable<Integer>{

    int num;

    CallExample(int num){
        this.num=num;
    }

    public Integer call() throws Exception{

            System.out.println(Thread.currentThread().getName());
            int sum=0;
            for(int i=1;i<=num;i++){
                sum= sum+i;
            }
            Thread.sleep(10000);

        return sum;

    }
}

public class CallableDemo {

    public static void main(String[] args) {

        CallExample [] ex = {new CallExample(100000),new CallExample(12000), new CallExample(100)};

        ExecutorService svc = Executors.newFixedThreadPool(3);
        for(CallExample em : ex){
            Future<Integer> f = svc.submit(em);
        try {
            System.out.println(f.get());
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        

        }
        
    }
    
}
