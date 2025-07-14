package StreamAPIs;
import java.util.*;

public class Operations2 {

    public static void main(String[] args) {
        
        List<Integer> al = new ArrayList<>();
        al.add(12);al.add(13);al.add(14);al.add(15);al.add(15);al.add(12);

        System.out.println(al);

        /*
         * distinct() -> removes duplicate elements from the stream.
         */
        System.out.println("Distinct elements...");
        al.stream().distinct().forEach(System.out::println);

        /*
         * sorted() -> sorts the elements of the stream either naturally or
         * using a custom compartaor
         */
        System.out.println("Sorted elements...");
        /*
         * Comparator has one method compare(obj1,obj2)
         */
        Comparator<Integer> cmp = (a,b)->{
            return a>b? -1:(a<b)?1:0;
        };
        al.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

        /*
         * limit() -> truncates the stream to a specified number of elements.
         */

        System.out.println("Get first three elements");
        al.stream().limit(3).forEach(System.out::println);

        /*
         * skip() -> skip the first few elements of the stream.
         */
        System.out.println("Skip the first few elements");
        al.stream().skip(2).forEach(System.out::println);

        /*
         * peek() -> performs an operation on each element of the stream 
         * without modifying the stream.
         * 
         * note: it is not used as a terminal operation eg for each.
         */

        System.out.println("Using peek method");
        
    }
    
}
