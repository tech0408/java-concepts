package ConcurrentCollection.CopyOnWriteArrayListExmaples;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/*
 * This class demonstrates the difference between AL and COWAL.
 * When one thread iterates the list and the other updates it, then we
 * get ConcurrentModification exception in case of AL but no error is
 * seen with COWAL.
 * 
 * This is beacuse on updation, COWAL creates a new AL and then it later 
 * synchronizies and copies it to the original one.
 * 
 * Since upon update, a new copy of the object is created wvery time, so COWAL is not
 * recommended in cases where we have extensive write/update ops.
 * 
 * Best suited when we have extensive read ops and few write/update ops.
 */

public class COWALExample2 extends Thread{

    // If Instead of COWAL we use the normal AL, then we get ConcurrentModificationException.
    // static ArrayList<String> cw = new ArrayList<>();

    static CopyOnWriteArrayList<String> cw = new CopyOnWriteArrayList<>();

    // Defining job of thread which is to perform update on COWAL.
    public void run(){

        System.out.println("Child thread updating the list ...");
        // When child thread starts updating the COWAL, a new copy of COWAL is now created.
        cw.add("D");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        
        // Add elements to the COWAL.
        cw.add("A");
        cw.add("B");
        cw.add("C");

        // Initialise and start the thread.
        COWALExample2 t1 = new COWALExample2();
        t1.start();

        // Main thread now iterates through the COWAL and prints the elements.
        Iterator<String> iter = cw.iterator();

        // Since main thread is maintaining a copy and upon update child thread has its own copy
        // so it might never happen that child thread updates the list and main thread gets the
        // updated list value.
        while(iter.hasNext()){

            String value = iter.next();
            System.out.println("Main thread is iterating and current value is : "+ value );
            Thread.sleep(2000);
        }

        System.out.println("Final List : "+ cw);

    }
    
}
