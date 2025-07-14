package Generics;

import java.util.ArrayList;

/*
 * 
 * this class demonstartes that generics is applicable only during compile time.
 */
public class GenericsComileTime1 {

    public static void main(String[] args) {
        

        // at compile time only compiler checks the type of reference.
        ArrayList l = new ArrayList<String>();
        l.add(10);
        l.add("Sawan");
        l.add(true);

        System.out.println(l);
    }
    
}
