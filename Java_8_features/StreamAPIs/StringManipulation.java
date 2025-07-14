package StreamAPIs;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringManipulation{

    public static void main(String args[]){

    /*
        Given a sentence containing words with delimiters, 
        form list of words by splitting based on the delimiter.

        Use the stream API for this. input eg - 
        sawan,kumar,rishika,ranjan.
    */

    String str = "sawan,kumar,rishika,ranjan";

    List<String> nameList = Stream.of(str.split(",")).map(ele-> new String(ele)).collect(Collectors.toList());
    // System.out.println(nameList);

    /*
     * Given a string, create a list of characters out of the string 
     * usign the stream API.
     */
    String word ="sawankumar";
    List<Character> charList = word.chars().mapToObj(ch->(char)ch).collect(Collectors.toList());
    // System.out.println(charList);

    /*
     * Given a string, find the occurrance of each character in the string.
     */
    String name ="sawnkumwar";
    Map<Character,Long> charFreq = name.chars().mapToObj(ch->(char)ch).collect(Collectors.groupingBy(Function.identity(),
    Collectors.counting()));

    //charFreq.forEach((ch,freq)-> System.out.println("Character : "+ ch + " with freq:"+ freq));


    // Count the number of charcters in the string.
    //System.out.println("Total characters: " + name.chars().mapToObj(ch->(char)ch).count());
    
    // First non-repeating character in the string
    String s = "sawnkuwmr";
    Map<Character,Long> chrFreq = s.chars().mapToObj(ch->(char)ch)
    .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()));
    Optional<Character> ch = chrFreq.entrySet().stream().filter(i->i.getValue()>1).map(i->i.getKey()).findFirst();
    if(ch.isPresent()){
        System.out.println(ch.get());
    }

}

}