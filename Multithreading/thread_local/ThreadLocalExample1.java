package thread_local;

public class ThreadLocalExample1 {
    public static void main(String[] args) {

        ThreadLocal<String> tl = new ThreadLocal<>();

        System.out.println(tl.get());
        tl.set("sawan");
        System.out.println(tl.get());
        tl.remove();
        System.out.println(tl.get());
    }
}
