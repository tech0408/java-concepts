package Multithreading;

/*
 * Multitasking -> when multiple tasks are executing simultaneously.
 * Types of multitasking --> process based and thread based
 * 1. Process based -> when the tasks executing are running as a separate process. (achieved at OS level)
 * 2. Thread based -> when there are multiple parts of the same program and each part executes as an independent thread.
 * 
 * 
 * Purpose of multitasking --> to minimise the processor idle time and to go for optimal utilization
 * of resources.
 * 
 * Thread based multitasking is language specific.
 * 
 * Two ways of creating thread.
 * 1. Extending the Thread class.
 * 2. Implementing the Runnable interface.
 *
 */

class Mythread extends Thread{

    // Override the run method.
    // Job of the thread is provided under the run method.
    // start() method of thread will always execute the no-args run method.
    public void run(){
        for(int i=1; i<=5; i++){
            System.out.println(Thread.currentThread().getName());
            System.out.println("Child Thread - no args method");
        }
    }

    // We override the run method but start() always invokes the run() with no arguments.
    // public void run(int p){

    //     for(int i=1; i<=5; i++){
    //         System.out.println("Child Thread - args method");
    //     }

    // }
}

public class Thread1 {

    public static void main(String[] args) {
        /*
         * Here 2 threads are running in parallel -> main thread and child thread.
         * Based on the thread scheduler which it will schedule, the threads will
         * execute.
         */
        Mythread t1 = new Mythread(); // Instantiating new Thread.
        /*
         * when the start method is invoked, the thread comes to the ready state.
         * start(){
         *  1. Register the thread with the thread scheduler.
         *  2. Perform the mandatory activities.
         *  3. Invoke the run method of the thread.
         * }
         */

        t1.start();
        // t1.run() -> if run() is invoked, it will execute like a normal method. And no thread is created.
        for(int i=1;i<=5;i++){
            System.out.println(Thread.currentThread().getName());
            System.out.println("Main Thread");    
        }
        
    }
    
}
