package functional_interfaces.why_lambda_expression;

/*
 * class to write lambda expression for new Thread creation.
 */
public class LambdaExampleThread {

    public static void main(String[] args) {
        
        // Lambda expression for Runnbale interface.
        Runnable r = ()->{
            for(int i=1;i<=10;i++){
                System.out.println("Child Thread...");
            }
        };

        Thread t = new Thread(r);
        t.start();

        for(int i=1;i<=10;i++){
            System.out.println("Main Thread");
        }

    }
    
}
