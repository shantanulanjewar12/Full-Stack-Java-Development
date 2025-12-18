import java.util.*;

/*
================================================================================
1️⃣ WHAT IS LINKEDHASHMAP?
================================================================================
- LinkedHashMap is a child class of HashMap.
- It maintains a **DOUBLY LINKED LIST** along with HashMap.
- It preserves **ORDER** of entries.

Definition:
LinkedHashMap is a HashMap implementation that maintains insertion
order or access order.

Package:
java.util

Introduced:
Java 1.4

================================================================================
2️⃣ WHY LINKEDHASHMAP EXISTS?
================================================================================
Problem with HashMap:
❌ No insertion order guarantee

LinkedHashMap Solution:
✔ Maintains predictable order
✔ Useful when order matters

================================================================================
3️⃣ HIERARCHY
================================================================================

Object
  ↓
AbstractMap
  ↓
HashMap
  ↓
LinkedHashMap

Implements:
✔ Map
✔ Serializable
✔ Cloneable

================================================================================
4️⃣ FEATURES OF LINKEDHASHMAP
================================================================================
✔ Stores key-value pairs
✔ Maintains insertion order
✔ Allows ONE null key
✔ Allows multiple null values
✔ Non-synchronized
✔ Slightly slower than HashMap
✔ Faster iteration than HashMap

================================================================================
5️⃣ INTERNAL WORKING (SIMPLE WORDS)
================================================================================
LinkedHashMap internally uses:
1. HashMap for fast lookup
2. Doubly Linked List for order

Each entry stores:
[key | value | hash | next | before | after]

So:
- Hashing → fast access
- Linked list → order preserved

================================================================================
6️⃣ INSERTION ORDER vs ACCESS ORDER
================================================================================

Insertion Order (default):
Entries stay in the order they were inserted.

Access Order:
Entries move to end when accessed (LRU cache).

================================================================================
7️⃣ CONSTRUCTORS OF LINKEDHASHMAP
================================================================================
*/

public class _4_LinkedHashMap {

    public static void main(String[] args) {

        /*
        =========================================================================
        7️⃣ CONSTRUCTOR EXAMPLES
        =========================================================================
        */

        // 1. Default constructor (insertion order)
        LinkedHashMap<Integer, String> map1 = new LinkedHashMap<>();

        // 2. Initial capacity
        LinkedHashMap<Integer, String> map2 = new LinkedHashMap<>(16);
        map2.size();

        // 3. Initial capacity + load factor
        LinkedHashMap<Integer, String> map3 = new LinkedHashMap<>(16, 0.75f);
        map3.size();

        // 4. Access order (VERY IMPORTANT)
        LinkedHashMap<Integer, String> accessMap =
                new LinkedHashMap<>(16, 0.75f, true);

        /*
        =========================================================================
        8️⃣ BASIC OPERATIONS
        =========================================================================
        */

        map1.put(1, "Java");
        map1.put(2, "Python");
        map1.put(3, "C++");

        System.out.println(map1); // maintains insertion order

        /*
        =========================================================================
        9️⃣ ACCESS ORDER DEMO
        =========================================================================
        */

        accessMap.put(1, "A");
        accessMap.put(2, "B");
        accessMap.put(3, "C");

        accessMap.get(1); // moves key=1 to end
        accessMap.get(2); // moves key=2 to end

        System.out.println(accessMap);

        /*
        =========================================================================
        🔟 IMPORTANT MAP METHODS
        =========================================================================
        */

        map1.get(1);
        map1.getOrDefault(5, "Default");
        map1.containsKey(2);
        map1.containsValue("Java");

        map1.putIfAbsent(4, "Go");

        map1.replace(2, "Rust");

        map1.remove(3);

        map1.size();
        map1.isEmpty();

        /*
        =========================================================================
        1️⃣1️⃣ ITERATION TECHNIQUES
        =========================================================================
        */

        // keySet()
        for (Integer key : map1.keySet()) {
            System.out.println(key + " -> " + map1.get(key));
        }

        // entrySet()
        for (Map.Entry<Integer, String> entry : map1.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        /*
        =========================================================================
        1️⃣2️⃣ FAIL-FAST ITERATOR
        =========================================================================
        */

        Iterator<Integer> it = map1.keySet().iterator();
        it.next();
        map1.put(10, "Fail"); // Structural modification
        // it.next(); // ❌ ConcurrentModificationException

        /*
        =========================================================================
        1️⃣3️⃣ LINKEDHASHMAP vs HASHMAP
        =========================================================================
        */

        /*
        HashMap:
        - No order
        - Faster
        - Less memory

        LinkedHashMap:
        - Maintains order
        - Slightly slower
        - Extra memory (linked list)
        */

        /*
        =========================================================================
        1️⃣4️⃣ LINKEDHASHMAP vs TREEMAP
        =========================================================================
        */

        /*
        TreeMap:
        - Sorted order
        - Slower (O(log n))
        - No null key

        LinkedHashMap:
        - Insertion/access order
        - Faster (O(1))
        - Allows one null key
        */

        /*
        =========================================================================
        1️⃣5️⃣ REAL-WORLD USE CASES
        =========================================================================
        */

        /*
        ✔ LRU Cache
        ✔ Ordered data display
        ✔ Session tracking
        ✔ Configuration files
        */

        /*
        =========================================================================
        1️⃣6️⃣ WHEN NOT TO USE LINKEDHASHMAP?
        =========================================================================
        */

        /*
        ❌ When order does not matter
        ❌ When memory is critical
        */

        /*
        =========================================================================
        1️⃣7️⃣ INTERVIEW QUESTIONS & ANSWERS
        =========================================================================
        */

        /*
        Q1. Difference between HashMap and LinkedHashMap?
        → Order maintenance

        Q2. How does LinkedHashMap maintain order?
        → Doubly linked list

        Q3. Can LinkedHashMap be used as LRU cache?
        → Yes (accessOrder = true)

        Q4. Is LinkedHashMap synchronized?
        → No

        Q5. Time complexity of LinkedHashMap?
        → O(1)

        */

        /*
        =========================================================================
        1️⃣8️⃣ KEY TAKEAWAYS
        =========================================================================
        */

        /*
        ✔ LinkedHashMap = HashMap + Order
        ✔ Maintains insertion/access order
        ✔ Slightly slower than HashMap
        ✔ Ideal when order matters
        ✔ Used in caching
        */
    }
}
