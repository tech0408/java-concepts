package StreamAPIs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

class Inventory{

    String name;
    Double price;
    int quantity;
    String warehouse;
    Inventory(String name, Double price, int quantity, String warehouse){
        this.name= name;
        this.price= price;
        this.quantity= quantity;
        this.warehouse= warehouse;
    } 
}


public class Sample1 {

    public static void main(String [] args){

        List<Inventory> iL = new ArrayList<>();
        iL.add(new Inventory("mobile", 50000.0, 15, "Patna"));
        iL.add(new Inventory("laptop", 100000.0, 7, "Bangalore"));
        
        iL.add(new Inventory("ipad", 34000.0, 18, "Lucknow"));
        iL.add(new Inventory("swatch", 15000.0, 20, "Patna"));
        iL.add(new Inventory("speaker", 50000.0, 2, "Lucknow"));
        iL.add(new Inventory("fPhone", 1200.0, 10, "BBS"));
        iL.add(new Inventory("earphonbe", 500.0, 15, "BBS"));


        Comparator<Inventory> cmp = (i1,i2)->{

            return i1.quantity>i2.quantity?-1:i1.quantity<i2.quantity?1:0;

        };

        iL.stream().sorted(cmp).forEach(i-> System.out.println(i.name));
//        Map<Object,Double> mp =iL.stream().collect(Collectors.groupingBy(e->e.warehouse,Collectors.reducing(1,(e,p)-> e.price*p.));
//        System.out.println(mp);
        

    }
    
}
