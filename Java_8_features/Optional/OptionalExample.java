import java.util.Optional;

public class OptionalExample {

    public static void main(String[] args) {
        
        Optional<String> optionalEmpty = Optional.empty(); // Optional without any value.
        //System.out.println(optionalEmpty.get());

        // Optional with non-null value.
        Optional<String> opWithValue = Optional.of("Sawan");
        //System.out.println(opWithValue.get()); 

        // Passing null to Optional.of : creating with null value.
        //Optional<String> opWithValueNull = Optional.of(null);
        //System.out.println(opWithValueNull.get()); // Throws null pointer exception.

        Optional<String> opwithNullable = Optional.ofNullable("kumar");
        System.out.println(opwithNullable.get());

        Optional<String> opwithNullable2 = Optional.ofNullable(null); // This can hold null
        System.out.println(opwithNullable2.get());

    }



    
}
