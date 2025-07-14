package Serialization;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;


/*
 * Demo for externalisation -> when we want to serialize part of object
 * and not the complete object.
 */

class Person implements Externalizable{

    String name;
    int i;
    int j;

    // transient varibale has no significance in externalisation.
    // because we will not serial the fields which we do not want to persist.

    /*
     * This constructor is mandatory, as using this JVM creates new object
     * at the time of deserialization.
     */
    public Person(){
        System.out.println("Person class constructor called.");
    }

    public Person(String name, int i, int j){
        this.name=name;
        this.i=i;
        this.j=j;
    }

    // Method which will serialize the part of object.
    public void writeExternal(ObjectOutput os) throws IOException{

        // multiple fields.
        os.writeObject(name);
        os.writeInt(i);
    }

    public void readExternal(ObjectInput is) throws IOException, ClassNotFoundException{

        System.out.println("Inside read external...");
        System.out.println(name+":"+i+":"+j);
        name = (String)is.readObject();
        i = is.readInt();
    }

    
}

public class ExternalisationDemo1 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Person p = new Person("sawan",10,20);

        FileOutputStream fos = new FileOutputStream("abc.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        System.out.println("Before serialization...");
        oos.writeObject(p); // Serializing Person object.

        /*
         * As soon as JVM sees writeObject(), it sees if Person implements 
         * Externalizable interface. If yes, then it calls the writeExternal()
         */

        FileInputStream fis = new FileInputStream("abc.ser");
        ObjectInputStream is = new ObjectInputStream(fis);

        System.out.println("Before deserialization...");
        Person ps = (Person)is.readObject();

        System.out.println(ps.name+ ":"+ps.i+ ":"+ ps.j);

        /*
         * Here again JVM invokes readExternal() of Person class by following steps-
         * 1. JVM first creates the new object using public no-args constructor.
         *    If Person class does not contain a non-args constructor, it throws InvalidClassException.
         * 2. If the object creation is successful in step 1, it then invokes
         *    readExternal() on this newly created object, which then deserialises the fields.
         */
    }

    
    
}
