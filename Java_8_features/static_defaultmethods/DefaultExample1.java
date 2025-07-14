package static_defaultmethods;

interface DefExample{

    default void m1(){
        System.out.println("Default m1 method");
    }
}

// This class implements the DefExample
public class DefaultExample1 implements DefExample{

    // Implementing class can override the default method as well.
    public void m1(){
        System.out.println("Own method called");
    }

    public static void main(String[] args) {
        
        DefaultExample1 ex = new DefaultExample1();

        // Default methods are available to all the implementing classses.
        //ex.m1(); // calling default mwthod of interface.

        // If implementation class overrides the default method, then it takes preference.
        ex.m1(); // Own method is called.
    }
    
}
