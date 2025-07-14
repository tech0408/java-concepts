package ConcurrentCollection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * This class is demonstrate synchronizedSet(), synchronizedList() and synchronizedMap()
 */
public class SynchronizedExample extends Thread{

    // static List<String> s = new ArrayList<>();
    // static List<String> al = Collections.synchronizedList(s);

    static Set<String> s = new HashSet<>();
    static Set<String> al = Collections.synchronizedSet(s);

    public void run(){
        System.out.println("Child thread updating the list...");
        al.add("D");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        
        
        al.add("A");
        al.add("B");

        System.out.println("Initial list :"+ al);

        // creating new thread and strating it.
        SynchronizedExample t1 = new SynchronizedExample();
        t1.start();

        System.out.println("Main thread is updating the list ...");
        al.add("C");
        Thread.sleep(3000);

        System.out.println("Final List: "+ al);
    }


    
}
