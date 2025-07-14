package static_defaultmethods;


// Diamond problem.

interface DefaultExam {

    default void m1(){
        System.out.println("m1 default method");
    }
}

interface DefaultExam2{
     
    default void m1(){
        System.out.println("m2 default method");
    }
}
public class DefaultExample2 implements DefaultExam, DefaultExam2{

    // We need to override the default method to avoid the diamond problem.
    public void m1(){

        // To invoke DefaultExam default method.
        // DefaultExam.super.m1();

        //To invoke DefaultExam2 default method.

        DefaultExam2.super.m1();


       // System.out.println("Own method");
    }

    public static void main(String[] args) {
        
        DefaultExample2 ex = new DefaultExample2();

        ex.m1(); // Own method is called.

    }
    
}
