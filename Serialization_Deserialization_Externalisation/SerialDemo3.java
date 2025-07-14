package Serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Dog2 implements Serializable{

    int i=10;
    int j=20;
}

class Cat2 implements Serializable{

    int i=30;
    int j=40;
}

class Rat2 implements Serializable{

    int i=50;
    int j=60;
}

public class SerialDemo3 {

    @SuppressWarnings("resource")
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Dog2 d = new Dog2();
        Cat2 c = new Cat2();
        Rat2 r = new Rat2();

        FileOutputStream fos = new FileOutputStream("abc.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(d);
        oos.writeObject(c);
        oos.writeObject(r);

        FileInputStream fis = new FileInputStream("abc.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);

        // Loop condition can be put only when number of objects serialized is known.

        
        for(int i=1;i<=3;i++){

            Object ob = ois.readObject();
            // Try with switch -> java latest feature
            if(ob instanceof Dog2){
                Dog2 d2 = (Dog2)ob;
                System.out.println(d2.i+ ":"+ d2.j);
            }
            else if (ob instanceof Cat2){
                Cat2 c2 = (Cat2)ob;
                System.out.println(c2.i+ ":"+c2.j);
            }
            else {
                Rat2 r2 = (Rat2)ob;
                System.out.println(r2.i+ ":"+r2.j);
            } 
        }
        
    }
    
}
