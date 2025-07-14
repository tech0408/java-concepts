import java.util.concurrent.atomic.AtomicInteger;

class AtomicEx {

    private AtomicInteger at = new AtomicInteger(0);

    public void increment(){
        at.incrementAndGet();
    }

    public int getCount(){
        return at.get();
    }
}

public class AtomicVariable {

    public static void main(String[] args) throws InterruptedException {

        AtomicEx ex = new AtomicEx();
        Runnable r = ()->{
            for(int i=1;i<=1000;i++){
                ex.increment();
            }
        };

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);

        t1.start();
       // t2.start();

        t1.join();
       // t2.join();

        System.out.println(ex.getCount());
    }
}
