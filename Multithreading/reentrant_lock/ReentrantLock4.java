package reentrant_lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

class Mythread22 extends Thread{

    static ReentrantLock l = new ReentrantLock();

    Mythread22(String name){
        super(name);
    }

    public void run(){

        do{
            try{
                if(l.tryLock(5000, TimeUnit.MILLISECONDS)){
                    System.out.println(Thread.currentThread().getName() + "... has the lock");
                    Thread.sleep(30000);
                    l.unlock();
                    System.out.println(Thread.currentThread().getName()+ "... releases the lock");
                    break;
                }
                else{
                    System.out.println(Thread.currentThread().getName() + "...did not get the lock will try again. ");
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        while(true);
    }
}

public class ReentrantLock4 {

    public static void main(String[] args) {

        Mythread22 t1 = new Mythread22("Thread sawan");
        Mythread22 t2 = new Mythread22("Thread ashu");
        t1.start();
        t2.start();
    }
}
