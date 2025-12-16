import java.util.*;

/*
===============================================================================
📌 JAVA COLLECTIONS FRAMEWORK (JCF) – COLLECTION INTERFACE
===============================================================================

🔹 WHAT IS COLLECTION?
---------------------
Collection is a ROOT INTERFACE of Java Collections Framework (JCF).

• It represents a GROUP OF OBJECTS
• It is present in java.util package
• It is NOT a class → it is an INTERFACE
• It provides common methods that are implemented by:
  - ArrayList
  - LinkedList
  - Stack
  - HashSet
  - TreeSet
  - etc.

⚠ Map is NOT a child of Collection (important interview point)

===============================================================================
📌 WHEN COLLECTION WAS INTRODUCED?
===============================================================================
• Java 1.2 → Collection interface introduced
• Java 1.5 → Iterable interface added
• Java 1.8 → Stream & forEach added

===============================================================================
📌 COLLECTION HIERARCHY (TEXT)
===============================================================================

Iterable (Java 1.5)
   |
Collection (Java 1.2)
   |
-----------------------------------------
|               |               |
List           Set             Queue

===============================================================================
📌 WHY COLLECTION INTERFACE?
===============================================================================
✔ To work with GROUP of objects dynamically
✔ To provide STANDARD API
✔ To support different data structures
✔ To improve reusability & flexibility
✔ To avoid manual array handling

===============================================================================
📌 COMMONLY USED COLLECTION METHODS
===============================================================================

1. size()              → returns number of elements
2. isEmpty()           → checks if collection is empty
3. contains(Object)    → search element
4. add(E e)            → insert element
5. remove(Object)      → remove element
6. addAll(Collection) → add one collection to another
7. removeAll(Collection)
8. containsAll(Collection)
9. clear()
10. iterator()
11. stream() / parallelStream() (Java 8)

===============================================================================
📌 COLLECTION vs COLLECTIONS (IMPORTANT)
===============================================================================

Collection (Interface):
-----------------------
• Part of JCF
• Used to STORE objects
• Implemented by ArrayList, HashSet, etc.

Collections (Utility Class):
----------------------------
• java.util.Collections
• Provides STATIC METHODS
• Used to OPERATE on collections
• Examples:
  sort(), reverse(), shuffle(), max(), min(), binarySearch()

===============================================================================
*/

public class _2_Collection_Interface {

    public static void main(String[] args) {

        /*
        ===========================================================================
        🔹 CREATING A COLLECTION
        ===========================================================================
        */

        Collection<Integer> values = new ArrayList<>();

        values.add(2);
        values.add(3);
        values.add(4);

        /*
        ===========================================================================
        🔹 BASIC COLLECTION METHODS
        ===========================================================================
        */

        System.out.println("Size: " + values.size());          // size()
        System.out.println("isEmpty: " + values.isEmpty());    // isEmpty()
        System.out.println("contains 5: " + values.contains(5)); // contains()

        values.add(5);
        System.out.println("Added 5, contains 5: " + values.contains(5));

        values.remove(5);
        System.out.println("Removed 5, contains 5: " + values.contains(5));

        /*
        ===========================================================================
        🔹 addAll(), containsAll(), removeAll()
        ===========================================================================
        */

        Collection<Integer> extra = new Stack<>();
        extra.add(6);
        extra.add(7);
        extra.add(8);

        values.addAll(extra);
        System.out.println("After addAll, containsAll: " + values.containsAll(extra));

        values.remove(7);
        System.out.println("After removing 7, containsAll: " + values.containsAll(extra));

        values.removeAll(extra);
        System.out.println("After removeAll, contains 8: " + values.contains(8));

        values.clear();
        System.out.println("After clear, isEmpty: " + values.isEmpty());

        /*
        ===========================================================================
        🔹 ITERABLE & ITERATOR
        ===========================================================================
        */

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        System.out.println("\n--- Iteration using Iterator ---");
        Iterator<Integer> itr = list.iterator();

        while (itr.hasNext()) {
            int val = itr.next();
            System.out.println(val);

            // safe removal using iterator
            if (val == 3) {
                itr.remove();
            }
        }

        System.out.println("After iterator remove: " + list);

        /*
        ===========================================================================
        🔹 FOR-EACH LOOP (Enhanced for loop)
        ===========================================================================
        */

        System.out.println("\n--- Iteration using for-each ---");
        for (int val : list) {
            System.out.println(val);
        }

        /*
        ===========================================================================
        🔹 forEach() METHOD (Java 8 - Lambda)
        ===========================================================================
        */

        System.out.println("\n--- Iteration using forEach (Lambda) ---");
        list.forEach(val -> System.out.println(val));

        /*
        ===========================================================================
        🔹 COLLECTIONS UTILITY CLASS
        ===========================================================================
        */

        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(3);
        nums.add(2);
        nums.add(4);

        System.out.println("\n--- Collections Utility Methods ---");

        System.out.println("Max: " + Collections.max(nums));
        System.out.println("Min: " + Collections.min(nums));

        Collections.sort(nums);
        System.out.println("Sorted: " + nums);

        Collections.reverse(nums);
        System.out.println("Reversed: " + nums);

        Collections.shuffle(nums);
        System.out.println("Shuffled: " + nums);

        /*
        ===========================================================================
        🔹 INTERVIEW QUESTIONS & ANSWERS (IMPORTANT)
        ===========================================================================
        */

        /*
        Q1. What is Collection?
        → Collection is an interface that represents a group of objects.

        Q2. Difference between Collection and Collections?
        → Collection is an interface.
        → Collections is a utility class with static methods.

        Q3. Is Map part of Collection?
        → NO. Map is part of JCF but does not extend Collection.

        Q4. Why iterator() is needed?
        → To safely traverse and remove elements.

        Q5. Can we remove elements in for-each loop?
        → NO. It causes ConcurrentModificationException.

        Q6. Which Java version introduced stream()?
        → Java 8.

        Q7. Which interface allows traversal?
        → Iterable.

        Q8. Which method converts collection to array?
        → toArray().

        Q9. Can Collection store primitive types?
        → NO. Only Objects (Wrapper classes).

        Q10. Is Collection synchronized?
        → NO. By default, collections are NOT thread-safe.
        */

        /*
        ===========================================================================
        ✅ SUMMARY
        ===========================================================================
        ✔ Collection is ROOT interface of JCF
        ✔ Used to store group of objects
        ✔ Provides common methods
        ✔ Implemented by List, Set, Queue
        ✔ Collections class provides utility methods
        ✔ Very important for interviews & real projects
        ===========================================================================
        */
    }
}
