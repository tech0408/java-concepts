import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLocksolution2 {

    private final ReentrantLock lock1 = new ReentrantLock();
    private final ReentrantLock lock2 = new ReentrantLock();

    public void process(){

        try {
            if(lock1.tryLock(2000, TimeUnit.MILLISECONDS)){
                System.out.println(Thread.currentThread().getName() + "... has acquired lock1");
                Thread.sleep(1000);
                lock1.unlock();
                if(lock2.tryLock(20000, TimeUnit.MILLISECONDS)){
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().getName()+ "....has acquired lock 2");
                    System.out.println(Thread.currentThread().getName() + "...is executing critical section");
                    lock2.unlock();
                }
                else{
                    System.out.println(Thread.currentThread().getName() + "...cannot acquire lock2");
                }
            }
            else{
                System.out.println(Thread.currentThread().getName()+ "... cannot acquire lock1 and exiting to avoid deadlock");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
//        finally {
//            lock2.unlock();
//            lock1.unlock();
//        }
    }

    public static void main(String[] args) {

        DeadLocksolution2 ds = new DeadLocksolution2();
        Thread t1 = new Thread(ds::process);
        Thread t2 = new Thread(ds::process);
        Thread t3 = new Thread(ds::process);

        t1.start();
        t2.start();
        t3.start();
    }
}
