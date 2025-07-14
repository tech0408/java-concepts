package functional_interfaces.valid_functional_interfaces;



@FunctionalInterface
interface Interf12 {
    public void m1();
}

// valid as it not FI so it can have any no of AMs.
interface Interf13 extends Interf12{
    public void m2();
}
public class Example7 {
    
}
