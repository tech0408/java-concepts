package countdown_latch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class FileProcessingJob {

    private static int MAXFILES = 5;
    private static int CONCURRENT_PROCESS = 3;

    public static void main(String[] args) throws InterruptedException {

        Semaphore semaphore = new Semaphore(CONCURRENT_PROCESS);
        CountDownLatch latch = new CountDownLatch(MAXFILES);

        Runnable task = ()->{
            System.out.println(Thread.currentThread().getName() + "... waiting for permit");
            try {
                semaphore.acquire();
                Thread.sleep(5000);
                System.out.println("Processing file with thread : "+ Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            finally {
                latch.countDown();
                semaphore.release();
            }
        };

        // Start the five threads and then main thread waits for them to complete to mark the job as done.

        for(int i=1;i<=5;i++){
            new Thread(task).start();
        }

        latch.await();
        System.out.println("All jobs are done. Bye bye!!");
    }

}
