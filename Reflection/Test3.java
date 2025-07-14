package Reflection;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Test3 {

    public static void main(String[] args) {
        
        Class c = EmployeeReflect3.class;

        // Get the Methods declared in the class.
        Method [] mtds = c.getDeclaredMethods(); // gets all the methods declared inside the class.

        for(Method m : mtds){

            System.out.println("Method name: "+ m.getName());
            System.out.println("Method return type : "+ m.getReturnType().getName());
            
            // Method modifiers.
            int i = m.getModifiers();
            System.out.println("Method modifiers : "+ Modifier.toString(i));

            // Method parameters
            Class [] params = m.getParameterTypes();
            for(Class param: params){

                System.out.println("Parameter name :"+ param.getName());
                System.out.println("Parmaeter type : "+ param.getTypeName());
            }

            // Exception list
            Class [] exceptions = m.getExceptionTypes();
            for(Class exc : exceptions){
                System.out.println("Exception name :"+ exc.getName());
                System.out.println("Exception type: "+ exc.getTypeName());
            }
        }
    }
    
}
