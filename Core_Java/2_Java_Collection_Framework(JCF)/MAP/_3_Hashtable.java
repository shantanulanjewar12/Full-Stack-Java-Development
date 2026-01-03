/*
================================================================================
                    HashtableCompleteGuide.java
================================================================================

This file is a COMPLETE, DETAILED, and EXAM + INTERVIEW oriented guide
for Hashtable in Java.

Purpose of this file:
- Learning Java Collections (Map framework)
- Deep understanding of Hashtable
- Interview preparation (freshers + experienced)
- Quick revision before exams/interviews

Style:
- Notes + Theory + Examples
- Step-by-step explanation
- Heavy comments (for notebook writing)
- Beginner to Advanced

================================================================================
*/

import java.util.Hashtable;
import java.util.Map;
import java.util.Set;
import java.util.Collection;
import java.util.Enumeration;

public class _3_Hashtable {

    /*
    ============================================================================
    1️⃣ INTRODUCTION TO HASHTABLE
    ============================================================================
    */

    /*
    What is Hashtable?
    ------------------
    Hashtable is a legacy class in Java that stores data in the form
    of KEY-VALUE pairs.

    Syntax:
    Key   -> must be unique
    Value -> can be duplicate

    Example:
    RollNo -> StudentName
    1      -> "Amit"
    2      -> "Rohit"

    IMPORTANT:
    - Hashtable is SYNCHRONIZED
    - Hashtable does NOT allow null key or null value
    */

    /*
    Why Hashtable exists?
    --------------------
    - Introduced in Java 1.0
    - Used before HashMap existed
    - Provided thread-safety by default
    */

    /*
    Difference between Map and Hashtable:
    -----------------------------------
    Map       -> Interface
    Hashtable -> Concrete class that implements Map
    */

    /*
    Why Hashtable is NOT part of Collection interface?
    --------------------------------------------------
    - Collection deals with SINGLE objects
    - Map deals with KEY-VALUE pairs
    */

    /*
    ============================================================================
    2️⃣ HIERARCHY & THEORY
    ============================================================================
    */

    /*
    Java Map Hierarchy:

           Object
              |
            Map (interface)
              |
         ------------------
         |        |       |
      HashMap  Hashtable LinkedHashMap

    Hashtable implements:
    - Map
    - Serializable
    - Cloneable
    */

    /*
    Relationship:
    -------------
    Object
      ↑
    Dictionary (abstract class)
      ↑
    Hashtable
    */

    /*
    ============================================================================
    3️⃣ INTERNAL WORKING OF HASHTABLE (SIMPLIFIED)
    ============================================================================
    */

    /*
    Working Steps (Simple Words):
    -----------------------------
    1. Key is passed to put(key, value)
    2. hashCode() of key is calculated
    3. Index is generated using hash value
    4. Value is stored in that index
    5. If collision occurs:
       - Uses Linked List (NO Tree like HashMap)
    */

    /*
    IMPORTANT DIFFERENCE FROM HASHMAP:
    ----------------------------------
    - Hashtable does NOT use Red-Black Tree
    - Always uses Linked List for collision
    */

    /*
    ============================================================================
    4️⃣ FEATURES OF HASHTABLE
    ============================================================================
    */

    /*
    ✔ Stores data as key-value pair
    ✔ Thread-safe (synchronized)
    ✔ No null key allowed
    ✔ No null value allowed
    ✔ Slower than HashMap
    ✔ Legacy class
    ✔ Enumeration instead of Iterator
    */

    /*
    ============================================================================
    5️⃣ CONSTRUCTORS OF HASHTABLE
    ============================================================================
    */

    /*
    1. Default Constructor
    */
    Hashtable<Integer, String> ht1 = new Hashtable<>();

    /*
    2. Constructor with initial capacity
    */
    Hashtable<Integer, String> ht2 = new Hashtable<>(20);

    /*
    3. Constructor with capacity and load factor
    */
    Hashtable<Integer, String> ht3 = new Hashtable<>(20, 0.75f);

    /*
    4. Constructor with Map
    */
    Map<Integer, String> map = new Hashtable<>();
    Hashtable<Integer, String> ht4 = new Hashtable<>(map);

    /*
    ============================================================================
    6️⃣ IMPORTANT HASHTABLE METHODS (WITH EXAMPLES)
    ============================================================================
    */

    public static void main(String[] args) {

        Hashtable<Integer, String> table = new Hashtable<>();

        /*
        put()
        -----
        Adds key-value pair
        */
        table.put(1, "Java");
        table.put(2, "Python");

        /*
        get()
        -----
        Returns value for key
        */
        System.out.println(table.get(1));

        /*
        remove()
        --------
        Removes key-value pair
        */
        table.remove(2);

        /*
        containsKey()
        --------------
        */
        System.out.println(table.containsKey(1));

        /*
        containsValue()
        ----------------
        */
        System.out.println(table.containsValue("Java"));

        /*
        size()
        -------
        */
        System.out.println(table.size());

        /*
        isEmpty()
        ----------
        */
        System.out.println(table.isEmpty());

        /*
        keySet()
        --------
        */
        Set<Integer> keys = table.keySet();
        System.out.println(keys);

        /*
        values()
        ---------
        */
        Collection<String> values = table.values();
        System.out.println(values);

        /*
        entrySet()
        ----------
        */
        Set<Map.Entry<Integer, String>> entries = table.entrySet();
        System.out.println(entries);

        /*
        clear()
        -------
        */
        table.clear();
        System.out.println(table.isEmpty());

        /*
        ============================================================================
        7️⃣ ENUMERATION (SPECIAL FOR HASHTABLE)
        ============================================================================
        */

        Hashtable<Integer, String> ht = new Hashtable<>();
        ht.put(1, "A");
        ht.put(2, "B");

        Enumeration<Integer> e = ht.keys();
        while (e.hasMoreElements()) {
            System.out.println(e.nextElement());
        }

        /*
        ============================================================================
        8️⃣ INTERVIEW QUESTIONS (IMPORTANT)
        ============================================================================
        */

        /*
        Q1: Why Hashtable does not allow null?
        ------------------------------------
        Because null key/value can create ambiguity in thread-safe environment.
        */

        /*
        Q2: Why Hashtable is thread-safe?
        --------------------------------
        Because all methods are synchronized internally.
        */

        /*
        Q3: Difference between HashMap and Hashtable?
        --------------------------------------------
        HashMap:
        - Not synchronized
        - Allows 1 null key
        - Faster

        Hashtable:
        - Synchronized
        - No null key/value
        - Slower
        */

        /*
        Q4: Why Hashtable is slower?
        ----------------------------
        Because synchronization locks entire object.
        */

        /*
        ============================================================================
        9️⃣ WHEN TO USE HASHTABLE
        ============================================================================
        */

        /*
        ✔ When thread safety is REQUIRED
        ✔ When working with legacy code
        ✔ When null values should be avoided
        */

        /*
        ❌ When performance is critical
        ❌ When modern concurrency tools exist
        (Prefer ConcurrentHashMap)
        */

        /*
        ============================================================================
        🔟 TIME & SPACE COMPLEXITY
        ============================================================================
        */

        /*
        Time Complexity:
        ----------------
        put()    -> O(1)
        get()    -> O(1)
        remove() -> O(1)
        Worst case -> O(n) (collision)

        Space Complexity:
        -----------------
        O(n)
        */

        /*
        ============================================================================
        END OF HASHTABLE COMPLETE GUIDE
        ============================================================================
        */
    }
}
