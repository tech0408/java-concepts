package Method_Const_reference.Constructor_reference;

/*
 * Constructor reference : Classname:: new
 * Used when we have SAM which returns a class Object.
 */
class Sample{
    Sample(){
        System.out.println("Sample no-args constructor");
    }

    Sample(String s){
        System.out.println("Args constructor: "+ s);
    }
}

@FunctionalInterface
interface CRInterf{

    public Sample get(String s);
}

@FunctionalInterface
interface CRInterf1{

    public Sample get();
}

public class ExampleCR1 {

    public static void main(String[] args) {

        //CRInterf cri = ()-> new Sample(); // when using lambda expression.
        CRInterf cri = Sample::new; // This is only declaration.
        //cri.get(); // When we invoke method, then the constructor is called.

        // If we have parametrised constructor, then we pass argument in the method.
        cri.get("Sawan");

        CRInterf1 cr1= Sample::new;
        cr1.get();
        
    }
    
}
