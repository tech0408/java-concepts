package functional_interfaces.predefined_functional_interfaces;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

// Predicate, BiPredicate and Predicate Chaining and(), or(), negate().
public class Example2 {

    public static void main(String[] args) {

        // Check if the number is even or not.
        Predicate<Integer> p1 = i->i%2==0; // Predicate has SAM test() which takes an input and returns boolean.
        System.out.println("---------------------");
        System.out.println(p1.test(24));

        //Check if the number is prime or not.
        Predicate<Integer> p2 = num->{
            int c=0;
            for(int i=1;i<=num;i++){
                if(num%i==0){
                    c++;
                }
            }
            if(c==2){
                return true;
            }
            else{
                return false;
            }
        };

        System.out.println("Predicate 2 -------------------------");
        System.out.println(p2.test(5));
        System.out.println(p2.test(12));

        //Check if string is palindrome or not.
        Predicate<String> p3 = s->{

            int first =0;
            int last = s.length()-1;
            
            while(first<=last){
                if(s.charAt(first)==s.charAt(last)){
                    first++;
                    last--;
                }
                else{
                    return false;
                }
            }
            return true;
        };

        System.out.println("Predicate 3 --------");
        System.out.println(p3.test("madam"));
        System.out.println(p3.test("sawan"));
        System.out.println(p3.test("maadam"));

        // Check if number is greater than 100.
        Predicate<Integer> p4 = num -> num>100;
        System.out.println("Predicate 4 --------------------");
        System.out.println(p4.test(120));
        System.out.println(p4.test(12));

        // Take two numbers and check if their sum is greater than 15
        BiPredicate<Integer,Integer> p5 = (n1,n2)-> (n1+n2)>15;
        System.out.println("Bipredicate 1 --------------------");
        System.out.println(p5.test(2,10));
        System.out.println(p5.test(12,4));

        // Take two strings and check if sum of their lengths is greater than 10.
        BiPredicate<String,String> p6 = (s1,s2) -> (s1.length()+s2.length())>10;
        System.out.println("Bipredicate 2 -----------------------");
        System.out.println(p6.test("saawan","kumar"));
        System.out.println(p6.test("ashu","abc"));

        // Check if number is even and greater than 10.
        Predicate<Integer> pc1 = num-> num%2==0;
        Predicate<Integer> pc2 = num-> num>10;
        System.err.println("Chaining 1 -------------------------");
        System.out.println(pc1.and(pc2).test(15));
        System.out.println(pc2.and(pc1).test(14));
        //System.out.println((n->n%2==0).and(n->n>10).test(34));

        // Check if string is palindrome and length greater than 4.
        Predicate<String> pc4 = s-> s.length()>4;
        System.out.println("Predicate chaining 2-----------------");
        System.out.println(p3.and(pc4).test("madam"));
        System.out.println(pc4.and(p3).test("daere"));

        // Check if number is odd or greater than 10.
        Predicate<Integer> pc5 = n-> n%2!=0;
        Predicate<Integer> pc6 = n-> n>10;
        System.out.println("Predicate chaining 3 ------------------");
        System.out.println(pc5.or(pc6).test(11));
        System.out.println(pc6.or(pc5).test(3));

        //	10. Check if string length is 10 or starts with A.
        Predicate<String> pc7 = s-> s.length()>10;
        Predicate<String> pc8 = s-> s.startsWith("A");
        System.out.println("Predicate Chaining 4 ------------------");
        System.out.println(pc7.or(pc8).test("saw"));
        System.out.println(pc7.or(pc8).test("Ashu"));

        // Take two strings and check if their length sum is 10 or first string starts with P
        BiPredicate<String,String> pc9 = (s1,s2) -> s1.length()+s2.length()>10;
        BiPredicate<String, String > pc10 = (s1,s2)->s1.startsWith("P");
        System.out.println("Predicate Chaining 5 .................");
        System.out.println(pc9.or(pc10).test("Pawan","kumar"));  
        
        // 	12. Take two numbers and check if their sum is not greater than 10.
        BiPredicate<Integer,Integer> bp = (n1,n2)-> n1+n2>10;
        System.out.println("Predicate chaining 6 ------------------");
        System.out.println(bp.negate().test(2,4));
    }
    
}
