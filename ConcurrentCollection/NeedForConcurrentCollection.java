package ConcurrentCollection;

import java.util.ArrayList;
import java.util.Iterator;

/*
 * Demo for the need of concurrent collection.
 * When one thread is iterating a collection object and another thread trying to modify the 
 * same collection object, then we get ConcurrentModificationException.
 */
public class NeedForConcurrentCollection extends Thread{

    static ArrayList<String> al = new ArrayList<>();    

    public void run(){

        al.add("A");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        
        al.add("B");
        al.add("C");

        NeedForConcurrentCollection t1 = new NeedForConcurrentCollection();
        t1.start();
        
        Iterator<String> itr = al.iterator();
        while(itr.hasNext()){

            String s = itr.next();
            System.out.println("Main thread : "+ s);
            Thread.sleep(2000);
        }
    }
}
