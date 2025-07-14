package StreamAPIs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Practice {

    public static void main(String[] args) {
        
        List<Integer> al = new ArrayList<>();

        al.add(3);al.add(15);al.add(8);al.add(35);

        //Separate odd and even numbers.
        List<Integer> evenList = al.stream().filter(i->i%2==0).collect(Collectors.toList());
        List<Integer> oddList = al.stream().filter(i->i%2!=0).collect(Collectors.toList());
        System.out.println(evenList);
        System.out.println(oddList);

        // Partition the list in even/odd numbers.
        Map<Boolean,List<Integer>> outList = al.stream().collect(Collectors.partitioningBy(i->i%2==0));
        System.out.println(outList);

        // Frequency of each character in string
        // LinkedHashMap helps in preserving the order of insertion of elements.
        String s = "sawan";
        List<Character> chList = s.chars().mapToObj(c->(char)c).collect(Collectors.toList());
        HashMap<Character, Long> mp = chList.stream().collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,Collectors.counting()));
        System.out.println(mp);

        // Sort the list in reverse order.
        al.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

        // Print multiples of 5 from the list.
        System.out.println("--------------Multiples of 5------------");
        al.stream().filter(i->i%5==0).forEach(System.out::println);

        // Merge two unsorted arrays into single sorted array.
        int [] arr1 = Arrays.stream(212,3,56,12);
        
        
    }
    
}
