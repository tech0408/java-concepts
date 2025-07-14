package Method_Const_reference.Method_reference;

/*
 * class to demonstrate method reference.
 * Instead of lambda expression, if we have an existing method then we can go for method 
 * reference.
 */

public class ExampleMR1 {

    // We have an existing method m1 which defines the job of child thread.
    // so instead of writing lambda expression for run() , we can use this method.
    public static void m1(){
        for(int i=0;i<10;i++){
            System.out.println("Child Thread-1");
        }
    }

    // Instance method which provides the job of the thread.
    public void m2(){
        for(int i=0;i<10;i++){
            System.out.println("Child Thread-11");
        }
    }

    public static void main(String[] args) {
        
        // Writing lambda expression for run() method of Runnable interface.
        Runnable r = ()->{

            for(int i=0;i<10;i++){
                System.out.println("Child Thread ...");
            }

        };

        Runnable r = ExampleMR1::m1; // Using method reference to define the job of thread.
        // Here m1() refers to run() of Runnable interface.

        //If m1 is not static method and is instance method, then we should 
        // use the instance reference.
        ExampleMR1 ex = new ExampleMR1();

        Runnable r = ex::m2;
        Thread t = new Thread(r);
        t.start();

        for(int i=0;i<10;i++){
            System.out.println("Main Thread ...");
        }
    }
    
}
