package Serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

// Case2 : Parent class is not serializable and child class is serializable.
class Animal44 {
    int i=10;

    // If we do not provide a constructor, compiler by default provides
    // no args constructor.

    // Animal44(){
    //     System.out.println("Animal class constructor called");
    // }
    // Animal44(int i){
    //     System.out.println("Animal class constructor called");
    // }

    // If we provide one constructor which is the only constructor and which is
    // no args , then we will get InvalidClassException at the time of deserialization.
}

class DogExample1 extends Animal44 implements Serializable{
    int j=20;

    DogExample1(){
        // super(10);
    }
}
public class SerializableInheritenceDemo2 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        DogExample1 d = new DogExample1();
        System.out.println("Before serialization");
        // We update the values of i and j now.
        d.i =30;
        d.j= 40;
        System.out.println(d.i+ ":"+d.j);

        // On serializaing the child class object, JVM checks if the variables
        // of any non serializable parent class is used. If yes, then it replaces
        // the parent class instance variables value from original value to defualt value.

        FileOutputStream fos = new FileOutputStream("abc.ser");
        ObjectOutputStream os = new ObjectOutputStream(fos);
        os.writeObject(d);

        // On deserialisation, JVM looks for non serializable parent class and executes the
        // instance block flow which includes -
        // identifying instance variables, assigning values, calling no args constructor.
        // so default values are now replaced with original values in instance block.

        FileInputStream fis = new FileInputStream("abc.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);

        System.out.println("After deserialization..");
        DogExample1 dg = (DogExample1)ois.readObject();
        System.out.println(dg.i+ ":"+ dg.j);
    }
    
}
