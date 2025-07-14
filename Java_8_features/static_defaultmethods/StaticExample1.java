package static_defaultmethods;


interface StaticExam1{

    // Static method of interface are not by default available to the implementing classes.
    // These methods can only be called using the Interface name.
    public static void m1(){
        System.out.println("Static m1 called");
    }
}

// Non implementing class.
public class StaticExample1 {

    public static void main(String[] args) {
        
        StaticExam1.m1();
    }
    
}

// implementing class.
class StaticExample2 implements StaticExam1{

    public static void main(String[] args) {
        
        StaticExam1.m1();
    }
    
}
