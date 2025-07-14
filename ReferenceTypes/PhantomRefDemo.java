package ReferenceTypes;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

// Demo for Phantom References.
class RefExample4{

    public void show(){
        System.out.println("Show method called : phantom reference");
    }
}
public class PhantomRefDemo {
    
    public static void main(String[] args) throws InterruptedException {
        
        RefExample4 ref4 = new RefExample4(); //Creating object of type RefExample4

        ref4.show(); // invoking method on object reference.

        // Creating ReferenceQueue before creating the Phantom reference.
        ReferenceQueue<RefExample4> rQ = new ReferenceQueue<RefExample4>();
        //System.out.println(rQ);

        // Creating the phantom reference.
        PhantomReference<RefExample4> phRef = new PhantomReference<>(ref4, rQ);

        // Nullifying the reference variable and making it available for GC.
        ref4 = null; // Object is eligible for GC, but since it has phantom reference it
        // will be pushed to refQueue by JVM after calling finalize method on the obejct.


        System.gc();

        Thread.sleep(10000);

        //ref4 = phRef.get();

        // Trying to get object from the reference Queue.
        PhantomReference<RefExample4> phRef2 = (PhantomReference<RefExample4>) rQ.poll();
       // System.out.println();

       if (phRef2 != null) {
            System.out.println("Object associated with PhantomReference is finalized and enqueued in ReferenceQueue");
            ref4 = phRef2.get();
            ref4.show();
        } else {
            System.out.println("No reference in ReferenceQueue yet. GC may not have run.");
        }
    }
}
