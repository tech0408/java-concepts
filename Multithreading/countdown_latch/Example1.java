package countdown_latch;

import java.util.concurrent.CountDownLatch;

class Worker implements Runnable{

    private CountDownLatch latch;

    Worker(CountDownLatch latch){
        this.latch=latch;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ".... is working");
        try {
            Thread.sleep(4000);
            System.out.println(Thread.currentThread().getName()+ "... has finished working");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            latch.countDown();
        }
    }
}

public class Example1 {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(3);

        Thread t1 = new Thread(new Worker(latch),"Worker 1");
        Thread t2 = new Thread(new Worker(latch), "Worker 2");
        Thread t3 = new Thread(new Worker(latch), "Worker 3");

        t1.start();
        t2.start();
        t3.start();

        // Main thread is waiting for all workers to complete.
        System.out.println("Main thread is now waiting for the worker threads to complete.");
        latch.await();
        System.out.println("Main thread is continuing with pending tasks.");
    }
}
