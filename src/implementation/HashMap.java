package implementation;

import java.util.LinkedList;

public class HashMap<K, V> {
    // Default initial capacity of the hash table
    public static final int DEFAULT_CAPACITY = 4;

    // Load factor to determine when to resize the hash table
    public static final double LOAD_FACTOR = 0.75;

    // Number of key-value pairs in the hash table
    private int n = 0;

    // Array of linked lists to store hash table buckets
    private LinkedList<Node>[] buckets;

    // Initializes the hash table buckets with the given capacity
    private void initBuckets(int N) {
        buckets = new LinkedList[N];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    // Computes the hash value for the given key
    private int hashFunction(K key) {
        int hashCode = key.hashCode();
        return Math.abs(hashCode) % buckets.length;
    }

    // Searches for the key in the given bucket and returns its index
    private int searchBucket(LinkedList<Node> ll, K key) {
        for (int i = 0; i < ll.size(); i++) {
            if (ll.get(i).key.equals(key)) return i;
        }
        return -1;
    }

    // Rehashes the hash table when the load factor threshold is reached
    private void reHash() {
        LinkedList<Node>[] oldBuckets = buckets;
        initBuckets(oldBuckets.length * 2);
        n = 0;
        for (var bucket : oldBuckets) {
            for (var node : bucket) {
                put(node.key, node.value);
            }
        }
    }

    // Constructor to initialize the hash table with default capacity
    public HashMap() {
        initBuckets(DEFAULT_CAPACITY);
    }

    // Inner class to represent a key-value pair
    private class Node {
        K key;
        V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // Returns the number of key-value pairs in the hash table
    public int size() {
        return n;
    }

    // Inserts or updates the key-value pair in the hash table
    public void put(K key, V value) {
        int bi = hashFunction(key);
        LinkedList<Node> currBucket = buckets[bi];
        int ei = searchBucket(currBucket, key);

        if (ei == -1) {
            Node node = new Node(key, value);
            currBucket.add(node);
            n++;
        } else {
            Node currentNode = currBucket.get(ei);
            currentNode.value = value;
        }

        // Rehash if load factor threshold is reached
        if (n >= buckets.length * LOAD_FACTOR) {
            reHash();
        }
    }

    // Retrieves the value associated with the given key
    public V get(K key) {
        int bi = hashFunction(key);
        LinkedList<Node> currBucket = buckets[bi];
        int ei = searchBucket(currBucket, key);

        if (ei != -1) {
            Node currNode = currBucket.get(ei);
            return currNode.value;
        } else {
            return null;
        }
    }

    // Removes the key-value pair associated with the given key and returns the value
    public V remove(K key) {
        int bi = hashFunction(key);
        LinkedList<Node> currBucket = buckets[bi];
        int ei = searchBucket(currBucket, key);

        if (ei != -1) {
            Node node = currBucket.get(ei);
            V val = node.value;
            currBucket.remove(ei);
            n--;
            return val;
        } else {
            return null;
        }
    }

    // Main function to demonstrate the usage of HashMap
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        // Inserting key-value pairs
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);

        // Retrieving values
        System.out.println("Value for key 'one': " + map.get("one")); // Output: 1
        System.out.println("Value for key 'two': " + map.get("two")); // Output: 2
        System.out.println("Value for key 'three': " + map.get("three")); // Output: 3

        // Updating value for key 'two'
        map.put("two", 22);
        System.out.println("Updated value for key 'two': " + map.get("two")); // Output: 22

        // Removing a key-value pair
        System.out.println("Removed value for key 'three': " + map.remove("three")); // Output: 3
        System.out.println("Value for key 'three' after removal: " + map.get("three")); // Output: null

        // Displaying the size of the map
        System.out.println("Size of map: " + map.size()); // Output: 2
    }
}
