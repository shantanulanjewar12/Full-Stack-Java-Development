import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
================================================================================
 FILE NAME  : _2_Iterable_Interface.java
 TOPIC      : Java Collections Framework – Iterable Interface
================================================================================

1. WHAT IS ITERABLE?
--------------------------------------------------------------------------------
- Iterable is the ROOT interface of Java Collection traversal.
- Any class that implements Iterable can be traversed using:
    ✔ Iterator
    ✔ Enhanced for-each loop
    ✔ forEach() (Java 8+)

Declaration:
    public interface Iterable<T>

Package:
    java.lang

Introduced:
    Java 1.5

--------------------------------------------------------------------------------
2. WHY ITERABLE IS NEEDED?
--------------------------------------------------------------------------------
Before Java 1.5:
- No common traversal mechanism
- No enhanced for-loop
- Code was verbose and inconsistent

Iterable solved:
✔ Unified traversal mechanism
✔ Enabled for-each loop
✔ Improved readability
✔ Foundation for Lambdas & Streams

--------------------------------------------------------------------------------
3. POSITION IN JCF HIERARCHY
--------------------------------------------------------------------------------
Iterable
   ↑
Collection
   ↑
List / Set / Queue

NOTE:
- Every Collection is Iterable
- Map is NOT Iterable (Map uses entrySet(), keySet(), values())

--------------------------------------------------------------------------------
4. METHODS OF ITERABLE INTERFACE
--------------------------------------------------------------------------------

1️⃣ iterator()   → Java 1.5
--------------------------------
Iterator<T> iterator();

- Returns an Iterator object
- Used for traversing collection safely

2️⃣ forEach()    → Java 1.8
--------------------------------
default void forEach(Consumer<? super T> action)

- Traverses collection using Lambda expression
- Internally uses Iterator

--------------------------------------------------------------------------------
5. ITERATOR INTERFACE METHODS
--------------------------------------------------------------------------------
Iterator provides 3 important methods:

1. hasNext() → returns true if next element exists
2. next()    → returns next element
3. remove()  → removes last returned element (SAFE)

--------------------------------------------------------------------------------
6. RULES & IMPORTANT POINTS
--------------------------------------------------------------------------------
✔ Iterator allows removal
✔ for-each DOES NOT allow modification
✔ forEach() DOES NOT allow modification
❌ Modifying collection during for-each causes ConcurrentModificationException

--------------------------------------------------------------------------------
7. INTERNAL WORKING OF FOR-EACH
--------------------------------------------------------------------------------
for(int x : list)

Internally converted to:
Iterator<Integer> it = list.iterator();
while(it.hasNext()){
    int x = it.next();
}

--------------------------------------------------------------------------------
8. WHEN TO USE WHAT?
--------------------------------------------------------------------------------
Read only traversal        → for-each
Removal required           → Iterator
Functional programming     → forEach()
Complex data processing    → Streams

================================================================================
*/

public class _2_Iterable_Interface {

    public static void main(String[] args) {

        /*
        ------------------------------------------------------------------------
        EXAMPLE 1: ITERATOR USAGE (SAFE REMOVAL)
        ------------------------------------------------------------------------
        */

        List<Integer> values = new ArrayList<>();

        values.add(1);
        values.add(2);
        values.add(3);
        values.add(4);

        System.out.println("Iterating using Iterator");

        Iterator<Integer> iterator = values.iterator();

        while (iterator.hasNext()) {
            int val = iterator.next();
            System.out.println(val);

            // SAFE removal using iterator
            if (val == 3) {
                iterator.remove();
            }
        }

        System.out.println("After removal: " + values);

        /*
        OUTPUT:
        Iterating using Iterator
        1
        2
        3
        4
        After removal: [1, 2, 4]
        */

        
        /*
        ------------------------------------------------------------------------
        EXAMPLE 2: ENHANCED FOR-EACH LOOP
        ------------------------------------------------------------------------
        */

        System.out.println("\nIterating using for-each loop");

        for (int val : values) {
            System.out.println(val);
        }

        /*
        NOTE:
        - Internally uses Iterator
        - Modification NOT allowed
        */

        /*
        ------------------------------------------------------------------------
        EXAMPLE 3: forEach() METHOD (JAVA 8+)
        ------------------------------------------------------------------------
        */

        System.out.println("\nIterating using forEach() method");

        values.forEach(val -> System.out.println(val));

        /*
        Same using method reference:
        values.forEach(System.out::println);
        */

        /*
        ------------------------------------------------------------------------
        IMPORTANT NOTE ABOUT MAP
        ------------------------------------------------------------------------
        Map does NOT implement Iterable.
        Correct traversal:
            map.entrySet()
            map.keySet()
            map.values()
        */
    }
}

/*
================================================================================
9. INTERVIEW QUESTIONS & ANSWERS
================================================================================

Q1. What is Iterable?
Answer:
Iterable is the root interface that enables traversal of collections using
Iterator, for-each loop, and forEach().

--------------------------------------------------------------------------------
Q2. Why Map does not implement Iterable?
Answer:
Because Map stores key-value pairs and Iterable works on single elements.
Map traversal requires Entry objects.

--------------------------------------------------------------------------------
Q3. Difference between Iterable and Iterator?
Answer:
Iterable provides iterator()
Iterator performs traversal using hasNext(), next(), remove()

--------------------------------------------------------------------------------
Q4. Can we remove elements using for-each?
Answer:
❌ No. It throws ConcurrentModificationException.

--------------------------------------------------------------------------------
Q5. Why iterator.remove() is safe?
Answer:
Because it updates internal modification count properly.

--------------------------------------------------------------------------------
Q6. Which is better: for-each or Iterator?
Answer:
- Read only → for-each
- Modification → Iterator

--------------------------------------------------------------------------------
Q7. When was Iterable introduced?
Answer:
Java 1.5

================================================================================
10. SUMMARY (EXAM READY)
================================================================================
✔ Iterable enables traversal
✔ Root of Collection framework
✔ Enables for-each loop
✔ Iterator allows safe removal
✔ Java 8 added forEach()
✔ Map is not Iterable

================================================================================
END OF FILE
================================================================================
*/
