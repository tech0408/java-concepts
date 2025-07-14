package reentrant_lock;

import java.util.concurrent.locks.ReentrantLock;

class MythreadExample extends Thread{

    static ReentrantLock l = new ReentrantLock();

    //String name;

    MythreadExample(String name){
        super(name);
    }

    public void run(){

        if(l.tryLock()){
            System.out.println(Thread.currentThread().getName() + "...has lock and is executing safe ops");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        else{
            System.out.println(Thread.currentThread().getName() + "..does not have lock and executes alternate ops");
        }
    }
}

public class ReentrantLock3 {

    public static void main(String[] args) {

        MythreadExample t1 = new MythreadExample("first thread");
        MythreadExample t2 = new MythreadExample("second thread");
        t1.start();
        t2.start();

    }
}
