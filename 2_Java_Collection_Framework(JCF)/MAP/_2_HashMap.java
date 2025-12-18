import java.util.*;

public class _2_HashMap {

    /*
    ============================================================================
    1️⃣ INTRODUCTION TO HASHMAP
    ============================================================================
    */

    /*
     WHAT IS HASHMAP?
     ----------------
     HashMap is a part of java.util package and is one of the most commonly used
     implementations of the Map interface.

     - It stores data in KEY–VALUE pairs
     - Each key maps to exactly one value
     - Keys must be unique
     - Values can be duplicated
    */

    /*
     WHY HASHMAP EXISTS?
     -------------------
     Before Map, data was stored mainly in Lists/Sets.
     But:
       - Searching in List is O(n)
       - Set does not support key-value mapping

     HashMap solves:
       ✔ Fast lookup
       ✔ Direct key-based access
       ✔ O(1) average time complexity
    */

    /*
     DIFFERENCE BETWEEN MAP AND HASHMAP
     ---------------------------------
     Map       → Interface
     HashMap   → Concrete class implementing Map

     Map defines WHAT operations are possible.
     HashMap defines HOW those operations are implemented.
    */


    /*
     WHY HASHMAP IS NOT PART OF COLLECTION INTERFACE?
     ------------------------------------------------
     Collection interface is designed for:
        - Single element storage
        - add(E), remove(E)

     Map stores:
        - Two elements (Key, Value)
        - put(K, V)

     Hence Map is a separate hierarchy.
    */


    /*
    ============================================================================
    2️⃣ HIERARCHY & THEORY
    ============================================================================
    */

    /*
        Object
          ↑
       AbstractMap
          ↑
       HashMap
    */


    /*
     INTERFACES IMPLEMENTED BY HASHMAP
     --------------------------------
     - Map<K, V>
     - Serializable
     - Cloneable
     */


    /*
     RELATIONSHIP
     ------------
     HashMap IS-A Map
     HashMap IS Serializable
     HashMap IS Cloneable
    */


    /*
    ============================================================================
    3️⃣ INTERNAL WORKING OF HASHMAP
    ============================================================================
    */

    /*
     HASHING CONCEPT
     ---------------
     HashMap internally uses:
       - hashCode()
       - equals()

     Steps while inserting a key:
       1. hashCode() is called on key
       2. Hash is converted to index
       3. Entry stored in bucket
    */


    /*
     BUCKETS & NODES
     ---------------
     HashMap internally uses an array of Node<K,V>

     Node contains:
       - key
       - value
       - hash
       - next (for collision handling)
    */


    /*
     INDEX CALCULATION
     -----------------
     index = (n - 1) & hash
     where n = array size (capacity)
    */


    /*
     COLLISION HANDLING
     ------------------
     When two keys map to same index:
       - Before Java 8 → Linked List
       - Java 8+ → Red-Black Tree (if chain length > 8)
    */


    /*
     LOAD FACTOR
     -----------
     Default = 0.75
     Means: Rehash when 75% full
    */


    /*
     INITIAL CAPACITY
     ----------------
     Default = 16
    */


    /*
     REHASHING
     ---------
     When size > capacity * loadFactor
       - Capacity doubles
       - All entries rehashed
    */


    /*
    ============================================================================
    4️⃣ FEATURES OF HASHMAP
    ============================================================================
    */

    /*
     ✔ Stores key-value pairs
     ✔ Allows ONE null key
     ✔ Allows multiple null values
     ✔ Not synchronized (not thread-safe)
     ✔ Does NOT maintain insertion order
     ✔ Very fast (O(1) average)
    */

    /*
    ============================================================================
    5️⃣ CONSTRUCTORS OF HASHMAP
    ============================================================================
    */

    static void hashMapConstructorsDemo() {

        // 1. Default constructor
        HashMap<Integer, String> map1 = new HashMap<>();
        map1.size();

        // 2. Initial capacity
        HashMap<Integer, String> map2 = new HashMap<>(32);
        map2.size();

        // 3. Capacity + Load factor
        HashMap<Integer, String> map3 = new HashMap<>(32, 0.75f);
        map3.size();

        // 4. From another Map
        Map<Integer, String> temp = new HashMap<>();
        temp.put(1, "A");
        HashMap<Integer, String> map4 = new HashMap<>(temp);
        map4.size();
    }



