package Serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
 *  Serialize and deserialize multiple objects.
 *  Demo of order of serialzation. Objects should be deserialized 
 *  in the same order in which they were serialized.
 */
class Dog1 implements Serializable {

    int i=10;
    int j=20;
}

class Cat1 implements Serializable {

    int i =30;
    int j=40;
}

class Rat1 implements Serializable {

    int i=50;
    int j=60;
}

public class SerialDemo2 {

    @SuppressWarnings("resource")
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Dog1 d = new Dog1();
        Cat1 c = new Cat1();
        Rat1 r = new Rat1();

        FileOutputStream fos = new FileOutputStream("abc.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(d); // serialize Dog object
        oos.writeObject(c); // serilaize Cat Object
        oos.writeObject(r); // serialize Rat object

        FileInputStream fis = new FileInputStream("abc.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        
        /*
         * Order of deserialization is important.
         * Objects should be deserialized in the same order in which they 
         * were serailized. [ It is difficult to remember this order]
         * 
         * On changing the order of deserialization, we get issues.
         * ClassCastException is what we get.
         */
        Dog1 d2 = (Dog1) ois.readObject(); // Deserailize Dog object
        System.out.println(d2.i + ":"+ d2.j);

        Cat1 c2 = (Cat1) ois.readObject(); // Deserialize Cat object
        System.out.println(c2.i + ":" +c2.j);

        Rat1 r2 = (Rat1) ois.readObject(); // Deserialize Rat object
        System.out.println(r2.i+ ":"+ r2.j);
        
    }
    
}
