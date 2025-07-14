package stream_APIs;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Example4 {

    public static void main(String[] args) {
        
        List<Integer> al = Arrays.asList(12,14,45,2,0,67);

        // Find the min element.
        // min() -> ascending order min is 1st element 
        // max() -> 
        Optional<Integer> ele = al.stream().max((i,j)-> j.compareTo(i));
        System.out.println(ele.get());
    }
    
}
