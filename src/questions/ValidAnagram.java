package questions;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public static boolean validAnagram(String st1, String st2) {
        if (st2.length()!=st1.length()){
            return false;
        }
        Map<Character,Integer> map = new HashMap<>();
        for (int i=0;i<st1.length();i++){
            char c=st1.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for (int i=0;i<st2.length();i++){
            char c=st2.charAt(i);
            if (!map.containsKey(c)) return false;
            map.put(c,map.get(c)-1);
            if (map.get(c)==0) map.remove(c);
        }
        return map.isEmpty();

    }


    public static void main(String[] args) {
        String st1 = "listeln";
        String st2 = "silenkt";

        if (validAnagram(st1, st2)) {
            System.out.println(st1 + " and " + st2 + " are anagrams.");
        } else {
            System.out.println(st1 + " and " + st2 + " are not anagrams.");
        }
    }
}

