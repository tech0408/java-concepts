package Multithreading;

class Mythread11 extends Thread{

    // Overriding start method.
    public void start(){
        // If we call the start() of parent class Thread, then the thread is created.
        // If we do not invoke the super.start(), then start() method will not create any thread. It will be executed
        // as a normal method call.
        super.start();
        System.out.println("Implemented start method: "+ Thread.currentThread().getName());
    }

    public void run(){
        System.out.println("Child Thread");
    }

}

public class ThreadOverrideStartMethod {

    public static void main(String[] args) {

        Mythread11 mt = new Mythread11();
        mt.start();
    }
    
}
