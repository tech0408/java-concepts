package Multithreading;

// Requirement -> If one thread has to wait for another thread to complete, then the waiting thread
// has to call join method with thread reference of another thread.
/*
 * The thread for which it is waiting need not know as to which thread is waiting for it.
 */
class Mythread4 implements Runnable{

    // Job of the thread.
    public void run(){
        for(int i=1; i<=5; i++){
            System.out.println("Child Thread");
        }

    }

}


public class ThreadJoinDemo {

    public static void main(String[] args) {
        // Defining a thread.
        Mythread4 mt = new Mythread4();

        Thread t = new Thread(mt);

        t.start();
        try {
            // main thread invokes join method on child thread reference.
            // Here the main thread waits for the child thread to complete.
            t.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        for(int i=1;i<=5;i++){
            System.out.println("Main Thread");
        
        }
    }
}
    
