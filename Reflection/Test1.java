package Reflection;

import java.lang.reflect.Modifier;

/*
 * This class will now call the Reflection API to get details about 
 * the Employee class.
 */
public class Test1 {

    public static void main(String[] args) throws ClassNotFoundException {
        
        // forName() will look for specified class in current location, java predefined library location
        // and in the env class path. If not found at any of these 3 places then JVM returns
        // ClassNotFoundException.
        //Class c = Class.forName("EmployeeReflect1");

        //EmployeeReflect1 e = new EmployeeReflect1();
        Class c = EmployeeReflect1.class;

        System.out.println("Name of the class : "+ c.getName());

        // getSuperClass() returns Class object and on that we are calling
        // getName() method
        System.out.println("Super class of this class: "+ c.getSuperclass().getName());

        Class [] interfaces = c.getInterfaces(); // Get the interfaces as a list of Class [].
        for(Class c1: interfaces){
            System.out.println("Interface :"+ c1.getName());
        }

        int i = c.getModifiers(); //gets the modifiers associated with the class.
        System.out.println("Access modifiers associated with class: "+ Modifier.toString(i));

    }
    
}
