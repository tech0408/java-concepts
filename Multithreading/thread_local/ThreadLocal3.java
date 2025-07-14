package thread_local;

class CustomerThread extends Thread{

    static Integer custId=0;
    private static ThreadLocal<Integer> tl = new ThreadLocal<>(){
        protected Integer initialValue(){
            return ++ custId;
        }
    };

    CustomerThread(String name){
        super(name);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "....is executing with customer id : "+ tl.get());
    }
}

public class ThreadLocal3 {

    public static void main(String[] args) {

        CustomerThread c1 = new CustomerThread("customer 1");
        CustomerThread c2 = new CustomerThread("customer 2");
        CustomerThread c3 = new CustomerThread("customer 3");
        CustomerThread c4 = new CustomerThread("customer 4");
        c1.start();
        c2.start();
        c3.start();
        c4.start();
    }
}
