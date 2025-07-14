package ConcurrentCollection.CopyOnWriteArrayListExmaples;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/*
 * This class demonstartes as to what happens when we modify the list after we have declared the 
 * iterator for the list.
 * 
 * In AL -> we get exception saying ConcurrentModificationException.
 * In COWAL -> since a separate copy is maintained, so we will get the contents of list pre update
 * and no exception is thrown.
 */
public class COWALExample4 {

    public static void main(String[] args) {
        
        CopyOnWriteArrayList<String> cw = new CopyOnWriteArrayList<>(); // This works with no issues.
       //ArrayList<String> cw = new ArrayList<>();

        // Add the elements.
        cw.add("A");
        cw.add("B");
        cw.add("C");

        System.out.println("Original list: "+ cw);

        Iterator<String> it = cw.iterator();

        cw.add("D"); // This is not allowed in case of AL.
        while(it.hasNext()){

            System.out.println(it.next());
        }
        
    }
    
}
