/*
================================================================================
1. WHAT IS STACK?
================================================================================
- Stack is a CLASS in Java that represents a LIFO data structure.
- LIFO = Last In First Out

Example (Real life):
- Stack of plates
- Undo/Redo operations
- Function call stack

Definition:
Stack is a legacy class that extends Vector and provides LIFO operations.

Package:
java.util.Stack

Introduced:
Java 1.0 (Legacy)

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
Stack

IMPORTANT:
- Stack is a subclass of Vector
- Hence Stack is synchronized (thread-safe)

================================================================================
3. WHY STACK IS CALLED LEGACY?
================================================================================
- Introduced before Java 1.2
- Uses old synchronization model (method-level synchronized)
- Poor performance
- Modern alternatives exist

Modern replacement:
✔ ArrayDeque

================================================================================
4. FEATURES OF STACK
================================================================================
✔ LIFO order
✔ Thread-safe
✔ Allows duplicates
✔ Allows null values
✔ Extends Vector
✔ Legacy class

================================================================================
5. INTERNAL WORKING OF STACK
================================================================================
- Stack internally uses Vector
- Hence internally backed by a dynamic array
- Capacity grows same as Vector

Growth:
Default capacity = 10
Growth factor = 2x

================================================================================
6. TIME & SPACE COMPLEXITY
================================================================================
Operation         Time Complexity
---------------------------------
push()            O(1)
pop()             O(1)
peek()            O(1)
search()          O(n)

Space Complexity: O(n)

================================================================================
7. STACK CONSTRUCTORS
================================================================================
- Stack has ONLY default constructor
// meaning no capacity or load factor parameters
Stack<E> stack = new Stack<>();
================================================================================
*/

import java.util.*;

public class _5_Stack {

    public static void main(String[] args) {

        /*
        =================================================================================
        8. CREATING STACK
        =================================================================================
        */

        Stack<Integer> stack = new Stack<>();

        /*
        =================================================================================
        9. STACK BASIC OPERATIONS (VERY IMPORTANT)
        =================================================================================
        */

        // push(E element)
        // Adds element to top of stack
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // peek()
        // Returns top element WITHOUT removing it
        int top = stack.peek();
        System.out.println("Top element: " + top); // Output: 30

        // pop()
        // Removes and returns top element
        int removed = stack.pop();
        System.out.println("Removed element: " + removed); // Output: 30

        /*
        Stack content after operations:
        push 10,20,30 → [10, 20, 30]
        pop() → removes 30 → [10, 20]
        */

        /*
        =================================================================================
        10. OTHER STACK METHODS
        =================================================================================
        */

        // empty()
        // Returns true if stack is empty
        boolean isEmpty = stack.empty();
        System.out.println("Is stack empty? " + isEmpty); // Output: false

        // search(Object o)
        // Returns 1-based position from top
        // Returns -1 if not found
        stack.push(40);
        stack.push(50);
        int pos = stack.search(40); // position from top
        System.out.println("Position of 40 from top: " + pos); // Output: 2

        /*
        Example:
        Stack = [10, 20, 40, 50]
        search(40) → 2
        */

        /*
        =================================================================================
        11. STACK INHERITED METHODS (FROM VECTOR)
        =================================================================================
        */

        stack.add(100);        // inherited from Vector
        stack.get(0);          // index-based access
        stack.remove(0);

        /*
        =================================================================================
        12. ITERATION IN STACK
        =================================================================================
        */

        // Iterator (fail-fast)
        Iterator<Integer> it = stack.iterator();
        while (it.hasNext()) {
            it.next();
        }

        // Enumeration (legacy, fail-safe)
        Enumeration<Integer> e = stack.elements();
        while (e.hasMoreElements()) {
            e.nextElement();
        }

        /*
        =================================================================================
        13. STACK vs ARRAYDEQUE (VERY IMPORTANT INTERVIEW)
        =================================================================================
        */

        /*
        Stack:
        - Legacy
        - Thread-safe
        - Slower

        ArrayDeque:
        - Modern
        - Not synchronized
        - Faster
        - Recommended for stack operations
        */

        /*
        Example using ArrayDeque as Stack:

        Deque<Integer> dq = new ArrayDeque<>();
        dq.push(10);
        dq.push(20);
        dq.pop();
        */

        /*
        =================================================================================
        14. WHEN TO USE STACK?
        =================================================================================
        */

        /*
        ❌ Avoid Stack in modern applications
        ✔ Use only when working with legacy code
        ✔ Prefer ArrayDeque for stack behavior
        */

        /*
        =================================================================================
        15. INTERVIEW QUESTIONS & ANSWERS
        =================================================================================
        */

        /*
        Q1. Is Stack synchronized?
        ✔ Yes (inherits from Vector)

        Q2. Why Stack is legacy?
        ✔ Old design + poor performance

        Q3. Which is better: Stack or ArrayDeque?
        ✔ ArrayDeque

        Q4. Does Stack allow null?
        ✔ Yes

        Q5. What is search() return value?
        ✔ 1-based position from top
        */

        /*
        =================================================================================
        16. KEY TAKEAWAYS
        =================================================================================
        */

        /*
        ✔ Stack follows LIFO
        ✔ Extends Vector
        ✔ Thread-safe but slow
        ✔ Legacy class
        ✔ Prefer ArrayDeque
        */
    }
}
