package thread_local;

class ParentThread1 extends Thread{

    public static InheritableThreadLocal<String> tl = new InheritableThreadLocal<>(){

        public String childValue(String p){
            return "CC";
        }
    };

    // To set custom value for child we can override the childValue().

    public void run(){

        tl.set("PP");
        System.out.println("Parent thread value .... "+ tl.get());
        ChildThread1 ct = new ChildThread1();
        ct.start();
    }
}

class ChildThread1 extends Thread{

    @Override
    public void run() {
        System.out.println("child thread value .... "+ ParentThread1.tl.get());
    }
}

public class ThreadLocal5 {

    public static void main(String[] args) {

        ParentThread1 pt = new ParentThread1();
        pt.start();
    }
}
