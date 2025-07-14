package executor_Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorService4 {

    public static void main(String[] args) {

        /*
            we use newSingleThreadExecutor() -> when we want to execute the jobs sequentially.
         */
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Runnable job = ()->{

            System.out.println(Thread.currentThread().getName() + ".. is executing now");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + "... is done executing");
        };

        for(int i=1;i<=10;i++){
            executor.execute(job);
        }

        executor.shutdown();
    }
}