    /*
    ============================================================================
    6️⃣ HASHMAP METHODS (WITH EXAMPLES)
    ============================================================================
    */

    static void hashMapMethodsDemo() {

        HashMap<Integer, String> map = new HashMap<>();

        // put()
        map.put(1, "Java");

        // putIfAbsent()
        map.putIfAbsent(1, "Python");

        // get()
        map.get(1);

        // getOrDefault()
        map.getOrDefault(2, "Default");

        // containsKey()
        map.containsKey(1);

        // containsValue()
        map.containsValue("Java");

        // remove()
        map.remove(1);

        // replace()
        map.put(1, "Java");
        map.replace(1, "Advanced Java");

        // compute()
        map.compute(1, (k, v) -> v + " Course");

        // computeIfAbsent()
        map.computeIfAbsent(2, k -> "Spring");

        // computeIfPresent()
        map.computeIfPresent(2, (k, v) -> v + " Boot");

        // keySet()
        Set<Integer> keys = map.keySet();
        keys.size();

        // values()
        Collection<String> values = map.values();
        values.size();

        // entrySet()
        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        entries.size();

        // size()
        map.size();

        // isEmpty()
        map.isEmpty();

        // clear()
        map.clear();
    }

    /*
    ============================================================================
    7️⃣ IMPORTANT INTERVIEW QUESTIONS
    ============================================================================
    */

    /*
     Q1: Why HashMap allows one null key?
     -----------------------------------
     HashMap uses hashCode() for key.
     Null has no hashCode, so HashMap stores it at index 0 internally.
    */

    /*
     Q2: Why HashMap is not thread-safe?
     ----------------------------------
     HashMap does not use synchronization.
     Multiple threads can modify it simultaneously → data inconsistency.
    */

    /*
     Q3: HashMap vs Hashtable
     ------------------------
     HashMap     → Not synchronized, faster, allows null
     Hashtable   → Synchronized, slower, no null
    */

    /*
     Q4: HashMap vs LinkedHashMap vs TreeMap
     ---------------------------------------
     HashMap        → No order
     LinkedHashMap  → Insertion order
     TreeMap        → Sorted order
    */

    /*
     Q5: What if equals() overridden but hashCode() not?
     ---------------------------------------------------
     Contract breaks → unexpected behavior → lookup fails
    */

    /*
     Q6: Why String is best key?
     --------------------------
     - Immutable
     - Cached hashCode
     - Prevents key corruption
    */

    /*
    ============================================================================
    8️⃣ WHEN / WHERE / WHY TO USE HASHMAP
    ============================================================================
    */

    /*
     USE WHEN:
     ---------
     ✔ Fast lookup required
     ✔ Key-based access
     ✔ No ordering needed

     DO NOT USE WHEN:
     ----------------
     ❌ Thread safety required
     ❌ Ordering required
    */

    /*
    ============================================================================
    9️⃣ ADVANCED CONCEPTS
    ============================================================================
    */

    /*
     FAIL-FAST ITERATOR
     -----------------
     Any structural modification during iteration
     throws ConcurrentModificationException
    */

    /*
     CUSTOM OBJECT AS KEY
     --------------------
     Must override:
       ✔ equals()
       ✔ hashCode()
    */

    /*
     JAVA 8 IMPROVEMENTS
     ------------------
     ✔ Tree-based collision handling
     ✔ New compute methods
    */

    /*
    ============================================================================
    🔟 COMPLETE WORKING EXAMPLES
    ============================================================================
    */

    static void basicExample() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Java", 100);
        map.put("Python", 90);
    }

    static void iterationExample() {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "A");
        map.put(2, "B");

        for (Map.Entry<Integer, String> e : map.entrySet()) {
            System.out.println(e.getKey() + " = " + e.getValue());
        }
    }

    /*
    ============================================================================
    MAIN METHOD
    ============================================================================
    */

    public static void main(String[] args) {

        hashMapConstructorsDemo();
        hashMapMethodsDemo();
        basicExample();
        iterationExample();

        System.out.println("HashMapCompleteGuide executed successfully.");
    }
}
