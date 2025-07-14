package FunctionalInterfaces;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public class FI2 {

    public static void main(String[] args) {
        
        BiPredicate<Integer,Integer> bp1 = (i,j)-> (i+j)%2 ==0;
        BiPredicate<Integer,Integer> bp2 = (i,j)-> (i*j)%2 ==0;
        BiFunction<Integer,Integer,Boolean> bf = (i,j)->{
            if((i+j)%2==0){
                return true;
            }
            else{
                return false;
            }
        };

        BiConsumer<Integer,Integer> bc = (a,b)->{
            System.out.println("Sum is : "+ (a+b));
        };
        System.out.println(bp1.and(bp2).test(2,3));
        System.out.println(bp1.or(bp2).test(2,3));
        System.out.println(bp1.or(bp2).negate().test(2,3));
        //System.out.println(bf.apply(2,2));
        //bc.accept(3,4);
    }
    
}
