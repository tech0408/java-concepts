package Serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
 * Demo of the transient variables.
 * 1. transient 
 * 2. static transient
 * 3. final transient
 */
class Dog4 implements Serializable{
    
    int i=10;
    /*
        When there is sensitive data which we do not want to persist in hard disk.
        On identifying a variable as transient, JVM replaces the value by default value.
        
        Transient modifier/keyword can be used only with varibale and not with class/method.
    */
    transient int j=20;
    /*
     * declaring a var is static attaches it to class and not to instance of class.
     * Hence static variables do not participate in serialization.
     * so having transient keyword with static does not make any sense.
     */
    static transient int k =50;

    /*
     * defining a variable with final makes it constant, so value is replaced during
     * compile time only. Final varibales participate in serialization but with value and
     * not as variables.
     * 
     * so it has no impact when using with transient keyword.
     */
    final transient int l = 40;
}

public class SerialDemo5 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Dog4 d = new Dog4();

        FileOutputStream fos = new FileOutputStream("abc.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(d);

        FileInputStream fis = new FileInputStream("abc.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        
        Dog4 d2 = (Dog4)ois.readObject();

        System.out.println(d2.i + ":"+ d2.j + ":"+ d2.k +":"+ d2.l);
  
    }
    
}
