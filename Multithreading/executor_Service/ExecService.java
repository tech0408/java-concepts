package executor_Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ExecExample implements Runnable{

    String name;
    ExecExample(String name){
        this.name=name;
    }

    @Override
    public void run() {
        System.out.println(name + "... is executed by thread - "+ Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}


public class ExecService {

    public static void main(String[] args) {

        ExecExample [] jobs = {
                new ExecExample("sawan"),
                new ExecExample("ram"),
                new ExecExample("shyam"),
                new ExecExample("prakash"),
                new ExecExample("shiva")
        };

        ExecutorService service = Executors.newFixedThreadPool(2);
        for(ExecExample job : jobs){
            service.submit(job);
        }
        service.shutdown();
    }
}