package functional_interfaces.predefined_functional_interfaces;

import java.util.function.BiFunction;
import java.util.function.Function;

// Using pre-defined functional interface.
/*
 * 
 * 1. Function (takes input and returns some value)
 * 2. Predicate -> used for conditional checks (takes input and returns a boolean)
 * 3. Supplier -> supplies some value
 * 4. Consumer -> takes some input and does not return any value.
 */


// Function, BiFunction and Function chaining (andThen() and compose())
public class Example1 {

    public static void main(String[] args) {

        // function has one method -> apply()
        Function<Integer,Integer> f1 = i-> i*10; // Here function takes one input integer and 
        // returns the integer.
        System.out.println(f1.apply(5));
        System.out.println(f1.apply(7));

        // Use Case : - Take a string and return the length of string.
        Function<String,Integer> f2 = s-> s.length();
        System.out.println("--------------------------");
        System.out.println(f2.apply("sawan"));
        System.out.println(f2.apply("epam systems"));

        // Take a string and return it by lowercasing them.
        Function<String,String> f3 = s-> s.toLowerCase();
        System.out.println("------------------------");
        System.out.println(f3.apply("SAWan"));
        System.out.println(f3.apply("KUMAR"));

        BiFunction<Integer,Integer,Integer> bf1 = (a,b)-> a+b;
        System.out.println("--------Bi function 1------------");
        System.out.println(bf1.apply(12, 23));
        System.out.println(bf1.apply(34,33));

        BiFunction<String,String,String> bf2 = (s1,s2)-> s1+s2;
        System.out.println("Bi fucntion 2 --------------------");
        System.out.println(bf2.apply("Sawan","Kumar"));
        System.out.println(bf2.apply("Mr.", "Sawan"));

        BiFunction<String,String,Integer> bf3 = (s1,s2)-> s1.length()+s2.length();
        System.out.println("Bi function 3 -------------------");
        System.out.println(bf3.apply("ab","cd"));

        // Function chaining andThen() & compose()
        Function<String,String> chain1 = String:: toUpperCase;
        Function<String,String> chain2 = s-> s+"abc";
        System.out.println("---------------Function chaining --------------------");
        System.out.println(chain1.andThen(chain2).apply("sawan"));
        System.out.println(chain2.andThen(chain1).apply("sawan"));
        System.out.println(chain1.compose(chain2).apply("sawan"));
    }
    
}
