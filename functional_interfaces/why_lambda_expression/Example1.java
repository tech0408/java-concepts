package functional_interfaces.why_lambda_expression;

/*
 * class to demonstrate the functionality w/o lambda expression.
 * Steps to implement m1() of FI interface w/o lambda expression.
 * 1. Define a class which implements Interf.
 * 2. Provide implementation of this method in the defined class.
 * 3. Create an object of this defined class in main().
 * 4. Then invoke the method using obj ref created in step 3.
 */

@FunctionalInterface
interface Interf{

    public void m1();
}

class InterfClass implements Interf{

    public void m1(){
        System.out.println("Hello world!");
    }
}

public class Example1 {

    public static void main(String[] args) {

        InterfClass cl = new InterfClass(); // create object of implementation class.
        cl.m1();

        //Using Lambda expression. 
        Interf i = ()-> System.out.println("Hello world!"); // Using Parent class reference to hold child class object.
        /*
         * Here we provide the implementation of m1() method directly
         * using lambda expression and we are sure this is implementation
         * of m1() only as it is the only method inside Interf(FI)
         * 
         * So, in this case, we don't require an intermediate class to implement Interface.
         */
        i.m1();
    }
    
}
