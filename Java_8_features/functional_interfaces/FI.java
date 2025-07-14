package FunctionalInterfaces;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FI {

    public static void main(String[] args) {
        
        ArrayList<Integer> al = new ArrayList<>();
        al.add(2);
        al.add(1);
        al.add(6);
        al.add(5);
        System.out.println(al);

        Predicate<Integer> p1 = num->num%2==0;
        Predicate<Integer> p2 = num->num>30;
        // for(Integer value : al){
        //     if(p1.negate().test(value)){
        //         System.out.println(value);
        //     }
        // }

        Function<Integer,Integer> F1 = i-> i*i;
        Function<Integer,Integer> F2 = i->{
            int p = i*i*i;
            return p*2;
        };
        // for(Integer value : al){
        //     System.out.println(F1.compose(F2).apply(value));
        // }  
        // System.out.println(al);

        Consumer<Integer> c1 = i-> System.out.println(i*i);
        Consumer<Integer> c2 = i-> System.out.println(i*2);
        // for(Integer value: al){
        //     c1.andThen(c2).accept(value);
        // }

        Supplier<String> s1 = ()->{
            String otp ="";
            for(int i=0;i<=9;i++){
                otp= otp + Math.random()*10;
                System.out.println(otp);
            }
            return otp;
        };
        System.out.println(s1.get());
    }
    
}
