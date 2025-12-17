/*
================================================================================
1. WHAT IS LIST?
================================================================================
- List is an ORDERED collection of objects.
- Allows DUPLICATE values.
- Allows NULL elements (implementation dependent).
- Index-based (starts from 0).

Hierarchy:
Iterable → Collection → List

Key Difference from Queue:
- Queue: insertion/removal only at ends (FIFO / priority based)
- List : insertion, removal, access ANYWHERE using index

================================================================================
2. LIST IMPLEMENTATIONS
================================================================================
ArrayList   → Dynamic array
LinkedList  → Doubly linked list
Vector      → Legacy + synchronized
Stack       → Legacy (extends Vector)

================================================================================
3. WHAT IS ARRAYLIST?
================================================================================
- ArrayList is a RESIZABLE ARRAY implementation of List interface.
- Introduced in Java 1.2 (JCF).
- Stores elements in INSERTION ORDER.

Package:
java.util.ArrayList

================================================================================
4. WHY ARRAYLIST?
================================================================================
Problems with Array:
- Fixed size
- No inbuilt methods

ArrayList Advantages:
✔ Dynamic resizing
✔ Rich API
✔ Random access
✔ Easy traversal

================================================================================
5. FEATURES OF ARRAYLIST
================================================================================
✔ Maintains insertion order
✔ Allows duplicates
✔ Allows multiple nulls
✔ Index-based access
✔ Not thread-safe
✔ Fast read operations

================================================================================
6. INTERNAL WORKING OF ARRAYLIST
================================================================================
- Internally uses Object[] array
- Default capacity = 10
- Growth formula:
  newCapacity = oldCapacity + (oldCapacity / 2)

Example:
10 → 15 → 22 → 33

When array grows:
1. New array created
2. Old elements copied
3. Old array eligible for GC

================================================================================
7. TIME & SPACE COMPLEXITY
================================================================================
Access by index        O(1)
Insert at end          O(1) (Amortized)
Insert at index        O(n)
Delete at index        O(n)
Search                 O(n)

Space Complexity: O(n)

================================================================================
8. ARRAYLIST CREATION
================================================================================
*/

import java.util.*;

public class _2_ArrayList {

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();

        /*
        =================================================================================
        9. BASIC COLLECTION METHODS
        =================================================================================
        */

        list.add(10);
        list.add(20);
        list.add(20);
        list.add(null);

        list.size();        // total elements
        list.isEmpty();     // true/false
        list.contains(10);  // true/false
        list.clear();       // removes all elements

        /*
        =================================================================================
        10. LIST-SPECIFIC METHODS (DETAILED)
        =================================================================================
        */

        // add(int index, E element)
        // Inserts element at given index
        // Shifts existing elements to RIGHT
        // Throws IndexOutOfBoundsException
        list.add(0, 100);

        // addAll(int index, Collection c)
        // Inserts entire collection starting at index
        // Elements at index & after are shifted RIGHT
        list.addAll(1, Arrays.asList(200, 300));


        // get(int index)
        // Returns element at index
        int val = list.get(0);
        System.out.println(val);


        // set(int index, E element)
        // Replaces element at index
        list.set(0, 999);


        // remove(int index)
        // Removes element & shifts elements LEFT
        list.remove(1);


        // indexOf(Object o)
        // Returns FIRST occurrence index
        // Returns -1 if not found
        list.indexOf(20);


        // lastIndexOf(Object o)
        // Returns LAST occurrence index
        list.lastIndexOf(20);


        /*
        =================================================================================
        11. SORTING
        =================================================================================
        */

        // sort(Comparator)
        // Ascending
        list.sort((a, b) -> a - b);

        // Descending
        list.sort((a, b) -> b - a);

        /*
        =================================================================================
        12. replaceAll(UnaryOperator)
        =================================================================================
        */

        // Applies operation on EACH element
        list.replaceAll(e -> e * -1);

        /*
        =================================================================================
        13. ITERATORS
        =================================================================================
        */

        // iterator() → forward only
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            it.next(); // Access element 
        }

        /*
        =================================================================================
        14. LISTITERATOR (VERY IMPORTANT)
        =================================================================================
        */

        // listIterator()
        ListIterator<Integer> li = list.listIterator();

        // Forward traversal
        while (li.hasNext()) {
            li.next();
        }

        // Backward traversal
        while (li.hasPrevious()) {
            li.previous();
        }

        // listIterator(int index)
        // Iterator starts FROM index
        ListIterator<Integer> li2 = list.listIterator(1);
        System.out.println(li2);

        /*
        =================================================================================
        15. subList(fromIndex, toIndex)
        =================================================================================
        */
        // fromIndex → INCLUSIVE
        // toIndex   → EXCLUSIVE
        List<Integer> sub = list.subList(0, 2);
        System.out.println(sub);

        // IMPORTANT:
        // subList is a VIEW, not a copy
        // Changes reflect in main list

        /*
        =================================================================================
        16. THREAD SAFETY
        =================================================================================
        */

        // ArrayList is NOT thread-safe

        // Thread-safe alternatives:
        // List<Integer> syncList = Collections.synchronizedList(new ArrayList<>());
        // List<Integer> cowList = new java.util.concurrent.CopyOnWriteArrayList<>();

        /*
        =================================================================================
        17. IMPORTANT INTERVIEW POINTS
        =================================================================================
        */

        /*
        ✔ Default capacity = 10
        ✔ Growth factor = 1.5x
        ✔ RandomAccess marker interface
        ✔ Fail-fast iterator
        ✔ Best for read-heavy applications
        */
    }
}
