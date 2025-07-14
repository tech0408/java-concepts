package functional_interfaces.valid_functional_interfaces;


@FunctionalInterface
interface Interf8{
    public void m1();
}

// Valid as it overrides m1 ().
@FunctionalInterface
interface Interf9 extends Interf8{
    public void m1();
}
public class Example5 {
    
}
