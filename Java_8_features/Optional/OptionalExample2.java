import java.util.Optional;

public class OptionalExample2 {

    public static String get(){
        return "custom default value";
    }

    public static void main(String[] args) {
        

        Optional<String> op = Optional.of("Hello Sawan");

        // check if the value is present.
        if(op.isPresent()){

            // If present, then get and print the value.
            // It is always advised to use get() method after invoking ifPresen().
            // If not done and value is not present, then we get NoSuchElementException.
            System.out.println("Value is : "+ op.get());
        }

        // handling default values.
        Optional<String> op1 = Optional.ofNullable(null);
        String val = op1.orElse("default value"); // If value is not present, then only it returns default value.
        System.out.println("Default value: "+ val);

        // Handling default values 2.
        Optional<String> op2 = Optional.ofNullable(null);
        String val2 = op2.orElseGet(OptionalExample2::get);
        System.out.println("Default value 2: "+ val2);


        // Throw exception
        Optional<String> op3 = Optional.ofNullable(null);
        String val3 = op3.orElseThrow(()-> new IllegalAccessError("test"));
        System.out.println("Exception: "+ val3);
    }
    
}
