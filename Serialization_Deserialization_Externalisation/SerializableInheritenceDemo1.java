package Serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

// Case1 : Parent class is serializable and child class is non-serializable.
class Animal4 implements Serializable{
    int i=10;
}

class DogExample extends Animal4{
    int j=20;
}

public class SerializableInheritenceDemo1 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        DogExample dog = new DogExample(); 
        System.out.println("Before serialization");
        System.out.println(dog.i + ":"+ dog.j);

        // Serialization of child Object which inherits a serializable parent class.
        FileOutputStream fos = new FileOutputStream("abc.ser");
        ObjectOutputStream os = new ObjectOutputStream(fos);
        os.writeObject(dog);

        // Deserialization of child class object.
        FileInputStream fis = new FileInputStream("abc.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);

        DogExample d2 = (DogExample) ois.readObject();
        System.out.println("After deserialization");
        System.out.println(d2.i + ":"+ d2.j);
        
    }
    
}
