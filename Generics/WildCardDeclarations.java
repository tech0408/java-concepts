package Generics;

import java.util.ArrayList;

public class WildCardDeclarations {

    public static void main(String[] args) {
        
        ArrayList<String> al = new ArrayList<String>(); // AL of String type.
        al.add("Sawan");
        System.out.println(al);

        ArrayList<?> a2 = new ArrayList<Integer>(); // Al of Integer type to ?
        a2.add(null);
        System.out.println(a2);

        ArrayList<? extends Number> a3 = new ArrayList<Integer>(); 
        a3.add(null);
        System.out.println(a3);

        ArrayList<? super String> a4 = new ArrayList<Object>();
        a4.add(null);
        System.out.println(a4);

        //ArrayList<?> a5 = new ArrayList<?>();

        //ArrayList<?> a6 = new ArrayList<? extends Number>();
    }
    
}
