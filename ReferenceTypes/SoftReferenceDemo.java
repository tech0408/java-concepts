package ReferenceTypes;

import java.lang.ref.SoftReference;

class RefExample3{

    public void show(){
        System.out.println("Calling show method : soft reference");
    }
}

public class SoftReferenceDemo {

    public static void main(String[] args) {
        
        RefExample3 rf = new RefExample3(); // creating instance of RefExample3

        rf.show();

        // Now creating a soft Reference which points to object pointed to by rf.
        SoftReference<RefExample3> softRef = new SoftReference<RefExample3>(rf);

        // Now making the rf null and making it is eligible for garbage collection.
        // Objects are eligible for GC but it will be garbage collected only when JVM is need
        // of memory badly or it runs out of memory.
        rf = null;

        // Getting back the object by the help of soft reference.
        rf = softRef.get();

        rf.show();
    }
    
}
