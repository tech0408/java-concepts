package Multithreading.InterThreadCommunication;

class ThreadA extends Thread{

    int total=0;

    public void run(){

        synchronized(this){
            for(int i=1;i<=10;i++){
            total = total+i;
            //System.out.println("Child Thread");
            }
            this.notify();
        }
        
    }
}

public class ITC1 {

    public static void main (String [] args) throws InterruptedException{

        ThreadA t = new ThreadA();
        t.start();
        synchronized(t){
            t.wait();
        }
        //t.join();
        System.out.println(t.total);
    }
    
}
