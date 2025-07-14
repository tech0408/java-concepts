import java.util.concurrent.locks.ReentrantLock;

// Lock ordering
public class DeadlockSolution {

    private final ReentrantLock lock1 = new ReentrantLock();
    private final ReentrantLock lock2 = new ReentrantLock();

    public void process1(){

        synchronized(lock1){
            lock1.lock();
        }
        System.out.println("Thread1 has acquired lock1");

        try {
            Thread.sleep(2000);
            synchronized(lock2) {
                lock2.lock();
            }
            System.out.println("Thread1 has acquired lock2");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            lock2.unlock();
            lock1.unlock();
        }
    }

    public void process2(){

        synchronized(lock1){
            lock1.lock();
        }
        System.out.println("Thread 2 has acquired lock1");
        try {
            Thread.sleep(2000);
            synchronized(lock2) {
                lock2.lock();
            }
            System.out.println("Thread 2 has acquired lock2");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            lock2.unlock();
            lock1.unlock();
        }
    }

    public static void main(String[] args) {

        DeadlockSolution ds = new DeadlockSolution();
        Thread t1 = new Thread(ds::process1);
        Thread t2 = new Thread(ds::process2);

        t1.start();
        t2.start();
    }
}
