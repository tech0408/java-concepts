package functional_interfaces.valid_functional_interfaces;

// Invalid FI as there is no SAM. FI can have any no of default and static methods.
@FunctionalInterface
interface Interf5{

    default void m2(){

    }
    public static void m3(){

    }
}
public class Exmaple3 {
    
}
