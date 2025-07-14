import java.util.HashMap;
import java.util.Map;

public class RecordExample {

    public record Person11(String name, int id, Map<String,String> mp){}
    public static void main(String[] args) {


        Map<String,String> mp = new HashMap<String,String>();
        mp.put("sawan","abc");
        mp.put("rishika","def");
        Person11 p = new Person11("Sawan",4,mp);
        mp.put("ashu","rft");
        System.out.println(mp);
        System.out.println(p.mp);        
    }
    
}
