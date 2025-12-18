import java.util.SortedMap;
import java.util.TreeMap;


public class _6_SortedMap {

    public static void main(String[] args) {

        /*
         ================================================================
         1️⃣ WHAT IS SORTEDMAP?
         ================================================================

         ✔ SortedMap is an INTERFACE
         ✔ It extends the Map interface
         ✔ It stores data in SORTED ORDER of KEYS

         ❓ Sorted based on what?
            → Natural ordering of keys
            → OR Comparator (if provided)

         ❗ Only TreeMap implements SortedMap
        */

        /*
         ================================================================
         2️⃣ WHY SORTEDMAP EXISTS?
         ================================================================

         ✔ HashMap → NO order
         ✔ LinkedHashMap → Insertion order
         ✔ TreeMap / SortedMap → SORTED order

         ✔ Needed when:
           - Data must always stay sorted
           - First / Last key is important
           - Range based operations needed
        */

        /*
         ================================================================
         3️⃣ SORTEDMAP HIERARCHY
         ================================================================

             Map (interface)
               ↑
           SortedMap (interface)
               ↑
           NavigableMap (interface)
               ↑
            TreeMap (class)
        */

        /*
         ================================================================
         4️⃣ CREATING SORTEDMAP
         ================================================================
        */

        SortedMap<Integer, String> map = new TreeMap<>();

        map.put(21, "SJ");
        map.put(11, "PJ");
        map.put(13, "KJ");
        map.put(5,  "TJ");

        // Internally TreeMap stores keys in SORTED order
        // Keys become: 5, 11, 13, 21

        System.out.println("Original SortedMap: " + map);
        // Output: {5=TJ, 11=PJ, 13=KJ, 21=SJ}

        /*
         ================================================================
         5️⃣ SORTEDMAP METHODS (CORE PART)
         ================================================================
        */

        /*
         ------------------------------------------------
         1️⃣ headMap(K toKey)
         ------------------------------------------------

         ▶ Definition:
           Returns a map of keys LESS THAN toKey

         ▶ Inclusive?
           ❌ NO (toKey is EXCLUDED)

         ▶ How it works:
           Takes all keys smaller than given key
        */

        SortedMap<Integer, String> headMap = map.headMap(13);
        System.out.println("headMap(13): " + headMap);

        // Keys < 13 → 5, 11
        // Output: {5=TJ, 11=PJ}

        /*
         ------------------------------------------------
         2️⃣ tailMap(K fromKey)
         ------------------------------------------------

         ▶ Definition:
           Returns a map of keys GREATER THAN OR EQUAL to fromKey

         ▶ Inclusive?
           ✅ YES (fromKey INCLUDED)

         ▶ How it works:
           Takes all keys >= fromKey
        */

        SortedMap<Integer, String> tailMap = map.tailMap(13);
        System.out.println("tailMap(13): " + tailMap);

        // Keys >= 13 → 13, 21
        // Output: {13=KJ, 21=SJ}

        /*
         ------------------------------------------------
         3️⃣ firstKey()
         ------------------------------------------------

         ▶ Definition:
           Returns the SMALLEST key

         ▶ How it works:
           TreeMap always keeps smallest key at first position
        */

        Integer firstKey = map.firstKey();
        System.out.println("firstKey(): " + firstKey);

        // Output: 5

        /*
         ------------------------------------------------
         4️⃣ lastKey()
         ------------------------------------------------

         ▶ Definition:
           Returns the LARGEST key

         ▶ How it works:
           TreeMap always keeps largest key at last position
        */

        Integer lastKey = map.lastKey();
        System.out.println("lastKey(): " + lastKey);

        // Output: 21

        /*
         ================================================================
         6️⃣ IMPORTANT RULES & POINTS
         ================================================================

         ✔ Keys MUST be comparable
         ✔ Null key ❌ NOT allowed (TreeMap)
         ✔ Values can be null
         ✔ Duplicate keys NOT allowed
         ✔ Sorting is based ONLY on keys
         */

        /*
         ================================================================
         7️⃣ INTERNAL WORKING (VERY SIMPLE WORDS)
         ================================================================

         ✔ TreeMap uses RED-BLACK TREE
         ✔ Each key is placed in correct sorted position
         ✔ Search / Insert / Delete → O(log n)

         ✔ That is why TreeMap is slower than HashMap
           but gives sorted data
        */

        /*
         ================================================================
         8️⃣ TIME & SPACE COMPLEXITY
         ================================================================

         Insert   → O(log n)
         Search   → O(log n)
         Delete   → O(log n)
         Space    → O(n)
        */

        /*
         ================================================================
         9️⃣ WHEN TO USE SORTEDMAP?
         ================================================================

         ✔ When sorted data is required
         ✔ When first/last element needed
         ✔ When range queries needed

         ❌ When performance is critical and order not required
        */

        /*
         ================================================================
         🔟 INTERVIEW ONE-LINERS
         ================================================================

         ✔ SortedMap sorts keys automatically
         ✔ TreeMap implements SortedMap
         ✔ headMap → less than key
         ✔ tailMap → greater than or equal
         ✔ firstKey → smallest
         ✔ lastKey → largest
        */
    }
}
