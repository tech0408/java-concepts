package functional_interfaces.predefined_functional_interfaces;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

// Consumer, BiConsumer, Consumer chaining andThen()
public class Example3 {

    public static void main(String[] args) {
        
        // 	1. Take a number and print its cube.
        Consumer<Integer> c1 = c-> System.out.println(c*c*c);
        System.out.println("-----------------------------------------");
        c1.accept(4);
        c1.accept(14);

        // Take a string and print its length.
        Consumer<String> c2 = c-> System.out.println(c.length());
        System.out.println("------------------------------------------");
        c2.accept("sawan");
        c2.accept("kumarsawan");

        // 	3. Take two numbers and print their sum.
        BiConsumer<Integer,Integer> bc = (a,b)-> System.out.println(a+b);
        System.out.println("--------------------------------------------");
        bc.accept(23,12);
        bc.accept(12,10);

        // 	4. Take two strings and print the concatenated string.
        BiConsumer<String,String> bc2 = (s1,s2)-> System.out.println(s1+s2);
        System.out.println("-----------------------------------------");
        bc2.accept("sawan","kumar");

        // BiConsumer
        BiConsumer<Integer,Integer> bc3 = (n1,n2)-> System.out.println(n1+n2);
        BiConsumer<Integer,Integer> bc4 = (n1,n2)-> System.out.println(n1-n2);
        BiConsumer<Integer,Integer> bc5 = (n1,n2)-> System.out.println(n1*n2);
        System.out.println("---------------------------------------------------");
        bc3.andThen(bc4).andThen(bc5).accept(41,2);



    }
    
}
