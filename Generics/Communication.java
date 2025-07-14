package Generics;

import java.util.ArrayList;

/*
 * this class demonstrates the communication between the
 * generic area and non-generic area.
 */
public class Communication {


    public static void m1(ArrayList al){
        // non generic area.
        al.add(10);
        al.add(13.5);
        al.add(true);
    }

    public static void main(String[] args) {
        

        ArrayList<String> al = new ArrayList<>();
        al.add("Sawan");
        al.add("Ashu");

        System.out.println(al);

        m1(al);

        //al.add(12); // Not allowed

        System.out.println(al);
    }
    
}
