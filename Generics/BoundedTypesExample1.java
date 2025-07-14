package Generics;
import java.lang.Integer;
/*
 * Bounded types -> we can restrict the types for the generics by bounding
 * the type parameter using extends.
 * 
 * In this class, type parameter should be Number or the child class of Number.
 */
public class BoundedTypesExample1<T extends Number>{

        T obj;

        BoundedTypesExample1(T obj){
            this.obj=obj;
        }

        public T getValue(){
            return obj;
        }

        public static void main(String[] args) {
            
            BoundedTypesExample1<Integer> num = new BoundedTypesExample1<Integer>(4);
            System.out.println(num.getValue());

            // We get bound mismatch when use String as type parameter.
            //BoundedTypesExample1<String> s = new BoundedTypesExample1<String>("sawan");
        }
    
}
