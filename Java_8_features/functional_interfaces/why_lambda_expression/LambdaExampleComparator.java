package functional_interfaces.why_lambda_expression;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class LambdaExampleComparator {

    public static void main(String[] args) {
        
        ArrayList<Integer> al = new ArrayList<Integer>();
        al.add(70);
        al.add(42);
        al.add(11);
        al.add(56);
        al.add(5);

        System.out.println("Elements are printed based on insertion order...");
        System.out.println(al);

        // Sort the elements in ascending order -> default natural sorting order.
        Collections.sort(al);

        System.out.println("Elements in ascending order ...");
        System.out.println(al);

        // Sort elements based on descending order.
        // Here we need to provide implementation for the Comparator interface.
        Comparator<Integer> cmp = (a,b)-> a>b?-1:a<b?1:0;
        Collections.sort(al,cmp);

        System.out.println("Elements in descending order...");
        System.out.println(al);
        
    }
    
}
