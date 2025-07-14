package Reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/*
 * This class demonstrates how we cn call the reflection API
 * to fetch the variables details.
 */
public class Test2 {

    public static void main(String[] args) {
        
        Class c = EmployeeReflect2.class;

        // Get the variable list.
        Field [] fldss = c.getFields(); // Gets all the public fields from current class and also
        // the public fields from the super class.
        Field [] flds = c.getDeclaredFields(); // gets all declared fields in the current class as the Field []
        for(Field f : flds){
            System.out.println("Name of the variable : "+ f.getName());
            System.out.println("Type of the variable: "+ f.getType().getName());
            //System.out.println("Value of the variable : "+ f.get());

            int i = f.getModifiers();
            System.out.println("Modifiers of the varible : "+ Modifier.toString(i));
        }
         
    }
    
}
