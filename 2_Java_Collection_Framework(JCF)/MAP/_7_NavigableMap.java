import java.util.*;

public class _7_NavigableMap {

    public static void main(String[] args) {

        /*
        ===========================================================
        1️⃣ WHAT IS NAVIGABLE MAP?
        ===========================================================

        ➤ NavigableMap is an INTERFACE
        ➤ It extends SortedMap
        ➤ It provides navigation methods to search keys
        ➤ It works on SORTED data only

        👉 TreeMap is the most common implementation.
        */

        NavigableMap<Integer, String> map = new TreeMap<>();

        map.put(1, "A");
        map.put(21, "B");
        map.put(23, "C");
        map.put(25, "E");
        map.put(141, "D");

        System.out.println("Original Map: " + map);

        /*
        ===========================================================
        2️⃣ lowerEntry(K key)
        ===========================================================

        🔹 Definition:
        Returns the ENTRY (key + value) which is STRICTLY LESS
        than the given key.

        🔹 If no such entry exists → returns null
        */

        System.out.println("\nlowerEntry(23): " + map.lowerEntry(23));
        // Output: 21=B

        /*
        ===========================================================
        3️⃣ lowerKey(K key)
        ===========================================================

        🔹 Definition:
        Returns ONLY the KEY which is STRICTLY LESS than given key.

        🔹 Difference:
        - lowerEntry → key + value
        - lowerKey   → key only
        */

        System.out.println("lowerKey(23): " + map.lowerKey(23));
        // Output: 21

        /*
        ===========================================================
        4️⃣ floorEntry(K key)
        ===========================================================

        🔹 Definition:
        Returns the ENTRY which is:
        ➤ LESS THAN OR EQUAL TO the given key

        🔹 Think of "floor" as:
        ❝ closest smaller OR equal ❞
        */

        System.out.println("\nfloorEntry(24): " + map.floorEntry(24));
        // Output: 23=C

        System.out.println("floorEntry(23): " + map.floorEntry(23));
        // Output: 23=C

        /*
        ===========================================================
        5️⃣ floorKey(K key)
        ===========================================================

        🔹 Definition:
        Same as floorEntry but returns ONLY the key.
        */

        System.out.println("floorKey(24): " + map.floorKey(24));
        // Output: 23

        /*
        ===========================================================
        6️⃣ ceilingEntry(K key)
        ===========================================================

        🔹 Definition:
        Returns the ENTRY which is:
        ➤ GREATER THAN OR EQUAL TO the given key

        🔹 Think of "ceiling" as:
        ❝ closest greater OR equal ❞
        */

        System.out.println("\nceilingEntry(23): " + map.ceilingEntry(23));
        // Output: 23=C

        System.out.println("ceilingEntry(24): " + map.ceilingEntry(24));
        // Output: 25=E

        /*
        ===========================================================
        7️⃣ ceilingKey(K key)
        ===========================================================

        🔹 Definition:
        Same as ceilingEntry but returns ONLY the key.
        */

        System.out.println("ceilingKey(24): " + map.ceilingKey(24));
        // Output: 25

        /*
        ===========================================================
        8️⃣ higherEntry(K key)
        ===========================================================

        🔹 Definition:
        Returns the ENTRY which is STRICTLY GREATER than key.
        */

        System.out.println("\nhigherEntry(23): " + map.higherEntry(23));
        // Output: 25=E

        /*
        ===========================================================
        9️⃣ higherKey(K key)
        ===========================================================

        🔹 Definition:
        Returns ONLY the key strictly greater than given key.
        */

        System.out.println("higherKey(23): " + map.higherKey(23));
        // Output: 25

        /*
        ===========================================================
        🔟 firstEntry()
        ===========================================================

        🔹 Definition:
        Returns the FIRST (lowest) entry in the map.
        */

        System.out.println("\nfirstEntry(): " + map.firstEntry());
        // Output: 1=A

        /*
        ===========================================================
        1️⃣1️⃣ lastEntry()
        ===========================================================

        🔹 Definition:
        Returns the LAST (highest) entry in the map.
        */

        System.out.println("lastEntry(): " + map.lastEntry());
        // Output: 141=D

        /*
        ===========================================================
        1️⃣2️⃣ pollFirstEntry()
        ===========================================================

        🔹 Definition:
        ➤ Removes AND returns the first entry.
        */

        System.out.println("\npollFirstEntry(): " + map.pollFirstEntry());
        System.out.println("After removal: " + map);

        /*
        ===========================================================
        1️⃣3️⃣ pollLastEntry()
        ===========================================================

        🔹 Definition:
        ➤ Removes AND returns the last entry.
        */

        System.out.println("\npollLastEntry(): " + map.pollLastEntry());
        System.out.println("After removal: " + map);

        /*
        ===========================================================
        1️⃣4️⃣ descendingMap()
        ===========================================================

        🔹 Definition:
        Returns the map in REVERSE order.
        */

        System.out.println("\ndescendingMap(): " + map.descendingMap());

        /*
        ===========================================================
        1️⃣5️⃣ navigableKeySet()
        ===========================================================

        🔹 Definition:
        Returns keys in NORMAL sorted order.
        */

        System.out.println("\nnavigableKeySet(): " + map.navigableKeySet());

        /*
        ===========================================================
        1️⃣6️⃣ descendingKeySet()
        ===========================================================

        🔹 Definition:
        Returns keys in REVERSE sorted order.
        */

        System.out.println("descendingKeySet(): " + map.descendingKeySet());

        /*
        ===========================================================
        1️⃣7️⃣ headMap(K toKey, boolean inclusive)
        ===========================================================

        🔹 Definition:
        Returns map LESS THAN (or equal if inclusive=true) to key.
        */

        System.out.println("\nheadMap(23, true): " + map.headMap(23, true));

        /*
        ===========================================================
        1️⃣8️⃣ tailMap(K fromKey, boolean inclusive)
        ===========================================================

        🔹 Definition:
        Returns map GREATER THAN (or equal if inclusive=true) key.
        */

        System.out.println("tailMap(23, true): " + map.tailMap(23, true));

        /*
        ===========================================================
        🎯 FINAL NOTES (EXAM READY)
        ===========================================================

        ✔ NavigableMap works only on SORTED data
        ✔ Implemented mainly by TreeMap
        ✔ Uses Red-Black Tree internally
        ✔ All operations are O(log n)
        ✔ Very useful for range-based searching
        */
    }
}
