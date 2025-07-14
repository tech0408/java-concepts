package functional_interfaces.valid_functional_interfaces;


@FunctionalInterface
interface Interf6{
    public void m1();

}

// Valid as it get SAM from parent interface.
@FunctionalInterface
interface Interf7 extends Interf6{

}
public class Example4 {
    
}
