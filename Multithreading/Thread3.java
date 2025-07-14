package Multithreading;


class Mythread3 implements Runnable {

    // Job of the thread.
    public void run(){

        // yield method -> it is used to pause the current executing thread.
        /*
         * 1. The other threads with same priority will get the chance to execute.
         * 2. The execution depends on the thread scheduler.
         * 3. The yielded thread then moves to ready/runnable state and then will be scheduled by scheduler.
         * 4. yield method is used when we have a thread which takes a lot of time to execute.
         */

        for(int i=1; i<=5; i++){
            Thread.yield(); // Pausing the current thread.
            System.out.println("Child Thread");
            try {
                Thread.sleep(9000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

}

public class Thread3 {

    public static void main(String[] args) throws InterruptedException {
        
        // Defining a thread.
        Mythread3 mt = new Mythread3();

        Thread t = new Thread(mt);

        // Parent thread main invokes the child thread.
        t.start();
        //Thread.yield();

        for(int i=1;i<=5;i++){
            System.out.println("Main thread");
        }

    }
    
}
