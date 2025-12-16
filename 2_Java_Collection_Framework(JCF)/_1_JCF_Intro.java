/**
 * ============================================================
 * FILE NAME  : _1_JCF_Intro.java
 * FOLDER     : JCF
 * TOPIC      : Java Collections Framework - Introduction
 * ============================================================
 *
 * =========================
 * 1. WHAT IS JCF?
 * =========================
 *
 * JCF stands for Java Collections Framework.
 *
 * Definition:
 * Java Collections Framework is a unified architecture
 * that provides:
 * ✔ Interfaces
 * ✔ Classes
 * ✔ Algorithms
 *
 * to store, manipulate, retrieve and process
 * GROUPS OF OBJECTS efficiently.
 *
 * NOTE:
 * JCF works only with OBJECTS (not primitives).
 *
 * =========================
 * 2. WHEN WAS JCF INTRODUCED?
 * =========================
 *
 * JCF was introduced in:
 * 👉 Java 1.2 (1998)
 *
 * Later enhancements:
 * - Java 5 → Generics
 * - Java 8 → Streams, Lambdas
 *
 * =========================
 * 3. WHY JCF WAS NEEDED?
 * =========================
 *
 * BEFORE JCF:
 * ❌ Arrays were used
 *
 * Problems with Arrays:
 * - Fixed size
 * - No built-in methods
 * - Manual sorting/searching
 * - No standard data structures
 * - Not dynamic
 *
 * Example:
 * int[] arr = new int[10]; // fixed size
 *
 * AFTER JCF:
 * ✔ Dynamic size
 * ✔ Ready-made data structures
 * ✔ Rich APIs
 * ✔ Standard implementation
 *
 * =========================
 * 4. WHAT DOES JCF PROVIDE?
 * =========================
 *
 * JCF provides 3 main things:
 *
 * 1️⃣ Interfaces
 *    - List
 *    - Set
 *    - Queue
 *    - Deque
 *    - Map
 *
 * 2️⃣ Classes (Implementations)
 *    - ArrayList
 *    - LinkedList
 *    - HashSet
 *    - TreeSet
 *    - HashMap
 *    - TreeMap
 *
 * 3️⃣ Algorithms
 *    - Sorting
 *    - Searching
 *    - Shuffling
 *    - Reversing
 *
 * =========================
 * 5. KEY COMPONENTS OF JCF
 * =========================
 *
 * 1. Collection Interface
 * 2. Map Interface
 * 3. Iterator Interface
 *
 * =========================
 * 6. HIERARCHY OVERVIEW (HIGH LEVEL)
 * =========================
 *
 * Iterable
 *    |
 * Collection
 *    |
 * -----------------------------
 * |            |             |
 * List         Set           Queue
 *
 * Map (separate hierarchy)
 *
 * =========================
 * 7. WHY USE JCF?
 * =========================
 *
 * ✔ Dynamic size
 * ✔ Reusable data structures
 * ✔ Well-tested & optimized
 * ✔ Consistent API
 * ✔ Reduces coding effort
 * ✔ Increases performance
 *
 * =========================
 * 8. ADVANTAGES OF JCF
 * =========================
 *
 * ✔ Performance
 * ✔ Scalability
 * ✔ Maintainability
 * ✔ Readability
 * ✔ Interoperability
 *
 * =========================
 * 9. IMPORTANT POINTS
 * =========================
 *
 * ✔ Collections store OBJECTS only
 * ✔ Wrapper classes used for primitives
 * ✔ All collection classes are in
 *   java.util package
 *
 * =========================
 * 10. REAL-WORLD USAGE
 * =========================
 *
 * ✔ Storing users
 * ✔ Managing orders
 * ✔ Caching data
 * ✔ Maintaining logs
 * ✔ Backend systems
 *
 * ============================================================
 */

import java.util.ArrayList;
import java.util.Collection;

public class _1_JCF_Intro {

    public static void main(String[] args) {

        // Simple example using JCF
        Collection<String> names = new ArrayList<>();

        names.add("Shantanu");
        names.add("Java");
        names.add("Collections");

        System.out.println("Names: " + names);
    }
}



/*

🧠 KEY INTERVIEW POINTS (REMEMBER THIS)

✔ JCF introduced in Java 1.2
✔ Works only with objects
✔ Provides Interfaces + Classes + Algorithms
✔ Solves array limitations
✔ Standard & reusable



🎯 INTERVIEW QUESTIONS & ANSWERS

Q1: What is Java Collections Framework?
A: A unified architecture to store and manipulate groups of objects.

Q2: Why JCF was introduced?
A: To overcome limitations of arrays.

Q3: Which package contains JCF?
A: java.util

Q4: Does JCF store primitives?
A: ❌ No, only objects.

Q5: What are main components of JCF?
A: Interfaces, Implementations, Algorithms.

Q6 (TRICKY): Is Map part of Collection?
A: ❌ No, Map is a separate hierarchy.


Difference between Object and Primitive in JCF:
- Object: Instance of a class (e.g., String, Integer)
- Primitive: Basic data type (e.g., int, char)


*/