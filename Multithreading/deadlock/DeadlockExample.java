import java.util.concurrent.locks.ReentrantLock;

public class DeadlockExample {

    private ReentrantLock lock1 = new ReentrantLock();
    private ReentrantLock lock2 = new ReentrantLock();

    public void process1(){
        lock1.lock();
        System.out.println("Thread 1 has acquired the lock1");
        try {
            Thread.sleep(2000);
            lock2.lock(); // Thread 1 waits for lock2.
            System.out.println("Thread 1 has acquired the lock2");
        }
        catch (Exception ex){
            System.out.println(ex.toString());
        }
        finally {
            lock2.unlock();
            lock1.unlock();
        }
    }

    public void process2() {
        lock2.lock();
        System.out.println("Thread 2 has acquired the lock2");

        try {
            Thread.sleep(2000);
            lock1.lock();
            System.out.println("Thread2 has acquired the lock1");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            lock1.unlock();
            lock2.unlock();
        }
    }

    public static void main(String[] args) {

        DeadlockExample ex = new DeadlockExample();
        Thread t1 = new Thread(ex::process1);
        Thread t2 = new Thread(ex::process2);

        t1.start();
        t2.start();
    }
}
