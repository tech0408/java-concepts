package Serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

// Demo class for custom serialization/deserialization of multiple objects.
class Account2 implements Serializable{

    String uname = "sawan";
    transient String password = "kumar";
    transient int pin = 1105;

    private void writeObject(ObjectOutputStream os) throws Exception{

        // Use default serialization.
        os.defaultWriteObject();

        // Encrypt the password and pin.
        String encPass = "1234"+password;
        int encPin =1105+2222;

        // Custom serialization of encPass and encPin.
        os.writeObject(encPass);
        os.writeInt(encPin);
    }

    private void readObject(ObjectInputStream is) throws Exception{

        // default deserialization

        is.defaultReadObject();
        //Account2 act2 = (Account2)is.defaultReadObject();

        // Decrypt password and pin.
        // Custom deserialization. [Deserialize in the same order as we have done serialization]
        String encPassword = (String)is.readObject();
        int encPin = is.readInt();
        password = encPassword.substring(4);
        pin = encPin-2222;

    }
}
public class CustomSerialDemo2 {

    @SuppressWarnings("resource")
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        
        Account2 act = new Account2();

        FileOutputStream fos = new FileOutputStream("abc.ser");
        ObjectOutputStream os = new ObjectOutputStream(fos);

        os.writeObject(act); // Serialization of object.
        
        FileInputStream fis = new FileInputStream("abc.ser");
        ObjectInputStream is = new ObjectInputStream(fis);

        Account2 ac2 = (Account2)is.readObject();
        System.out.println(ac2.uname + ": "+ ac2.password+ ":"+ ac2.pin);

    }
    
}
