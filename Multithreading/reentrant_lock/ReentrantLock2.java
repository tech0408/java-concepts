package reentrant_lock;

import java.util.concurrent.locks.ReentrantLock;

class Display {

    ReentrantLock l = new ReentrantLock();

    public void wish(String name) throws InterruptedException {

        l.lock();
        for(int i=1;i<=10;i++){

            System.out.print("Good mrng...:");
            Thread.sleep(1000);
            System.out.println(name);
        }
        l.unlock();
    }
}

class RenDemo extends Thread{

    Display d;
    String name;
    RenDemo(Display d, String name){
        this.d=d;
        this.name=name;
    }

    public void run(){
        try {
            d.wish(name);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

public class ReentrantLock2 {

    public static void main(String[] args) {

        Display d = new Display();
        RenDemo dem1 = new RenDemo(d, "Sehwag");
        RenDemo dem2 = new RenDemo(d, "Sachin");
        RenDemo dem3 = new RenDemo(d, "Ganguly");

        dem1.start();
        dem2.start();
        dem3.start();
    }
}
