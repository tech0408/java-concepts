package Serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

// If the class does not implement Serializable interface, then we get NotSerializableException
// Serializable is a marker interface.
class Dog implements Serializable {

    int i=10;
    int j=20;
}

public class SerialDemo1 {
    

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Dog d = new Dog();

        // Serialization -> Writing state of Object to file.
        FileOutputStream fos = new FileOutputStream("abc.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(d);

        // Deserialization -> Reading the state of Object from file.
        FileInputStream fis = new FileInputStream("abc.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);

        Dog d2 = (Dog) ois.readObject();
        System.out.println(d2.i + ":" + d2.j);
        
    }
}
