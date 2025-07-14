package Cloning;
/*
 * This class demonstrates the deep cloning. 
 */
class Cat2{
    int j=20;

    Cat2(int j){
        this.j=j;
    }
}

class Dog2 implements Cloneable{

    Cat2 cat;
    int i;

    Dog2(Cat2 cat, int i){
        this.cat=cat;
        this.i=i;
    }

    public Object clone() throws CloneNotSupportedException{

        Cat2 cat2 = new Cat2(cat.j);
        Dog2 dog2 = new Dog2(cat2,i);
        return dog2;
    }
}
public class DeepCloningDemo {

    public static void main(String[] args) throws CloneNotSupportedException{
        
        Cat2 cat = new Cat2(20);
        Dog2 dog = new Dog2(cat,10);

        System.out.println(dog.i + ":"+ dog.cat.j);

        // Cloning
        Dog2 d1 = (Dog2) dog.clone();

        d1.i=44;
        d1.cat.j=56;

        System.out.println(dog.i + ":"+ dog.cat.j);

    }
    
}
