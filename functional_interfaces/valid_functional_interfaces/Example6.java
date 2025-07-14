package functional_interfaces.valid_functional_interfaces;


@FunctionalInterface
interface Interf10 {
    public void m1();
}

// Invalid as it has two AM method one of its own and other from parent.
@FunctionalInterface
interface Interf11 extends Interf10{
    public void m2();
}
public class Example6 {
    
}
