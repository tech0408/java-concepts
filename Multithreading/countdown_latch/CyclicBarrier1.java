package countdown_latch;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrier1 {

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {

        CyclicBarrier cb = new CyclicBarrier(4, () ->{
            System.out.println("All threads reached the barrier , proceeding...");
        });

        Runnable worker = ()->{
            System.out.println(Thread.currentThread().getName() + "...reached the barrier");
            try{
                cb.await();
            }
            catch (Exception ignored){
            }
            System.out.println(Thread.currentThread().getName() + "... resumed");
        };

        new Thread(worker).start();
        new Thread(worker).start();
        new Thread(worker).start();


    }
}
