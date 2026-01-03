/*
---------------------------------
1. WHAT IS MAP?
---------------------------------
Map is an INTERFACE in Java Collection Framework.

Map stores data in the form of:
    KEY  ->  VALUE

Example:
    rollNo -> StudentName
    id     -> Employee
    word   -> frequency

IMPORTANT:
- Map is NOT a child of Collection interface.
- Keys are UNIQUE.
- Values CAN be duplicate.
- One key maps to only ONE value.

---------------------------------
2. WHY MAP WAS INTRODUCED?
---------------------------------
Before Map:
- Data was stored using Lists or Arrays
- Searching required iteration (O(n))

Problems:
- Slow searching
- No direct key-based access
- Manual handling of duplicates

Map solves this by:
- Direct access using keys
- Fast lookup using hashing or tree structure

---------------------------------
3. MAP HIERARCHY
---------------------------------

        Map (Interface)
          |
          |-------------------------------
          |              |              |
       HashMap        Hashtable     LinkedHashMap
          |
       (no order)     (thread-safe) (insertion order)

          |
       SortedMap (Interface)
          |
       TreeMap (Sorted order)

---------------------------------
4. PROPERTIES OF MAP
---------------------------------
✔ Stores key-value pairs
✔ No duplicate keys allowed
✔ Allows duplicate values
✔ Each key maps to exactly one value
✔ Values can be null (depends on implementation)

---------------------------------
5. MAP IMPLEMENTATIONS COMPARISON
---------------------------------

HashMap:
- Not thread-safe
- No insertion order
- Allows ONE null key
- Allows multiple null values
- Fastest (O(1) average)

Hashtable:
- Thread-safe (synchronized)
- Slower
- NO null key
- NO null value
- Legacy class

LinkedHashMap:
- Maintains insertion order
- Slightly slower than HashMap
- Used when order matters

TreeMap:
- Sorted order of keys
- No null key
- Uses Red-Black Tree
- Slower (O(log n))

---------------------------------
6. MAP INTERFACE METHODS
---------------------------------
Common methods available in Map interface:

size()
isEmpty()
containsKey(key)
containsValue(value)
get(key)
put(key, value)
remove(key)
putAll(map)
clear()
keySet()
values()
entrySet()
putIfAbsent()
getOrDefault()

---------------------------------
7. IMPORTANT MAP METHODS EXPLANATION
---------------------------------
*/

import java.util.*;

public class _1_Map {

    public static void main(String[] args) {

        /*
        ---------------------------------
        8. HASHMAP INTRODUCTION
        ---------------------------------
        HashMap is a concrete class that implements Map interface.

        - Uses hashing technique
        - Average time complexity O(1)
        - Not synchronized
        - Best choice when performance matters
        */

        HashMap<Integer, String> map = new HashMap<>();

        /*
        ---------------------------------
        9. put(K key, V value)
        ---------------------------------
        - Adds key-value pair
        - If key already exists, value is replaced
        */

        map.put(1, "Java");
        map.put(2, "Python");
        map.put(3, "C++");
        map.put(2, "JavaScript"); // overwrites value for key=2

        /*
        ---------------------------------
        10. get(Object key)
        ---------------------------------
        - Returns value associated with key
        - Returns null if key not found
        */

        System.out.println(map.get(1)); // Java
        System.out.println(map.get(5)); // null

        /*
        ---------------------------------
        11. containsKey(Object key)
        ---------------------------------
        - Checks if key exists
        */

        System.out.println(map.containsKey(2)); // true

        /*
        ---------------------------------
        12. containsValue(Object value)
        ---------------------------------
        - Checks if value exists
        */

        System.out.println(map.containsValue("Java")); // true

        /*
        ---------------------------------
        13. remove(Object key)
        ---------------------------------
        - Removes mapping for key
        */

        map.remove(3);

        /*
        ---------------------------------
        14. size()
        ---------------------------------
        - Returns number of key-value pairs
        */

        System.out.println(map.size());

        /*
        ---------------------------------
        15. keySet()
        ---------------------------------
        - Returns Set of keys
        - Backed by Map (changes reflect)
        */

        Set<Integer> keys = map.keySet();
        System.out.println(keys);

        /*
        ---------------------------------
        16. values()
        ---------------------------------
        - Returns Collection of values
        */

        Collection<String> values = map.values();
        System.out.println(values);

        /*
        ---------------------------------
        17. entrySet()
        ---------------------------------
        - Returns Set of Map.Entry
        - Entry contains key + value
        */

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        /*
        ---------------------------------
        18. putIfAbsent()
        ---------------------------------
        - Inserts only if key not present
        */

        map.putIfAbsent(1, "Spring"); // ignored
        map.putIfAbsent(4, "Spring"); // added

        /*
        ---------------------------------
        19. getOrDefault()
        ---------------------------------
        - Returns default value if key missing
        */

        System.out.println(map.getOrDefault(10, "Not Found"));

        /*
        ---------------------------------
        20. INTERNAL WORKING OF HASHMAP
        ---------------------------------

        Step 1: hashCode() of key is calculated
        Step 2: hash is converted to bucket index
        Step 3: Entry stored in bucket
        Step 4: If collision occurs:
                - Linked List (Java 7)
                - Balanced Tree (Java 8+)
        */

        /*
        ---------------------------------
        21. TIME COMPLEXITY
        ---------------------------------

        Operation      Average     Worst
        ---------------------------------
        put()          O(1)        O(n)
        get()          O(1)        O(n)
        remove()       O(1)        O(n)
        search         O(1)        O(n)

        TreeMap:
        - O(log n) for all operations
        */

        /*
        ---------------------------------
        22. SPACE COMPLEXITY
        ---------------------------------
        HashMap Space Complexity:
        O(n) where n = number of entries
        */

        /*
        ---------------------------------
        23. HASHTABLE
        ---------------------------------
        - Synchronized
        - Thread-safe
        - Slower
        - No null key or value
        */

        Hashtable<Integer, String> table = new Hashtable<>();
        table.put(1, "A");
        // table.put(null, "B"); // ERROR

        /*
        ---------------------------------
        24. LINKEDHASHMAP
        ---------------------------------
        - Maintains insertion order
        */

        LinkedHashMap<Integer, String> lhm = new LinkedHashMap<>();
        lhm.put(1, "One");
        lhm.put(2, "Two");
        lhm.put(3, "Three");
        System.out.println(lhm);

        /*
        ---------------------------------
        25. TREEMAP
        ---------------------------------
        - Sorted by keys
        - Uses Red-Black Tree
        */

        TreeMap<Integer, String> tm = new TreeMap<>();
        tm.put(3, "C");
        tm.put(1, "A");
        tm.put(2, "B");
        System.out.println(tm);

        /*
        ---------------------------------
        26. WHEN TO USE WHICH MAP?
        ---------------------------------

        HashMap        -> Fast access, no order
        LinkedHashMap  -> Order required
        TreeMap        -> Sorted data
        Hashtable      -> Legacy thread-safe
        */
    }
}
