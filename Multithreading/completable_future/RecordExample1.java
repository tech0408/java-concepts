package completable_future;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class RecordExample1 {

    public record Student1(String name, int id){}
    public static void main(String[] args) {

        Student1 s1 = new Student1("sawan",12);
        Student1 s2 = new Student1("ram",10);

        List<Student1> stuList = Arrays.asList(s1,s2);

        stuList.stream().filter(e-> e.id>5).forEach(System.out::println);

        String [] sa = {"sawan","ankit","aaqil","praveen","damodara"};

        Map<Integer,List<String>> mp = Arrays.stream(sa).collect(Collectors.groupingBy(
                String::length,Collectors.toList()
        ));
        System.out.println(mp);


        //Arrays.stream()

        // Sort(descending) of length.
//        Comparator<String> cmp = (s11,s22)->{
//
//            return s11.length()>s22.length()?-1: s11.length()<s22.length()?1:0;
//        };
//        Arrays.stream(sa).sorted(cmp).toList();


       // List<String> sortedStrings = Arrays.stream(sa).sorted(Comparator.comparing(String::length).reversed()).toList();
        //sortedStrings.forEach(System.out::println);

        //sortedStrings.stream()
        System.out.println(Arrays.stream(sa).max(Comparator.comparing(String::length)));



//        System.out.println("------------------------------------");
//        String[] sortedSA= Arrays.stream(sa).sorted((s13,s23)->Integer.compare(s23.length(),s13.length())).
//                toArray(String[]::new) ;
//        System.out.println(Arrays.toString(sortedSA));
//
//
//        String[] sortedSAA= Arrays.stream(sa).sorted((a, b) -> b.length() - a.length()).
//                toArray(String[]::new) ;
//        System.out.println(Arrays.toString(sortedSAA));
        //.sorted((a, b) -> b.length() - a.length())




    }
}
