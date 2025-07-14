package countdown_latch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

class Worker1 implements Runnable {

    private final CountDownLatch latch;
    private final long duration;

    Worker1(CountDownLatch latch, long duration){
        this.latch=latch;
        this.duration=duration;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "....is working");
        try {
            Thread.sleep(duration);
            System.out.println(Thread.currentThread().getName() +"... is done executing");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally{
            latch.countDown();
        }
    }
}
public class Example2 {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(3);

        Thread w1 = new Thread(new Worker1(latch, 1000),"Worker 1");
        Thread w2 = new Thread(new Worker1(latch,7000), "Worker 2");
        Thread w3 = new Thread(new Worker1(latch, 2000), "worker 3");

        w1.start();
        w2.start();
        w3.start();

        System.out.println("Main thread is waiting for worker threads with a timeout");
        boolean allDone = latch.await(5, TimeUnit.SECONDS);
        if(allDone){
            System.out.println("All worker threads are done.");
        }
        else{
            System.out.println("Reached timeout");
        }

        System.out.println("Main thread continuing with pending tasks...");
    }
}
