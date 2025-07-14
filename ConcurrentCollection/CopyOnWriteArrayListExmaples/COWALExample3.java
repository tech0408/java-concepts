package ConcurrentCollection.CopyOnWriteArrayListExmaples;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/*
 * 
 * This class demonstartes the second difference between AL and COWAL.
 * AL iterator can perform the remove ops but COWAL iterator cannot perform remove ops
 * and at runtime we get UnsupportedOperationException.
 */
public class COWALExample3 {

    public static void main(String[] args) {
        
        ArrayList<String> cw = new ArrayList<>();

        //CopyOnWriteArrayList<String> cw = new CopyOnWriteArrayList<>();
        /*
         * If we use COWAL instead of AL , then itr.remove() will throw UnsupportedOperationException
         * as remove() is not allowed.
         */
        cw.add("A");
        cw.add("B");
        cw.add("C");

        System.out.println("Original List : "+ cw);

        Iterator<String> it = cw.iterator();
        while(it.hasNext()){

            if(it.next().equals("B")){
                it.remove();
            }
        }

        System.out.println("Final list : "+ cw);
    }
    
}
