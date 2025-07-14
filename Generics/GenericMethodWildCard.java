package Generics;

import java.util.ArrayList;

/*
 * This class demonstrates the use of generic methods and wild card characters
 */
public class GenericMethodWildCard {
    

    // Method which can accept AL of any type.
    public static void print(ArrayList<?> al){

        al.add(null);
        System.out.println(al);
    }

    // This method can be invoked by passing AL of Number types of object or
    // types of subclasses of object . [Byte, Short, Integer, Double, Long]
    public static void print1(ArrayList<? extends Number> al){

        al.add(null);
        System.out.println(al);
    }

    /*
     * This method can be invoked by passing AL of String type or
     * AL of any of the super class objects like Object.
     */

    public static void print2(ArrayList<? super String> al){

        al.add(null);
        System.out.println(al);
    }

    public static void main(String[] args) {
        
        // Creating AL of String and calling method.
        ArrayList<String> a1 = new ArrayList<>();
        a1.add("Sawan");
        a1.add("Kumar");
        print(a1);
       // print1(a1); // This gives CE as String is not sub class of Number.


        // Create AL of Integer and calling method.
        ArrayList<Integer> a2 = new ArrayList<Integer>();
        a2.add(2);
        a2.add(4);
        print(a2);
        print1(a2);
        //print2(a2); This gives CE: Integer is not super class of String.
        

        // Create AL of Double and calling method.
        ArrayList<Double> a3 = new ArrayList<Double>();
        a3.add(4.5);
        a3.add(8.0);
        print(a3);
        print1(a3);


        ArrayList<Object> a4 = new ArrayList<Object>();
        a4.add("123");
        a4.add(12);
        a4.add(14.0);
        print2(a4); // a4 can be passed to print2 as Object is super class of string.

    }
}
