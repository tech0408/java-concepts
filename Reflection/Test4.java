package Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

public class Test4 {

    public static void main(String[] args) {
        
        Class c = EmployeeReflect4.class;

        Constructor [] con = c.getConstructors();

        for(Constructor cons : con){
            System.out.println("Constructor name : "+ cons.getName());
            
            int i = cons.getModifiers();
            System.out.println("Constructor access modifiers : "+ Modifier.toString(i));

            Class [] paramList = cons.getParameterTypes();
            for(Class cl : paramList){

                System.out.println("Param name :"+ cl.getName());
            }

            Class [] exceptions = cons.getExceptionTypes();
            for(Class cls : exceptions){
                System.out.println("Exception name :"+ cls.getName());
            }

            System.out.println("-----------------------------------");
        }
    }
    
}
