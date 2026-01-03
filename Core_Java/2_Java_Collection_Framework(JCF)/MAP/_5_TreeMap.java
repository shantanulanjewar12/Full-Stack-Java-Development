/*
================================================================================
1️⃣ WHAT IS TREEMAP?
================================================================================
- TreeMap is a Map implementation that stores data in SORTED ORDER.
- Sorting is based on:
  ✔ Natural ordering of keys OR
  ✔ Custom Comparator

Definition:
TreeMap stores key-value pairs in a RED-BLACK TREE structure.

Package:
java.util.TreeMap

Introduced:
Java 1.2 (with JCF)

================================================================================
2️⃣ WHY TREEMAP?
================================================================================
Problems with HashMap:
- No ordering
- Cannot retrieve data in sorted manner

TreeMap provides:
✔ Sorted keys
✔ Navigational operations
✔ Range-based queries

================================================================================
3️⃣ HIERARCHY & INTERFACES
================================================================================

Object
  ↓
AbstractMap
  ↓
TreeMap

Implements:
- Map
- NavigableMap
- SortedMap
- Serializable
- Cloneable

================================================================================
4️⃣ IMPORTANT CHARACTERISTICS
================================================================================
✔ Stores key-value pairs
✔ Keys are ALWAYS sorted
✔ Does NOT allow null key
✔ Allows multiple null values
✔ Not synchronized
✔ Slower than HashMap (O(log n))

================================================================================
5️⃣ INTERNAL WORKING OF TREEMAP
================================================================================
- Internally uses RED-BLACK TREE
- Each entry is a NODE
- Tree remains balanced

Why Red-Black Tree?
✔ Guaranteed log(n) time
✔ Self-balancing
✔ Faster than plain BST

Comparison happens using:
- Comparable (natural ordering)
OR
- Comparator (custom ordering)

================================================================================
6️⃣ NULL HANDLING
================================================================================
❌ Null key NOT allowed
Reason:
- TreeMap compares keys for sorting
- Comparing null causes NullPointerException

✔ Null values ARE allowed

================================================================================
7️⃣ TIME COMPLEXITY
================================================================================
Operation        Time Complexity
--------------------------------
put()            O(log n)
get()            O(log n)
remove()         O(log n)
search           O(log n)

Space Complexity: O(n)

================================================================================
8️⃣ TREEMAP CONSTRUCTORS
================================================================================
*/

import java.util.*;

public class _5_TreeMap {

  public static void main(String[] args) {

    /*
     * =============================================================================
     * 8️⃣ CONSTRUCTORS
     * =============================================================================
     */

    // 1. Default constructor (Natural ordering)
    TreeMap<Integer, String> map1 = new TreeMap<>();

    // 2. Constructor with Comparator
    TreeMap<Integer, String> map2 = new TreeMap<>(Comparator.reverseOrder());
    map2.size();

    // 3. Constructor with existing Map
    Map<Integer, String> temp = new HashMap<>();
    temp.put(3, "C");
    temp.put(1, "A");
    TreeMap<Integer, String> map3 = new TreeMap<>(temp);
    map3.size();

    /*
     * =============================================================================
     * 9️⃣ BASIC METHODS
     * =============================================================================
     */

    map1.put(3, "Java");
    map1.put(1, "Python");
    map1.put(2, "C++");

    map1.get(1);
    map1.containsKey(2);
    map1.containsValue("Java");
    map1.remove(3);
    map1.size();
    map1.isEmpty();

    /*
     * =============================================================================
     * 🔟 SORTEDMAP METHODS
     * =============================================================================
     */

    // firstKey() / lastKey()
    map1.firstKey();
    map1.lastKey();

    // headMap(key) → keys < key
    map1.headMap(2);

    // tailMap(key) → keys >= key
    map1.tailMap(2);

    // subMap(fromKey, toKey)
    // fromKey → inclusive
    // toKey → exclusive
    map1.subMap(1, 3);

    /*
     * =============================================================================
     * 1️⃣1️⃣ NAVIGABLEMAP METHODS
     * =============================================================================
     */

    map1.lowerKey(2); // < key
    map1.floorKey(2); // <= key
    map1.ceilingKey(2);// >= key
    map1.higherKey(2); // > key

    map1.pollFirstEntry();
    map1.pollLastEntry();

    /*
     * =============================================================================
     * 1️⃣2️⃣ ITERATION TECHNIQUES
     * =============================================================================
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
     * =============================================================================
     * 1️⃣3️⃣ CUSTOM SORTING USING COMPARATOR
     * =============================================================================
     */

    TreeMap<String, Integer> customMap = new TreeMap<>((a, b) -> b.compareTo(a));

    customMap.put("Banana", 10);
    customMap.put("Apple", 5);
    customMap.put("Mango", 20);

    /*
     * =============================================================================
     * 1️⃣4️⃣ TREEMAP vs HASHMAP vs LINKEDHASHMAP
     * =============================================================================
     */

    /*
     * HashMap:
     * - No order
     * - Fastest (O(1))
     * - Allows null key
     * 
     * LinkedHashMap:
     * - Insertion order
     * - Slightly slower
     * 
     * TreeMap:
     * - Sorted order
     * - Slower (O(log n))
     * - No null key
     */

    /*
     * =============================================================================
     * 1️⃣5️⃣ FAIL-FAST ITERATOR
     * =============================================================================
     */

    /*
     * - TreeMap iterators are FAIL-FAST
     * - Structural modification during iteration
     * → ConcurrentModificationException
     */

    /*
     * =============================================================================
     * 1️⃣6️⃣ WHEN TO USE TREEMAP?
     * =============================================================================
     */

    /*
     * ✔ When sorted data is required
     * ✔ When range queries are needed
     * ✔ When floor/ceiling operations needed
     * ❌ When performance is critical (use HashMap)
     */

    /*
     * =============================================================================
     * 1️⃣7️⃣ INTERVIEW QUESTIONS & ANSWERS
     * =============================================================================
     */

    /*
     * Q1. Why TreeMap does not allow null key?
     * → Because sorting requires comparison.
     * 
     * Q2. Which data structure TreeMap uses?
     * → Red-Black Tree.
     * 
     * Q3. Time complexity of TreeMap?
     * → O(log n).
     * 
     * Q4. Difference between TreeMap and HashMap?
     * → Ordering & performance.
     * 
     * Q5. Can TreeMap store null values?
     * → Yes.
     */

    /*
     * =============================================================================
     * 1️⃣8️⃣ KEY TAKEAWAYS
     * =============================================================================
     */

    /*
     * ✔ Sorted Map
     * ✔ Red-Black Tree
     * ✔ No null key
     * ✔ Slower than HashMap
     * ✔ Powerful navigational methods
     */
  }
}
