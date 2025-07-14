package countdown_latch;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(3);

        Runnable task = ()->{

            System.out.println(Thread.currentThread().getName() + ".. is waiting for permit");
            try {
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName()+ ".. acquired the permit");
                Thread.sleep(13000);
                System.out.println(Thread.currentThread().getName() + "...is releasing the permit");
               // semaphore.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        for(int i=1;i<=5;i++){
            new Thread(task).start();
        }
    }
}
