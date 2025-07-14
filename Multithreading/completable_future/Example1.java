package completable_future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


/*
    1. CompletableFuture is used for asynchronous, non blocking operations.
    2. Problems before CompletableFuture -> no callback support, blocking operations, no chaining.
    3. Chaining tasks -> .thenApply(Function), .thenAccept(Consumer), .thenCompose(), .thenCombine(Function).
 */
public class Example1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<String> cf = CompletableFuture.supplyAsync(()-> "Hello");
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(()-> "World");
        // supplyAsync() will create a separate thread, accepts a supplier FI lambda expression.
        cf.thenAccept(System.out::println);
        cf.thenApply(a-> a+ "world!!").thenAccept(System.out::println);
        //System.out.println(cf.get());

        // Composing the CF.
        CompletableFuture<String> result = cf.thenCombine(cf1,(a,b)-> a+b);
        System.out.println(result.get());


        // Multiple independent CompletealeFuture as parallel tasks.
        CompletableFuture<String> cfs1 = CompletableFuture.supplyAsync(()->"sawan");
        CompletableFuture<String> cfs2 = CompletableFuture.supplyAsync(() -> "kumar");

        CompletableFuture<Void> result2 = CompletableFuture.allOf(cfs1,cfs2);

        // Wait for both features to complete.
        result2.join();

        System.out.println(cfs1.get());
        System.out.println(cfs2.get());

        // Exception handling.
        CompletableFuture<Integer> rf = CompletableFuture.supplyAsync(()-> 10/0).exceptionally(ex->0);
        System.out.println(rf.get());
    }
}
