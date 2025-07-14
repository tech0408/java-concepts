package ReferenceTypes;

import java.lang.ref.WeakReference;

class RefExample2{

    public void show(){
        System.out.println("Called show method");
    }
}
public class WeakReferenceDemo {

    public static void main(String[] args) {

        RefExample2 re = new RefExample2(); // creating object to which re points.
        re.show();
        
        // Creating a weak reference for the object to which re points to.
        WeakReference<RefExample2> wr = new WeakReference<RefExample2>(re);

        re = null; // Object pointed to by re is now eligible for GC.

        // But until it is garbage collected by JVM, it can be obtained by using
        // weak reference.
        // It will be garbage collected only when JVM needs memory.
        re = wr.get(); // Mechanism to get back the object using weakReference.

        re.show();
    }
    
   
}
