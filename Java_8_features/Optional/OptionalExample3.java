import java.util.Optional;

public class OptionalExample3 {

    public static void main(String[] args) {
        
        // Appyling actions.
        Optional<String> op = Optional.of("sawan");
        op.ifPresent(v-> System.out.println(v));

        Optional<String> op1 = Optional.ofNullable(null);
        op1.ifPresent(v-> System.out.println(v)); // As value is not there, it does not print.
    
        // Transforming the value.

        Optional<String> op2 = Optional.of("karens");
        Optional<Integer> len = op2.map(v-> v.length());
        System.out.println(len.get());

        // Filtering the value.
        Optional<String> res = op2.filter(v-> v.length()>2);
        System.out.println(res.get());
    
    }

    
}
