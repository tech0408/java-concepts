package stream_APIs;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/*
 * Implement a consumer that processes and modifies a collection of objects (e.g., list of products) and prints the results using `Consumer`.

Requirements:
     - Define a `Product` class with fields such as `name`, `price`, and `category`.
     - Create a list of `Product` objects.
     - Use `Consumer<Product>` to perform the following operations:
          - Increase the price of products based on certain criteria (e.g., category, price threshold).
          - Print the names of products after modifying them.
     - Use the `forEach()` method in a stream to process the products.

Implement a system that calculates the total value of modified products and prints it.
 */

class Product{

    String name;
    Double price;
    String category;

    Product(String name, Double price, String category){
        this.name=name;
        this.price=price;
        this.category=category;
    }
}
public class Example3 {

    public static void main(String[] args) {
        
        List<Product> pL = Arrays.asList(
            new Product("IPhone",25000.0,"Electronics"),
            new Product("Iron",1000.0,"Electronics"),
            new Product("Door",20000.0,"Furniture"),
            new Product("Cooker",1500.0,"Kitchen appliance")
        );

        System.out.println(pL.stream().limit(3).max((p1,p2)-> p2.price.compareTo(p1.price)).get().name);
        //Increase price of products belonging to category "Electronics".
        pL.stream().map(p->{
            if(p.category.equals("Electronics")){
                double newPrice = p.price+1000;
                p.price =newPrice;
            }
            return p;
        }).forEach(p-> System.out.println(p.name + ":"+ p.price));

        // Find the total of all the price.
        Double sum = pL.stream().map(p->p.price).reduce(0.0, Double::sum);
        //System.out.println(sum);

        // Optional<Double> sum1 = pL.stream().filter(p->p.category.equals("Electronics")).map(p->{
        //     double newPrice = p.price+1000;
        //     p.price =newPrice;
        //     return p;
        // }).map(p->p.price).reduce((p,q)->p+q);
        // System.out.println(sum1.get());

        List<Double> priceList =pL.stream().filter(p->p.category.equals("Electronics")).map(p->{
            double newPrice = p.price+1000;
            p.price =newPrice;
            return p;
        }).map(p->p.price).collect(Collectors.toList());
        System.out.println(priceList);

    }
    
}
