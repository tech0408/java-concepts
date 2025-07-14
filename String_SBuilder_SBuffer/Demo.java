package String_SBuilder_SBuffer;

/*
 * Class to demo String, StringBuffer and StringBuilder classes.
 * String class is immutable but StringBuffer and StringBuilder classes are mutable. (meaning the values can be changed)
 * 
 * StringBuffer is thread safe and is synchronized but StringBuilder is not.
 * StringBuilder is relatively faster than the StringBuffer as it does not have to take extra overhead to 
 * ensure synchronization.
 */

public class Demo{

    public static void concatString(String s){

        // String class uses + operator for concatenation.
        s = s + "kumar";
    }

    public static void concatStringBuffer(StringBuffer s1){

        // StringBuffer uses append() for concatenation.
        s1.append("Kumar");
    }

    public static void concatStringBuilder(StringBuilder s2){

        // StringBuilder uses append() for concatenation.
        s2.append("Kumar");
    }
    public static void main(String [] args){

        // String class object.
        String s = new String("Sawan");
        concatString(s);

        // StringBuffer class object.
        StringBuffer s1 = new StringBuffer("Sawan");
        concatStringBuffer(s1);

        // StringBuilder class object.
        StringBuilder s2 = new StringBuilder("Sawan");
        concatStringBuilder(s2);

        // Value is not chnaged for String object.
        System.out.println(s);

        // Values are changed for StringBuffer and StringBuilder objects.
        System.out.println(s1);
        System.out.println(s2);
    }
    
}