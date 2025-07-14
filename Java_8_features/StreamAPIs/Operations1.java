package StreamAPIs;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Operations1 {

    public static void main(String[] args) {
        
        List<Integer> al = new ArrayList<>();
        al.add(12); al.add(33); al.add(34);al.add(5);

        List<Integer> all = new ArrayList<>();
        all.add(121); all.add(332); all.add(341);all.add(512);

        Set<Integer> setl = new HashSet<>();
        setl.add(33); setl.add(45); setl.add(44);

        Set<Integer> setll = new HashSet<>();
        setl.add(331); setl.add(45); setl.add(443);

        List<Set<Integer>> intList = new ArrayList<>();
        intList.add(setl); intList.add(setll);

        Predicate<Integer> p1 = e->e%2==0;

        /*
         * filter() -> filter elements based on the predicate.
         * When we do stream() on list of integers, then the filter()
         * is configured to accept a lambda expression for Predicate
         * which accepts type Integer.
         */
        al.stream().filter(p1).forEach(System.out::println);

        /*
         * map() -> transforms each element of the stream using Function.
         * When we do stream() on list of integers, then map(), then the 
         * Function is configured such that it accepts an integer and 
         * returns integer.
         */

        Function<Integer,Integer> f1 = e->e+1;
        al.stream().map(f1).forEach(System.out::println);


        /*
         * flatMap() -> transforms each element into a stream() and
         * flattens the result
         */

        List<Integer> newList = intList.stream().flatMap(e->e.stream()).filter(e->e%2==0).collect(Collectors.toList());
        System.out.println(newList);

        List<Integer> newListt = intList.stream().flatMap(e->e.stream()).collect(Collectors.toList());
        System.out.println(newListt);

        
    }
    
}
