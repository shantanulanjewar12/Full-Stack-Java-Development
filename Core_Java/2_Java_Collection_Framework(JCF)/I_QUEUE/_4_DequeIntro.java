/*
===============================================================================
FILE NAME   : DequeIntro.java
FOLDER      : JCF/QUEUE
TOPIC       : Deque (Double Ended Queue) – Java Collections Framework
===============================================================================

-----------------------------
1. WHAT IS DEQUE?
-----------------------------
Deque stands for **Double Ended Queue**.

→ It allows insertion and removal of elements from **both ends**
   - FRONT
   - REAR (BACK)

So unlike normal Queue (FIFO only),
Deque supports:
- FIFO (Queue)
- LIFO (Stack)

---------------------------------
2. POSITION IN JCF HIERARCHY
---------------------------------
Iterable
   ↑
Collection
   ↑
Queue
   ↑
Deque   (interface)
   ↑
ArrayDeque (concrete class)

IMPORTANT:
- Deque is an INTERFACE
- ArrayDeque is the MOST COMMON implementation
- PriorityQueue DOES NOT implement Deque

---------------------------------
3. WHY DEQUE WAS INTRODUCED?
---------------------------------
Problems with older structures:
- Stack class → synchronized, legacy, slow
- Queue → only FIFO
- Needed one structure for BOTH stack & queue

Solution:
→ Deque (introduced in Java 1.6)

---------------------------------
4. ADVANTAGES OF DEQUE
---------------------------------
✔ Insert/remove from both ends
✔ Can behave as Stack & Queue
✔ Faster than Stack
✔ No capacity restriction
✔ No synchronization overhead

---------------------------------
5. IMPORTANT RULES
---------------------------------
✘ Does NOT allow null elements
✘ Not thread-safe (use ConcurrentDeque if needed)

===============================================================================
*/

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class _4_DequeIntro {

    public static void main(String[] args) {

        /*
        ===========================================================
        6. CREATING A DEQUE
        ===========================================================
        */

        Deque<Integer> deque = new ArrayDeque<>();

        /*
        ===========================================================
        7. INSERT OPERATIONS
        ===========================================================
        */

        // ---- FRONT SIDE INSERTION ----

        deque.addFirst(10);     // throws exception if fails
        deque.offerFirst(20);   // returns false if fails



        // ---- REAR SIDE INSERTION ----

        deque.addLast(30);      // throws exception if fails
        deque.offerLast(40);    // returns false if fails

        // Current Deque: [20, 10, 30, 40]
        System.out.println("Deque after insertions: " + deque);


        /*
        ===========================================================
        8. REMOVE OPERATIONS
        ===========================================================
        */

        // ---- FRONT SIDE REMOVAL ----

        System.out.println("removeFirst(): " + deque.removeFirst());
        System.out.println("pollFirst(): " + deque.pollFirst());

        // ---- REAR SIDE REMOVAL ----

        System.out.println("removeLast(): " + deque.removeLast());
        System.out.println("pollLast(): " + deque.pollLast());

        // Deque now empty
        System.out.println("Deque after removals: " + deque);


        /*
        ===========================================================
        9. EXAMINE / PEEK OPERATIONS
        ===========================================================
        */

        deque.add(100);
        deque.add(200);

        System.out.println("getFirst(): " + deque.getFirst());   // exception if empty
        System.out.println("peekFirst(): " + deque.peekFirst()); // null if empty

        System.out.println("getLast(): " + deque.getLast());
        System.out.println("peekLast(): " + deque.peekLast());


        /*
        ===========================================================
        10. DEQUE AS STACK (LIFO)
        ===========================================================
        */

        /*
        Stack operations internally map to:
        push() → addFirst()
        pop()  → removeFirst()
        */

        Deque<Integer> stack = new ArrayDeque<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("\nStack behavior:");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
        // Output: 3, 2, 1


        /*
        ===========================================================
        11. DEQUE AS QUEUE (FIFO)
        ===========================================================
        */

        Deque<Integer> queue = new ArrayDeque<>();

        queue.offer(1);
        queue.offer(2);
        queue.offer(3);

        System.out.println("\nQueue behavior:");
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
        // Output: 1, 2, 3
        // Note: offer() adds to rear, poll() removes from front


        /*
        ===========================================================
        12. ITERATING OVER DEQUE
        ===========================================================
        */

        deque.add(5);
        deque.add(15);
        deque.add(25);

        System.out.println("\nUsing Iterator:");
        Iterator<Integer> it = deque.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("\nUsing for-each:");
        for (int val : deque) {
            System.out.println(val);
        }


        /*
        ===========================================================
        13. TIME COMPLEXITY (ArrayDeque)
        ===========================================================
        addFirst / addLast   → O(1)
        removeFirst / Last  → O(1)
        peek / get          → O(1)
        search              → O(n)
        */


        /*
        ===========================================================
        14. WHEN TO USE DEQUE?
        ===========================================================
        ✔ Sliding Window problems
        ✔ Undo / Redo
        ✔ BFS / DFS
        ✔ Stack replacement
        ✔ Queue replacement
        */
    }
}

/*
===============================================================================
INTERVIEW QUESTIONS (VERY IMPORTANT)
===============================================================================

Q1. Difference between Queue and Deque?
→ Queue supports FIFO
→ Deque supports FIFO + LIFO

Q2. Can PriorityQueue be used as Deque?
→ NO (does not implement Deque)

Q3. Why ArrayDeque is preferred over Stack?
→ Faster
→ No synchronization
→ Modern API

Q4. Does Deque allow null?
→ NO

Q5. How does push() work internally?
→ push() → addFirst()

Q6. Is ArrayDeque thread-safe?
→ NO

Q7. Which Deque method does not throw exception?
→ offerFirst, offerLast, pollFirst, pollLast, peekFirst, peekLast

===============================================================================
END OF FILE
===============================================================================
*/
