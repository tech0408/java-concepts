package executor_Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorService5 {
    public static void main(String[] args) {

        /*
            when we want to execute the tasks in periodic manner, then we go for scheduled
            executor service.
         */
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);

        Runnable job1 = ()->{

            System.out.println(Thread.currentThread().getName() + "...is executing");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + "... is done executing");
        };

        // Schedule a one time task to run after 3 seconds.
        scheduler.schedule(job1,0, TimeUnit.SECONDS);

        // schedule a periodic task to run every 5 seconds.
        scheduler.scheduleAtFixedRate(()->{
            System.out.println(Thread.currentThread().getName() + "...is a periodic task");
        },0,5,TimeUnit.SECONDS);
    }
}
