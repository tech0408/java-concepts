package Multithreading;

/*
 * 2nd way of creating thread is by implementing the Runnable interface.
 * 
 * This is the recommended way of creating thread.
 * Because it allows the class to inherit another class and does not restrict inheritance,
 * which is the case with extending the Thread class.
 * 
 * However, there is extra overhead as Runnable interface does not have the start method
 * which is required to start the thread, and we need to use Thread class constructor for the same.
 */

class Mythread2 implements Runnable{

    public void run(){
        Thread.currentThread().setName("sawan-child");
        Thread.currentThread().setPriority(10);
        for(int i=1; i<=5; i++){
            System.out.println("Child thread");
            // System.out.println("Child Thread");
        }

    }

}
public class Thread2 {

        public static void main(String[] args) {

            // Setting the name for the thread.
            Thread.currentThread().setName("main-sawan");

            // Every thread has a priority which is in the range [1,10] with 1 being the least priority 
            // and 10 being the highest priority.
            /*
             * By default, priority 5 is assigned to each thread.
             * Child thread gets the priority of the Parent thread.
             *  
             * In this example, main is the parent thread for the mythread which has name thread-0 by default.
             * The parent class of the Mythread2 is the Runnable interface.
             * 
             * Priority decides which thread will get priority to be executed first over the other.
             */

            // Get the priority of the Thread.
            System.out.println(Thread.currentThread().getPriority());

            // On setting the priority of the main thread, the child thread also gets the same priority.
            Thread.currentThread().setPriority(7);

            Mythread2 t1 = new Mythread2();
            
            /*
             * Here we cannot directly invoke the start() using t1 object reference.
             * Reason being start method is not present in the Runnable interface.
             * 
             * So we need to create Thread class object and then invoke the start method.
             */
            Thread t = new Thread(t1);
            t.start();

            System.out.println("Child Thread :"+ Thread.currentThread().getPriority());

            for(int i=1; i<=5; i++){
                System.out.println("Main thread");
            }
            

        }

    
}
