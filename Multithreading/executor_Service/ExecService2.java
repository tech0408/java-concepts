package executor_Service;

import java.util.concurrent.*;

class ExecExample2 implements Callable {

    int num;
    ExecExample2(int num){
        this.num=num;
    }
    public Integer call() throws Exception{

        System.out.println(Thread.currentThread().getName() + "... is responsible for printing sum of "+ num + "numbers");
        int sum = 0;
        for(int i=1;i<=num;i++) {
            sum = sum + i;
        }
        return sum;

    }
}

public class ExecService2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecExample2 [] jobs = {
                new ExecExample2(10),
                new ExecExample2(20),
                new ExecExample2(30),
                new ExecExample2(40)
        };

        ExecutorService svc = Executors.newFixedThreadPool(3);
        for(ExecExample2 job : jobs){
            Future f = svc.submit(job);
            System.out.println(f.get());
        }

        svc.shutdown();
    }
}
