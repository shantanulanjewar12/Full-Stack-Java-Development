import java.util.PriorityQueue;

/**
 * ============================================================
 *  PRIORITY QUEUE – COMPLETE DETAILED NOTES + CODE EXAMPLES
 * ============================================================
 *
 * 1. WHAT IS PriorityQueue?
 * --------------------------
 * PriorityQueue is a concrete class in Java which implements the Queue interface.
 * It does NOT follow FIFO strictly.
 *
 * Instead, elements are processed based on PRIORITY.
 *
 * Priority is determined by:
 *  - Natural Ordering (default)
 *  - Custom Comparator (provided at creation time)
 *
 * ------------------------------------------------------------
 * 2. HIERARCHY
 * ------------------------------------------------------------
 *
 * Iterable
 *   ↑
 * Collection
 *   ↑
 * Queue
 *   ↑
 * PriorityQueue   (Concrete Class)
 *
 * ------------------------------------------------------------
 * 3. INTERNAL DATA STRUCTURE
 * ------------------------------------------------------------
 *
 * PriorityQueue is implemented using a HEAP data structure.
 *
 * Types of Heap:
 *  - Min Heap (DEFAULT)
 *  - Max Heap (Using Comparator)
 *
 * ------------------------------------------------------------
 * 4. IMPORTANT BEHAVIOR
 * ------------------------------------------------------------
 *
 * ✔ Does NOT allow null elements
 * ✔ Duplicate elements are allowed
 * ✔ Ordering is NOT sorted order when iterating
 * ✔ Head element is always the highest priority element
 *
 * ------------------------------------------------------------
 * 5. WHEN TO USE PriorityQueue?
 * ------------------------------------------------------------
 *
 * - Task scheduling
 * - CPU job scheduling
 * - Dijkstra / Prim algorithms
 * - Heap problems
 * - When "highest/lowest" element matters
 *
 * ============================================================
 */
public class _2_PriorityQueue {

    public static void main(String[] args) {

        System.out.println("========== MIN PRIORITY QUEUE ==========");
        minPriorityQueueExample();

        System.out.println("\n========== MAX PRIORITY QUEUE ==========");
        maxPriorityQueueExample();
    }

    /**
     * ============================================================
     * 6. MIN PRIORITY QUEUE (DEFAULT BEHAVIOR)
     * ============================================================
     *
     * - Uses NATURAL ORDERING
     * - Smallest element has HIGHEST PRIORITY
     * - Head element = smallest element
     *
     * INTERNAL STRUCTURE:
     * - Min Heap
     *
     * Example Input: 5, 2, 8, 1
     * Removal Order: 1 → 2 → 5 → 8
     */
    private static void minPriorityQueueExample() {

        // Creating Min Priority Queue (default constructor)
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();

        // Adding elements
        minPQ.add(5);
        minPQ.add(2);
        minPQ.add(8);
        minPQ.add(1);

        /*
         * IMPORTANT:
         * Printing directly does NOT guarantee sorted order
         * because heap only guarantees head element priority.
         */
        System.out.println("Elements in Min PriorityQueue:");
        minPQ.forEach(System.out::println);

        System.out.println("\nRemoving elements (poll):");
        while (!minPQ.isEmpty()) {
            int value = minPQ.poll(); // removes smallest element
            System.out.println("Removed from top: " + value);
        }
    }

    /**
     * ============================================================
     * 7. MAX PRIORITY QUEUE (CUSTOM COMPARATOR)
     * ============================================================
     *
     * - Uses Comparator
     * - Largest element has HIGHEST PRIORITY
     * - Head element = largest element
     *
     * INTERNAL STRUCTURE:
     * - Max Heap (simulated using Comparator)
     *
     * Comparator Logic:
     * (a, b) -> b - a
     *
     * Why?
     * - Default: a - b  → ascending
     * - Reverse: b - a  → descending
     */
    private static void maxPriorityQueueExample() {

        // Creating Max Priority Queue using Comparator
        PriorityQueue<Integer> maxPQ =
                new PriorityQueue<>((a, b) -> b - a);

        maxPQ.add(5);
        maxPQ.add(2);
        maxPQ.add(8);
        maxPQ.add(1);

        System.out.println("Elements in Max PriorityQueue:");
        maxPQ.forEach(System.out::println);

        System.out.println("\nRemoving elements (poll):");
        while (!maxPQ.isEmpty()) {
            int value = maxPQ.poll(); // removes largest element
            System.out.println("Removed from top: " + value);
        }
    }
}

/**
 * ============================================================
 * 8. QUEUE METHODS USED IN PriorityQueue
 * ============================================================
 *
 * add(e)      → Inserts element, throws exception if fails
 * offer(e)    → Inserts element, returns false if fails
 * poll()      → Retrieves & removes head, returns null if empty
 * remove()    → Retrieves & removes head, throws exception if empty
 * peek()      → Retrieves head, returns null if empty
 * element()   → Retrieves head, throws exception if empty
 *
 * ============================================================
 * 9. TIME COMPLEXITY
 * ============================================================
 *
 * add() / offer()           → O(log n)
 * poll() / remove()         → O(log n)
 * peek() / element()        → O(1)
 * remove(Object o)          → O(n)
 *
 * ============================================================
 * 10. WHY OUTPUT LOOKS UNSORTED?
 * ============================================================
 *
 * PriorityQueue maintains heap property, NOT sorted list.
 *
 * Only guarantee:
 * - Head element is highest priority
 *
 * Iteration order ≠ Priority order
 *
 * ============================================================
 * 11. MIN VS MAX PRIORITY QUEUE (SUMMARY)
 * ============================================================
 *
 * Min Priority Queue:
 * - Default
 * - Smallest element first
 * - Uses natural ordering
 *
 * Max Priority Queue:
 * - Uses Comparator
 * - Largest element first
 *
 * ============================================================
 * 12. INTERVIEW QUESTIONS
 * ============================================================
 *
 * Q1. Does PriorityQueue follow FIFO?
 * → No, it follows priority-based ordering.
 *
 * Q2. Can PriorityQueue store null?
 * → No, it throws NullPointerException.
 *
 * Q3. Is PriorityQueue sorted?
 * → No, only head element is guaranteed.
 *
 * Q4. Difference between Queue and PriorityQueue?
 * → Queue: FIFO
 * → PriorityQueue: Priority-based
 *
 * Q5. How to implement Max Heap?
 * → Use Comparator during construction.
 *
 * ============================================================
 * END OF FILE
 * ============================================================
 */
