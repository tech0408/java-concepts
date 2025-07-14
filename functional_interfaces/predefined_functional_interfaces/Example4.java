package functional_interfaces.predefined_functional_interfaces;

import java.util.function.Supplier;

// supplier, chaining
// used when we want to get an object.
public class Example4 {

    public static void main(String[] args) {

        Supplier<Integer> s = ()-> 12;
        System.out.println("--------------------------------");
        System.out.println(s.get());
        
    }
    
}
