package thread_local;

class ParentThread extends Thread{

    public static ThreadLocal<String> tl = new ThreadLocal<>();

    public void run(){
        tl.set("parentThread");
        System.out.println("Parent thread value ----- "+ tl.get());
        ChildThread ct = new ChildThread();
        ct.start();
    }
}

class ChildThread extends Thread{

    public void run(){
        System.out.println("child thread value ---- "+ ParentThread.tl.get());
    }
}

public class ThreadLocal4 {
    public static void main(String[] args) {

        ParentThread pt = new ParentThread();
        pt.start();
    }
}
