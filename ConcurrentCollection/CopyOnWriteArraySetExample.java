package ConcurrentCollection;

import java.util.concurrent.CopyOnWriteArraySet;

/*
 * This class demonstrates how do we declare the COWAS.
 */
public class CopyOnWriteArraySetExample {

    public static void main(String[] args) {
        
        CopyOnWriteArraySet<String> cws = new CopyOnWriteArraySet<>();

        cws.add("F");
        cws.add("A");
        cws.add("B");
        cws.add("A"); // Duplicates not allowed.
        cws.add(null); // Null is allowed.
        System.out.println(cws); // Order is preserved as the internal implementation of COWAS is COWAL.
    }
    
}
