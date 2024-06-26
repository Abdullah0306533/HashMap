package questions;

import java.util.HashMap;
import java.util.Map;

public class MaxFreq {
    public static void main(String[] args) {
        // Array of integers
        int[] a = {1, 2, 1, 1, 2, 5, 6, 1, 1, 1, 1, 22, 1, 2, 2, 2, 22, 2, 2, 2, 2, 2, 2, 8};

        // Creating a HashMap to store the frequency of each integer
        Map<Integer, Integer> map = new HashMap<>();

        // Iterating over the array to populate the HashMap
        for (int num : a) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Variables to store the integer with the maximum frequency and its frequency count
        int maxFrequency = -1;
        int maxValue = -1;

        // Iterating over the entries in the HashMap to find the maximum frequency
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxFrequency) {
                maxFrequency = entry.getValue();
                maxValue = entry.getKey();
            }
        }

        // Printing the result
        System.out.println("Number with maximum frequency: " + maxValue);
        System.out.println("Maximum frequency: " + maxFrequency);
    }
}
