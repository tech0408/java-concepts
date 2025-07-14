package Cloning;

/*
    This class is to demonstrate how we create copy of objects using cloneable.
    Object class clone() provides shallow cloning as the default cloning.
 */

class Cat {
    int j;

    Cat(int j){
        this.j=j;
    }
}
class Dog implements Cloneable {

    Cat cat;
    int i;
    Dog(Cat cat, int i){
        this.cat=cat;
        this.i=i;
    }

    public Object clone() throws CloneNotSupportedException{
        // calling the default clone of Object class.
        return super.clone();
    }
}


public class ShallowCloningDemo {
    public static void main(String [] args) throws CloneNotSupportedException{

            Cat cat = new Cat(20); // Creating cat class object.
            Dog d = new Dog(cat, 10); // Creating dog class object.
            System.out.println(d.i +":"+ d.cat.j);
            // Cloning Dog object.
            Dog d1 = (Dog) d.clone();
            d1.i = 44;
            d1.cat.j =56;
            System.out.println(d.i +":"+ d.cat.j);
    }
}
