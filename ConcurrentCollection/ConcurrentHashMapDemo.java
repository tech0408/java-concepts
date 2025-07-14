package ConcurrentCollection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

// Demo class to illustrate CMP and that we don't get ConcurrentModification exception
// when one thread is iterating on Map and other ois updating the map.

public class ConcurrentHashMapDemo extends Thread{

    static ConcurrentHashMap<Integer,String> cm = new ConcurrentHashMap<>();
    //static HashMap<Integer,String> cm = new HashMap<Integer,String>(); // If we uncomment this
    // and comment above line, we get ConcurrentModificationException.

    public void run() {

        // Here child thread is writing to map when the main thread is iterating the map.
        System.out.println("Child thread writing to map ...");
        cm.putIfAbsent(101, "Sawan");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        
        cm.put(102,"Rishu"); 
        cm.put(103,"Ashu");

        // Start the child Thread.
        ConcurrentHashMapDemo t1 = new ConcurrentHashMapDemo();
        t1.start();

        // Main thread iterates through map and prints the value.
        Set<Integer> iset = cm.keySet();
        Iterator<Integer> itr = iset.iterator();

        /*
         * Here child thread is writing to map, which the main thread might 
         * not get while iterating.
         * The main thing is we see the updated value in map by child thread
         * and there is no ConcurrentModificationException.
         */
        while(itr.hasNext()){
            Integer key = itr.next();
            System.out.println("Main thread" + "-"+ "key is:"+ key + " value is :" + cm.get(key));
            Thread.sleep(3000);
        }

        System.out.println(cm);

    }


    
}
