package Serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.io.Serializable;

/*
 * This class shows how do we go for custom serialization and deserialization.
 * This is needed beacuse when using the transient keyword with variables, there
 * is loss of data and we don't want to go for that loss.
 */

class Account implements Serializable{

    String uname ="sawan";
    transient String password ="kumar";

    // When we define this method inside serialised object, JVM will go for custom
    // serialisation.
    private void writeObject(ObjectOutputStream os) throws Exception{
        os.defaultWriteObject();

        // encrypt the password here.
        password = "123"+password;
        os.writeObject(password);
    }

    // Similar is the case with deserialisation.
    private void readObject(ObjectInputStream is) throws Exception{
        is.defaultReadObject();

        String encPass = (String)is.readObject();
        password = encPass.substring(3);
    }
}

public class CustomSerialDemo1 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Account ac = new Account();

        FileOutputStream fos = new FileOutputStream("abc.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(ac); // Serialization

        FileInputStream fis = new FileInputStream("abc.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);

        Account ac1 = (Account)ois.readObject();
        System.out.println(ac1.uname + ":" + ac1.password);  
    }
    
}
