package thread_local;

public class ThreadLocalExample2 {

    public static void main(String[] args) {

        ThreadLocal<String> tl = new ThreadLocal<>(){
            public String initialValue(){
                return "abc";
            }
        };

        System.out.println(tl.get());
        tl.set("sawan");
        System.out.println(tl.get());
        tl.remove();
        System.out.println(tl.get());
    }
}
