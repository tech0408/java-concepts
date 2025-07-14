package executor_Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecService3 {

    public static void main(String[] args) {

        /*
            using newFixedThreadPool() -> which defines the number of threads in the pool.
            If jobs are more than the thread pool, then jobs have to wait for other threads to
            complete before the jobs can be picked up.
         */
        //ExecutorService executor = Executors.newFixedThreadPool(3);

        /*
          On using newCachedThreadPool() -> the threads are created dynamically in the pool.
          based on the need. this is suitable for short live tasks.
         */
        ExecutorService executor = Executors.newCachedThreadPool();

        Runnable job = ()->{

            System.out.println(Thread.currentThread().getName() + "... is executing");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println(Thread.currentThread().getName() + ".. is completed now");
        };

        for(int i =1; i<=10;i++) {
            executor.execute(job);
        }

        executor.shutdown();
    }
}
