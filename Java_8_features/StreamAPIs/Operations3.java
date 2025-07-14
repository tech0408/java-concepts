package StreamAPIs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Operations3 {

    public static void main(String[] args) {
        
        List<Integer> al = Arrays.asList(1,2,3,4);
        List<Integer> alll = new ArrayList<>(); 
        List<Integer> filterList = new ArrayList<>();
        
        List<Integer> all = al.stream().peek(filterList::add).filter(e->e%2==0).collect(Collectors.toList());
        //System.out.println(all);
        //System.out.println(filterList);

        /*
         * forEach() -> Accepts Consumer FI.
         * 
         */

        Consumer<Integer> consumer = i-> {
            System.out.println(i);
        };
        al.stream().forEach(consumer);

        /*
         * reduce() -> Performs a reduction on the elements of the stream
         * to produce a single result.
         * identity -> initial value of the reduction ops and default result if
         * stream is empty.
         * accumulator -> a function that takes two parameters-> a partial result of
         * reduction ops and the next element of the stream.
         * combiner -> function used to combine the partial result of the reduction ops
         * when the reduction is parallelised or when there is a mismatch between
         * types of the accumulator arguments and the type of accumulator implementation.
         */
        // here value 0 is the identity -> stores the initial value of reduction ops
        // and also the default result when stream of integer values is empty.

        /*
         * lambda expression (subtotal,next)-> subtotal+next; is the accumulator
         * it takes the partial sum of the integer values and the next element in the stream.
         */
        System.out.println(alll.stream().reduce(0,(subtotal,next)-> subtotal+next));
        // Alternate
        alll.stream().reduce(0, Integer::sum);


        // Given a list of characters, combine them to form a string.
        List<String> str = Arrays.asList("s","a","w","a","n");
        String s = str.stream().reduce("",(parStr,nextString)-> parStr+nextString);
        System.out.println("Concat the strings");
        System.out.println(s);

        // Altenrate
        System.out.println(str.stream().reduce("",String::concat));

        // Parallel Stream
        // When dealing with large data set where order of elements in the stream 
        // is not important.

        al.parallelStream().reduce(0,Integer::sum);
    }
}
