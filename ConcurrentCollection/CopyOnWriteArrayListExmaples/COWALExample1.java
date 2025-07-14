package ConcurrentCollection.CopyOnWriteArrayListExmaples;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

/*
 * This class is to demonstrate-
 * 1. How to declare the COWAL concurrent collection?
 * 2. Different methods that are present inside it. addIfAbsent() and addAllAbsent()
 */
public class COWALExample1 {

    public static void main(String[] args) {

        // Normal AL
        ArrayList<String> al = new ArrayList<>();

        // Add elements to ArrayList
        al.add("A");
        al.add("B");
        
        System.out.println("Array List al contents :"+ al);
        // Declare COW AL
        CopyOnWriteArrayList<String> cw = new CopyOnWriteArrayList<>();
        
        // Add elements to COWAL
        cw.add("A"); // Here duplicate value A is added.
        cw.add("B");
        cw.addIfAbsent("B"); // On using addIfAbsent method, B is not added as it is already present.

        System.out.println("COWAL cw contents:" +cw);

        // Adding al to cw.
        cw.addAll(al);
        System.out.println("New contents of COWAL :"+ cw);

        CopyOnWriteArrayList<String> cw1 = new CopyOnWriteArrayList<>();
        cw1.add("C");
        cw1.add("D");
        cw1.add("B");
        cw1.add("A");
        System.out.println("Contents of new COWAL cw1 :"+ cw1);

        // Adding cw1 to cw.
        cw.addAllAbsent(cw1);
        System.out.println("Final contents of COWAL cw:"+cw);

    }
    
}
