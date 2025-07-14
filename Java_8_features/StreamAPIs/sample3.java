package StreamAPIs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class sample3 {

    public static void main(String[] args) {
        
        List<String> strList = Arrays.asList("abc","def","pqr","avr");

        Map<String,List<Integer>> map = new HashMap<>();
        for(String s : strList){
            int len = s.length();
            List <Integer> al = new ArrayList<>();
            for(int i=0;i<len-1;i++){
                al.add(s.charAt(i)-s.charAt(i+1));
            }
            map.put(s,al);
            System.out.println(al);
        }
        System.out.println(map);
    }


}
