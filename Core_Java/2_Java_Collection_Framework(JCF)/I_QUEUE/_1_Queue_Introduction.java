import java.util.*;

/**
 * ============================================================
 *  QUEUE - JAVA COLLECTIONS FRAMEWORK
 * ============================================================
 *
 * Queue is an INTERFACE present in java.util package.
 * It is a CHILD interface of Collection.
 *
 * Queue represents a data structure that follows:
 *      FIFO (First In First Out)
 *
 * Insertion  -> happens at REAR
 * Removal    -> happens from FRONT
 *
 * ------------------------------------------------------------
 * REAL LIFE EXAMPLES:
 * ------------------------------------------------------------
 * 1. Printer job queue
 * 2. Ticket booking queue
 * 3. CPU task scheduling
 * 4. Call center waiting line
 *
 * ------------------------------------------------------------
 * IMPORTANT NOTE:
 * ------------------------------------------------------------
 * - Queue generally follows FIFO
 * - BUT PriorityQueue is an EXCEPTION (priority-based ordering)
 *
 * ------------------------------------------------------------
 * QUEUE HIERARCHY (IMPORTANT FOR INTERVIEWS):
 * ------------------------------------------------------------
 * Iterable
 *   └── Collection
 *         └── Queue
 *               ├── PriorityQueue
 *               └── Deque
 *                     ├── ArrayDeque
 *                     └── LinkedList
 *
 * ============================================================
 */

public class _1_Queue_Introduction {

    public static void main(String[] args) {

        /*
         * --------------------------------------------------------
         * Creating a Queue
         * --------------------------------------------------------
         * Queue is an INTERFACE, so we cannot create its object.
         * We use implementing classes like:
         *
         * - LinkedList
         * - PriorityQueue
         * - ArrayDeque
         */

        Queue<Integer> queue = new LinkedList<>();

        /*
         * ========================================================
         * INSERTION METHODS
         * ========================================================
         */

        /*
         * add(element)
         * --------------------------------------------------------
         * - Inserts element into queue
         * - Returns TRUE if insertion successful
         * - Throws EXCEPTION if insertion fails
         * - Null elements NOT allowed (NullPointerException)
         */
        queue.add(10);
        queue.add(20);


        /*
         * offer(element)
         * --------------------------------------------------------
         * - Inserts element into queue
         * - Returns TRUE if successful
         * - Returns FALSE if insertion fails
         * - No exception on failure
         * - Null elements NOT allowed
         */
        queue.offer(30);
        queue.offer(40);
        System.out.println("Queue after insertion: " + queue);



        /*
         * ========================================================
         * RETRIEVAL + REMOVAL METHODS
         * ========================================================
         */

        /*
         * poll()
         * --------------------------------------------------------
         * - Retrieves and REMOVES head of queue
         * - Returns NULL if queue is empty
         */
        System.out.println("poll(): " + queue.poll());
        System.out.println("Queue after poll: " + queue);

        /*
         * remove()
         * --------------------------------------------------------
         * - Retrieves and REMOVES head of queue
         * - Throws NoSuchElementException if queue is empty
         */
        System.out.println("remove(): " + queue.remove());
        System.out.println("Queue after remove: " + queue);

        /*
         * ========================================================
         * RETRIEVAL ONLY (NO REMOVAL)
         * ========================================================
         */

        /*
         * peek()
         * --------------------------------------------------------
         * - Retrieves head of queue
         * - DOES NOT remove element
         * - Returns NULL if queue is empty
         */
        System.out.println("peek(): " + queue.peek());
        System.out.println("Queue after peek: " + queue);

        /*
         * element()
         * --------------------------------------------------------
         * - Retrieves head of queue
         * - DOES NOT remove element
         * - Throws NoSuchElementException if queue is empty
         */
        System.out.println("element(): " + queue.element());
        System.out.println("Queue after element(): " + queue);



        /*
         * ========================================================
         * EMPTY QUEUE BEHAVIOR (VERY IMPORTANT INTERVIEW POINT)
         * ========================================================
         */
        Queue<Integer> emptyQueue = new LinkedList<>();

        System.out.println("\n--- Empty Queue Behavior ---");
        System.out.println("poll(): " + emptyQueue.poll());   // null
        System.out.println("peek(): " + emptyQueue.peek());   // null

        // Uncommenting below lines will throw exception
        // emptyQueue.remove();
        // emptyQueue.element();

        
        /*
         * ========================================================
         * PRIORITY QUEUE (EXCEPTION TO FIFO)
         * ========================================================
         */

        /*
         * PriorityQueue does NOT follow FIFO
         * It orders elements based on:
         * - Natural ordering (default)
         * - Custom Comparator
         */
        Queue<Integer> priorityQueue = new PriorityQueue<>();

        priorityQueue.add(40);
        priorityQueue.add(10);
        priorityQueue.add(30);
        priorityQueue.add(20);

        System.out.println("\nPriorityQueue elements:");
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }

        /*
         * ========================================================
         * WHEN TO USE WHICH METHOD?
         * ========================================================
         *
         * add() / remove() / element()
         * → Use when failure should throw exception
         *
         * offer() / poll() / peek()
         * → Use when failure should be handled gracefully
         */

        /*
         * ========================================================
         * INTERVIEW QUESTIONS & ANSWERS
         * ========================================================
         */

        /*
         * Q1. Is Queue an interface or class?
         * → Queue is an INTERFACE.
         *
         * Q2. Does Queue allow null elements?
         * → NO. Most Queue implementations do not allow null.
         *
         * Q3. Difference between poll() and remove()?
         * → poll(): returns null if empty
         * → remove(): throws exception if empty
         *
         * Q4. Difference between peek() and element()?
         * → peek(): returns null if empty
         * → element(): throws exception if empty
         *
         * Q5. Does PriorityQueue follow FIFO?
         * → NO. It follows priority-based ordering.
         *
         * Q6. Which Queue implementation allows both ends operation?
         * → Deque (ArrayDeque, LinkedList)
         */

        /*
         * ========================================================
         * SUMMARY
         * ========================================================
         *
         * - Queue is used when order matters
         * - FIFO is default behavior
         * - Safer methods: offer(), poll(), peek()
         * - Strict methods: add(), remove(), element()
         * - PriorityQueue is special case
         *
         * ========================================================
         */
    }
}
