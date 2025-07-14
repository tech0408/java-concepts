package Serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
 * Demo of object graph serialization and deserialization.
 * Object graph -> when an object has references to other objects.
 * 
 * When object graph is serialized, then the nested objects are also serialized.
 * Similarily when the object graph is deserialized, the nested objects are also
 * deserialized.
 * 
 * To serialize an object graph -> all the nseted objects should also be serailizable
 * else we will get NotSerializableException: <className>
 */

class Rat3 implements Serializable{
    int i=10;
}

class Cat3 implements Serializable{
    Rat3 r = new Rat3();
}

class Dog3 implements Serializable{

    Cat3 cat = new Cat3();

}

public class SerialDemo4 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Dog3 d = new Dog3();
        
        FileOutputStream fos = new FileOutputStream("abc.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(d); // Serializing an object graph.

        FileInputStream fis = new FileInputStream("abc.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);

        Dog3 d2 = (Dog3)ois.readObject(); // Deserializing the Dog3 object.
        System.out.println(d2.cat.r.i);
        
    }
    
}
