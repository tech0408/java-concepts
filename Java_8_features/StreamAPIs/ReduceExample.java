package StreamAPIs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

class Student{

    String name;
    int age;
    List<String> city;
    double marks;
    String branch;
    Student(String name,int age, List<String> city,double marks,String branch){
        this.name=name;
        this.age=age;
        this.city=city;
        this.marks=marks;
        this.branch=branch;
    }

    public double getMarks(){
        return marks;
    }
}

public class ReduceExample {


    public static void main(String[] args) {

        List<String> city1 = Arrays.asList("patna", "bnglr", "mysore");
        List<String> city2 = Arrays.asList("patna", "delhi", "bnglr","pune");
        List<String> city3 = Arrays.asList("indore", "lucknow", "mysore");
        List<String> city4 = Arrays.asList("dhaka", "bnglr", "bbs");
        List<String> city5 = Arrays.asList("bbs", "jaipur", "nainital");
        List<Student> sL = Arrays.asList(
            new Student("sawan", 30, city1, 400, "ISE"),
            new Student("rishika", 30, city2, 450, "ISE"),
            new Student("riya", 30, city3, 460, "CSE"),
            new Student("farheen", 30, city4, 300, "ECE"),
            new Student("anjali", 30, city5, 356, "ECE"),
            new Student("tanish", 30, city5, 490, "Mech")    
        );

        // Total students in each branch.
        Map<String,Long> map = sL.stream().collect(Collectors.groupingBy(s->s.branch, Collectors.counting()));
       // System.out.println(map);

        // no of students from each city.
        Map<String,Long> map2 = sL.stream().collect(
            Collectors.groupingBy(s->s.city,Collectors.counting())
        );
        //System.out.println(map2);

        // print those students from patna having marks >350

        //Consumer<Student
        sL.stream().filter(e->e.city.equals("patna") && e.marks>350).
        forEach(s->System.out.println(s.name));

        // list of unique cities from where students belong to.
        List<String> cityNames = sL.stream().map(s->s.city).distinct().collect(Collectors.toList());
        System.out.println(cityNames);

        // unique city names [collect is set collection]
        Set<String> citySet = sL.stream().map(s->s.city).collect(Collectors.toSet());
        System.out.println(citySet);

        // unique city names in sorted order. [use treeSet]
        Set<String> cL = sL.stream().map(s->s.city).collect(Collectors.toCollection(TreeSet::new));
        System.out.println(cL);

        // sort the students based on marks.
        Comparator<Student> cmp = (s1,s2)->{

            return s1.marks>s2.marks?-1:s1.marks<s2.marks?1:0;

        };
        sL.stream().sorted(cmp).forEach(s-> System.out.print(s.name + " "));

        // Using comparator methods and in descending order.
        sL.stream().sorted(Comparator.comparing(Student::getMarks).reversed()).forEach(s->System.out.print(s.name +":"));

        // Get the list of students in ranking order for each branch.

        Map<String,List<Student>> mp =sL.stream().collect(Collectors.groupingBy(s->s.branch,
        Collectors.collectingAndThen(
            Collectors.toList(),
            list-> list.stream().sorted(
                Comparator.comparing(
                    Student::getMarks)
                    .reversed()).collect(Collectors.toList()))));

        mp.forEach((k,v)-> {
            System.out.print("Results of students in branch :"+ k + ":");
            v.stream().forEach(s->System.out.print(s.name+ " "));
            System.out.println();
        });
        //
        
        // find total marks of students.
        System.out.println(sL.stream().mapToDouble(s->s.marks).reduce(0.0,Double::sum));
        
        // Total marks for each branch.
        Map<String,Double> mpl = sL.stream().collect(Collectors.groupingBy(s->s.branch,
        Collectors.collectingAndThen(Collectors.toList(),
         list-> list.stream().mapToDouble(s->s.marks).reduce(0.0,Double::sum))
        ));

        System.out.println(mpl);
        
        //mp.forEach((k,v)-> System.out.println("students of branch: "+ k + " are : "+ v.stream().count()));

    }
    
}
