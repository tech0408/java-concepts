package stream_APIs;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/*
 * Implement a system that processes a list of strings and transforms them into uppercase, trims them, and calculates the length of each string using `Function`.

Requirements:
     - Create a list of strings (e.g., names or sentences).
     - Use `Function<String, String>` to:
          - Convert each string to uppercase.
          - Trim any extra spaces.
     - Use `Function<String, Integer>` to calculate the length of each string after applying the transformations.
     - Chain the functions using `andThen()` and `compose()` methods.

Implement error handling for empty strings and null values in the list.
 */

class CustomNullException extends Exception{

    public CustomNullException(String mag){
        super(mag);
    }
}
public class Example2 {

    public static void main(String[] args) {

        List<String> sL = Arrays.asList(" Sawan","Ram ","Shyam","Arun","", null);

        Function<String,String> f1 = s-> s.toUpperCase();
        Function<String,String> f2 = s-> s.trim();
        Function<String,Integer> f3 = s-> s.length();

        sL.stream().map(f1.andThen(f2)).forEach(System.out::println);
        
    }
    
}
