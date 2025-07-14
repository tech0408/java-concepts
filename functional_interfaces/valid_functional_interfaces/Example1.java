package functional_interfaces.valid_functional_interfaces;

// Valid FI as it has one SAM.
@FunctionalInterface
interface interf3{

    public void m1();
    default void m2(){

    }
    public static void m3(){

    }
}
public class Example1 {
    
}
