package Generics;

/*
 * This class demonstrates how we create a custom generic class and how to create instances 
 * for such a class and use it for different types.
 */
public class GenExample <T>{

    T obj;

    GenExample(T obj){
        this.obj= obj;
    }

    // Displays the type of obj.
    public void show(){
        System.out.println("Current object is of type : " + obj.getClass().getName());

    }

    // Returns the value of obj;
    public T getValue(){
        return obj;
    }


    public static void main(String[] args) {
        
        // Creating instance for our generic class.
        GenExample<String> s = new GenExample<String>("sawan"); // String as type.
        s.show();
        System.out.println(s.getValue());

        GenExample<Integer> i = new GenExample<Integer>(4); // Integer as type.
        i.show();
        System.out.println(i.getValue());

        GenExample<Double> d = new GenExample<Double>(24.2); // Double as type.
        d.show();
        System.out.println(d.getValue());
    }
    
}
