package ReferenceTypes;

// Demo for strong reference type.
class RefExample1{

}
public class ReferenceDemo {

    public static void main(String[] args) {
    
        RefExample1 ref = new RefExample1(); // creating an object and here r is strong reference.
        
        // Nullifying the refernce variable.
        ref = null; // This makes it eligible for garbage collection.
        
    }
    
}
