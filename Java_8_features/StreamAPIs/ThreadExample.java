package StreamAPIs;

class Sample{

    String name;

    Sample(String name){
        this.name=name;
    }
}

class Thread1 extends Thread{

    Sample sample;

    Thread1(Sample sample){
        this.sample=sample;
    }


    public void run(){
        System.out.println("Thread1 executes.");
        synchronized(sample){
            sample.name ="Sawan";
            sample.notify();
        }
        //System.out.println(Thread.currentThread().getThreadGroup().getName());
        
    }

}

class Thread2 extends Thread{

    Sample sample;

    Thread2(Sample sample){
        this.sample = sample;
       // this.t1 = t1;
    }

    public void run(){

        System.out.println("Thread2 executes.");
       // System.out.println(Thread.currentThread().getThreadGroup().getParent().getName());
       synchronized(sample){

        try {
            sample.wait();
            System.out.println("Value is :"+ sample.name);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       }
        
    }
}

public class ThreadExample {

    public static void main(String[] args) throws InterruptedException {
        
        Sample sample = new Sample("Rishika");

        Thread1 t1 = new Thread1(sample);
        Thread t2 = new Thread2(sample);
        t1.start();
        t2.start();

       // t2.sleep(10000);
    }


    
}
