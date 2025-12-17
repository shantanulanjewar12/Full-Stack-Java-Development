import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;

/*
================================================================================
1️⃣ WHAT IS DEQUE?
-----------------
Deque stands for **Double Ended Queue**.

→ It allows insertion and deletion from **both ends**
   - Front
   - Rear

So Deque can behave as:
✔ Queue (FIFO)
✔ Stack (LIFO)

Hierarchy:
Iterable
   ↓
Collection
   ↓
Queue
   ↓
Deque
   ↓
ArrayDeque (Concrete Class)

--------------------------------------------------------------------------------
2️⃣ WHY DEQUE WAS INTRODUCED?
----------------------------
Problems with older structures:
- Stack is legacy (Vector based, synchronized, slow)
- Queue was single-ended

Deque solves:
✔ Stack + Queue in one structure
✔ Better performance
✔ Cleaner API
✔ No legacy issues

--------------------------------------------------------------------------------
3️⃣ ARRAYDEQUE
--------------
ArrayDeque is a **resizable-array implementation** of Deque.

✔ Faster than Stack
✔ Faster than LinkedList for Deque operations
✔ No capacity restriction
❌ Not thread-safe
❌ Does NOT allow null elements

--------------------------------------------------------------------------------
4️⃣ QUEUE METHODS (Inherited by Deque)
-------------------------------------
add()        → internally calls addLast()
offer()      → internally calls offerLast()
poll()       → internally calls pollFirst()
remove()     → internally calls removeFirst()
peek()       → internally calls peekFirst()
element()    → internally calls getFirst()

--------------------------------------------------------------------------------
5️⃣ DEQUE METHODS (FRONT & REAR)
--------------------------------
INSERT:
- addFirst(e)     → throws exception if fails
- offerFirst(e)   → returns true/false
- addLast(e)
- offerLast(e)

REMOVE:
- removeFirst()   → throws exception
- pollFirst()     → returns null if empty
- removeLast()
- pollLast()

EXAMINE:
- getFirst()      → throws exception
- peekFirst()     → returns null
- getLast()
- peekLast()

--------------------------------------------------------------------------------
6️⃣ USING DEQUE AS QUEUE (FIFO)
--------------------------------
Insert at LAST
Remove from FIRST

--------------------------------------------------------------------------------
7️⃣ USING DEQUE AS STACK (LIFO)
--------------------------------
Insert at FIRST
Remove from FIRST

push() → internally calls addFirst()
pop()  → internally calls removeFirst()

--------------------------------------------------------------------------------
8️⃣ TIME & SPACE COMPLEXITY (ArrayDeque)
----------------------------------------
Insertion     → O(1) amortized
// amortized means occasional resizing may take O(n), but average is O(1)
Deletion      → O(1)
Search        → O(1) (head/tail)
Worst Insert  → O(n) (resize case)
Space         → O(n)

--------------------------------------------------------------------------------
9️⃣ THREAD SAFETY
-----------------
ArrayDeque → NOT thread-safe

Thread-safe alternatives:
✔ ConcurrentLinkedDeque
✔ PriorityBlockingQueue (for priority use cases)

================================================================================
*/

public class _5_ArrayDeque {

    public static void main(String[] args) {

        /*
        ============================================================================
        EXAMPLE 1️⃣ : USING ARRAYDEQUE AS QUEUE (FIFO)
        ============================================================================
        */

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        // Insertion (Rear)
        queue.add(1);        // addLast(1)
        queue.offer(5);      // offerLast(5)
        queue.add(10);       // addLast(10)

        // Queue looks like: [1, 5, 10]

        // Removal (Front)
        int removedQueueElement = queue.poll(); // pollFirst()

        System.out.println("Queue removed element (FIFO): " + removedQueueElement);
        // Output: 1


        /*
        ============================================================================
        EXAMPLE 2️⃣ : USING ARRAYDEQUE AS STACK (LIFO)
        ============================================================================
        */

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        // Push (addFirst)
        stack.push(1);   // internally addFirst(1)
        stack.push(5);   // addFirst(5)
        stack.push(10);  // addFirst(10)

        // Stack looks like: [10, 5, 1]

        // Pop (removeFirst)
        int removedStackElement = stack.pop();

        System.out.println("Stack removed element (LIFO): " + removedStackElement);
        // Output: 10


        /*
        ============================================================================
        EXAMPLE 3️⃣ : DEQUE FRONT & REAR OPERATIONS
        ============================================================================
        */

        Deque<Integer> deque = new ArrayDeque<>();

        deque.addFirst(100);
        deque.addLast(200);
        deque.offerFirst(50);
        deque.offerLast(300);

        // Deque: [50, 100, 200, 300]

        System.out.println("First Element: " + deque.peekFirst()); // 50
        System.out.println("Last Element: " + deque.peekLast());   // 300

        deque.removeFirst(); // removes 50
        deque.removeLast();  // removes 300

        // Deque now: [100, 200]

        System.out.println("Deque after removals: " + deque);


        /*
        ============================================================================
        EXAMPLE 4️⃣ : NULL ELEMENT NOT ALLOWED
        ============================================================================
        */

        // deque.add(null); ❌ Throws NullPointerException


        /*
        ============================================================================
        EXAMPLE 5️⃣ : THREAD-SAFE DEQUE (ConcurrentLinkedDeque)
        ============================================================================
        */

        ConcurrentLinkedDeque<Integer> concurrentDeque =
                new ConcurrentLinkedDeque<>();

        concurrentDeque.addFirst(2);
        concurrentDeque.addLast(1);

        System.out.println("Thread-safe deque removed: "
                + concurrentDeque.removeLast());
        // Output: 1


        /*
        ============================================================================
        SUMMARY
        ============================================================================
        ✔ Deque = Double Ended Queue
        ✔ ArrayDeque is best general-purpose Deque
        ✔ Can replace Stack and Queue
        ✔ Faster, cleaner, modern
        ✔ Use ConcurrentLinkedDeque for multithreading
        */
    }
}
