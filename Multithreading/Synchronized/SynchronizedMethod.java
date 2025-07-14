package Multithreading.Synchronized;

/*
 * Synchronization is used when we have multiple threads operating on same object.
 * It helps us to avoid the race condition and avoids data inconsistency problems.
 * 
 * synchronized is a modifier and is used at method and block level.
 * 
 * When we make a method synchronized, then the thread acquires the object level lock.
 * The other thread can execute the method only when the lock is released.
 * 
 * Two types of locks -> class level lock and object level lock.
 * When a method is synchronized, then thread acquires object level lock when calling it.
 * When a method is static synchronized, then thread acquires class level lock when calling it.
 * 
 * Case 1: When a thread is executing a synchronized method of an object, then it 
 *         acquires the object level lock, and if another thread is trying to execute the 
 *         same method, then it has to wait for previous thread to complete and release lock.
 * 
 * Case 2: When a thread executes the synchronized method, and another thread wants to execute
 *         synchronized method on same object, then it has to wait again.
 * 
 * Case 3: When a thread executes static synchronized method, then it acquires the class level lock
 *         and if another thread wants to execute the same method from different object, then 
 *         it has to wait.
 * 
 * Advantages : Avoids the data inconsistency problem.
 * 
 * Disadvantages:
 * 1. Increases the waiting time for the thread.
 * 2. Decreases the performance of the system.
 */

class Display{
    
    public static synchronized void show(String name){
        for(int i=1;i<=10;i++){
            System.out.println("Hello :"+ name);
        } 
    }
    public static synchronized void show1(String name){
        for(int i=1;i<=10;i++){
            System.out.println("Hello1 :"+ name);
        } 
    }
    public synchronized void show2(String name){
        for(int i=1;i<=10;i++){
            System.out.println("Hello2 :"+ name);
        } 
    }
}

class Minethread extends Thread{

    private Display d;
    private String name;
    Minethread(Display d,String name){
        this.d=d;
        this.name = name;
    }

    public void run(){
        d.show(name);
    }

}

class Minethread1 extends Thread{

    private Display d;
    private String name;
    Minethread1(Display d,String name){
        this.d=d;
        this.name = name;
    }

    public void run(){
        d.show1(name);
    }

}

class Minethread2 extends Thread{

    private Display d;
    private String name;
    Minethread2(Display d,String name){
        this.d=d;
        this.name = name;
    }

    public void run(){
        d.show2(name);
    }

}

public class SynchronizedMethod {

    public static void main(String[] args) {

        Display d = new Display();
        //Display d2 = new Display();
        Minethread mt1 = new Minethread(d, "Sawan");
        Minethread1 mt2 = new Minethread1(d, "Rishika");
        Minethread2 mt3 = new Minethread2(d, "Sarish");
        mt1.start();
        mt2.start();
        mt3.start();
    }
    
}
