package functional_interfaces.why_lambda_expression;

@FunctionalInterface
interface Interf1{

    public void m2(int i, int j);
}

public class Example2 {

    public static void main(String[] args) {
        
        Interf1 interf =(i,j)-> System.out.println(i+j);
        interf.m2(4,5);
        interf.m2(23,12);
    }
    
}
