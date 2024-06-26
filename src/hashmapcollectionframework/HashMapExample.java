package hashmapcollectionframework;

import java.util.*;

public class HashMapExample {

    public static void main(String[] args) {
        HashMap<String,Integer> map=new HashMap<>();
        map.put("asif",22);
        map.put("Ahmad",19);
        map.put("Taimoor",3);
        map.put("Ali",6);
        System.out.println(map.get("Taimoor"));
        map.put("Taimoor",20);
        System.out.println(map.get("Taimoor" ));
        map.remove("Taimoor");
        System.out.println(map.get("Taimoor" ));
        System.out.println(map.containsKey("Ali"));
        map.putIfAbsent("Ali",56);
        System.out.println(map.get("Ali"));
        System.out.println(map.keySet());
        System.out.println(map.values());
        System.out.println();
        Set s1=map.keySet();
        for (String s:map.keySet()){
            System.out.println(s);
        }
        for (var s:map.entrySet()){
            System.out.println(s);
        }


    }
}
