/*
================================================================================
1. WHAT IS VECTOR?
================================================================================
- Vector is a RESIZABLE ARRAY implementation of the List interface.
- It is a LEGACY class of Java.
- Vector is THREAD-SAFE (synchronized by default).

Definition:
Vector is a dynamic array that grows automatically and provides
synchronized access to its elements.

Package:
java.util.Vector

Introduced:
Java 1.0 (before JCF)

================================================================================
2. POSITION IN JCF HIERARCHY
================================================================================
Iterable
  ↓
Collection
  ↓
List
  ↓
Vector
  ↓
Stack (extends Vector)

NOTE:
- Vector was retrofitted into JCF in Java 1.2

================================================================================
3. WHY VECTOR WAS INTRODUCED?
================================================================================
Before JCF:
- No Collection Framework
- No thread-safe dynamic array

Vector provided:
✔ Dynamic resizing
✔ Thread safety
✔ Index-based access

================================================================================
4. WHY VECTOR IS CALLED LEGACY?
================================================================================
- Introduced before Java 1.2
- Uses old synchronization approach
- Entire methods are synchronized
- Performance is poor compared to modern alternatives

Modern replacements:
- Collections.synchronizedList(new ArrayList<>())
- CopyOnWriteArrayList

================================================================================
5. FEATURES OF VECTOR
================================================================================
✔ Maintains insertion order
✔ Allows duplicate elements
✔ Allows multiple null values
✔ Index-based access
✔ Thread-safe (synchronized)
✔ Legacy Enumeration support

================================================================================
6. INTERNAL WORKING OF VECTOR
================================================================================
- Internally uses Object[] array
- Default capacity = 10

Capacity growth:
- By default: doubles size (2x)
- Or grows using capacityIncrement
// capacityIncrement: additional size when resizing 
// how does capacityIncrement work?
- If capacityIncrement specified, increases by that amount
- If capacityIncrement not specified, doubles capacity

Example:
10 → 20 → 40 → 80

================================================================================
7. TIME & SPACE COMPLEXITY
================================================================================
Operation                  Time Complexity
------------------------------------------------
Access by index            O(1)
Insert at end              O(1) amortized
Insert at index            O(n)
Delete at index            O(n)
Search                     O(n)

Space Complexity:
O(n)

================================================================================
8. VECTOR CONSTRUCTORS
================================================================================
*/

import java.util.*;

public class _4_Vector {

    public static void main(String[] args) {

        // 1. Default constructor
        Vector<Integer> v1 = new Vector<>();

        // 2. Initial capacity
        Vector<Integer> v2 = new Vector<>(20);
        v2.size();        // 0

        // 3. Initial capacity + capacity increment
        Vector<Integer> v3 = new Vector<>(10, 5);
        v3.size();        // 0

        /*
        =================================================================================
        9. BASIC VECTOR METHODS (FROM LIST & COLLECTION)
        =================================================================================
        */

        v1.add(10);
        v1.add(20);
        v1.add(20);
        v1.add(null);

        v1.size();        // number of elements
        v1.isEmpty();     // check empty
        v1.contains(10);  // search element

        /*
        =================================================================================
        10. VECTOR-SPECIFIC METHODS (IMPORTANT)
        =================================================================================
        */

        // addElement(E element)
        // Legacy method (same as add)
        v1.addElement(30);

        // elementAt(int index)
        int x = v1.elementAt(1);
        System.out.println(x);  // 20

        // firstElement()
        v1.firstElement(); // output: 10

        // lastElement()
        v1.lastElement(); // output: 30

        // removeElement(Object o)
        v1.removeElement(20);

        // removeElementAt(int index)
        v1.removeElementAt(0);

        /*
        =================================================================================
        11. ENUMERATION (LEGACY ITERATION)
        =================================================================================
        */
       // what does Enumeration do?
       // It provides a way to traverse through the elements of a Vector (or other legacy collections

        Enumeration<Integer> e = v1.elements();

        while (e.hasMoreElements()) {
            System.out.println(e.nextElement());
        }

        /*
        =================================================================================
        12. ITERATOR & LISTITERATOR
        =================================================================================
        */

        // Iterator (fail-fast)
        Iterator<Integer> it = v1.iterator();
        while (it.hasNext()) {
            it.next();
        }

        // ListIterator (bidirectional)
        ListIterator<Integer> li = v1.listIterator();
        while (li.hasNext()) {
            li.next();
        }

        /*
        =================================================================================
        13. SYNCHRONIZATION IN VECTOR
        =================================================================================
        */

        /*
        - All public methods of Vector are synchronized
        - Only ONE thread can access at a time
        - Thread-safe but SLOW
        */

        /*
        =================================================================================
        14. VECTOR vs ARRAYLIST
        =================================================================================
        */

        /*
        ArrayList:
        ✔ Faster
        ✔ Not synchronized
        ✔ Modern

        Vector:
        ❌ Slower
        ✔ Synchronized
        ❌ Legacy
        */

        /*
        =================================================================================
        15. VECTOR vs CopyOnWriteArrayList
        =================================================================================
        */

        /*
        Vector:
        - Synchronizes every method
        - Blocks threads

        CopyOnWriteArrayList:
        - Better concurrency
        - No blocking reads
        */

        /*
        =================================================================================
        16. WHEN TO USE VECTOR?
        =================================================================================
        */

        /*
        ❌ Rarely used in modern applications
        ✔ Only when legacy code demands it
        */

        /*
        =================================================================================
        17. INTERVIEW QUESTIONS & ANSWERS
        =================================================================================
        */

        /*
        Q1. Is Vector thread-safe?
        ✔ Yes

        Q2. Why Vector is slow?
        ✔ Method-level synchronization

        Q3. Difference between Vector and ArrayList?
        ✔ Thread safety

        Q4. Is Enumeration fail-fast?
        ❌ No (fail-safe)
        fail-fast meaning: throws ConcurrentModificationException if modified during iteration

        Q5. Should we use Vector today?
        ❌ No
        */

        /*
        =================================================================================
        18. KEY TAKEAWAYS
        =================================================================================
        */

        /*
        ✔ Vector is legacy
        ✔ Thread-safe but slow
        ✔ Enumeration is legacy traversal
        ✔ Prefer modern alternatives
        */
    }
}
