package CONCURRENCY.II_LOCK_FREE_MECHANISM;

import java.util.concurrent.atomic.AtomicInteger;

/*
================================================================================
FILE NAME  : 2_AtomicInteger.java
PACKAGE    : concurrency.lock_free_mechanism
TOPIC      : AtomicInteger – Lock-Free Counter using CAS
LEVEL      : Beginner → Advanced → Interview Ready
================================================================================

PURPOSE OF THIS FILE
-------------------
This file explains EVERYTHING about AtomicInteger:

✔ Why AtomicInteger is needed
✔ What problem it solves
✔ Internal working using CAS
✔ Difference between int, synchronized, and AtomicInteger
✔ All important methods
✔ Multiple practical examples
✔ Performance discussion
✔ Interview questions & pitfalls

================================================================================
*/

/*
================================================================================
1. WHY DO WE NEED AtomicInteger?
================================================================================

Problem:
--------
In multithreading, a simple operation like:

    counter++;

is NOT thread-safe.

Because internally it does:
1. Read value
2. Increment
3. Write back

Multiple threads can interleave → WRONG RESULT.

Solutions:
----------
1️⃣ synchronized  → thread-safe but BLOCKING
2️⃣ AtomicInteger → thread-safe and LOCK-FREE ✅

================================================================================
*/

/*
================================================================================
2. WHAT IS AtomicInteger?
================================================================================

AtomicInteger is a class from:
    java.util.concurrent.atomic

It provides:
✔ Atomic operations on an int value
✔ Lock-free thread safety
✔ High performance

Internally uses:
✔ CAS (Compare-And-Swap)

================================================================================
*/

/*
================================================================================
3. INTERNAL WORKING (VERY IMPORTANT)
================================================================================

AtomicInteger does NOT use synchronized.

Instead it uses a loop like:

do {
    oldValue = currentValue;
    newValue = oldValue + 1;
} while (!CAS(memoryLocation, oldValue, newValue));

✔ If CAS fails → retry
✔ If CAS succeeds → update done

This guarantees correctness WITHOUT locking.

================================================================================
*/

/*
================================================================================
4. PROBLEM DEMO: NORMAL int (NOT THREAD-SAFE)
================================================================================
*/

class NormalCounter {

    int counter = 0;

    public void increment() {
        counter++; // NOT atomic
    }

    public int get() {
        return counter;
    }
}

/*
================================================================================
5. RACE CONDITION DEMO
================================================================================
*/

class NormalCounterDemo {

    public static void main(String[] args) throws InterruptedException {

        NormalCounter resource = new NormalCounter();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 200; i++) {
                resource.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 200; i++) {
                resource.increment();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Normal Counter Result: " + resource.get());
        // Expected: 400
        // Actual: ❌ unpredictable
    }
}

/*
================================================================================
6. SOLUTION USING synchronized (LOCK-BASED)
================================================================================
*/

class SynchronizedCounter {

    int counter = 0;

    public synchronized void increment() {
        counter++;
    }

    public int get() {
        return counter;
    }
}

/*
================================================================================
7. SOLUTION USING AtomicInteger (LOCK-FREE)
================================================================================
*/

class AtomicCounter {

    AtomicInteger counter = new AtomicInteger(0);

    public void increment() {
        counter.incrementAndGet(); // Atomic CAS operation
    }

    public int get() {
        return counter.get();
    }
}

/*
================================================================================
8. ATOMICINTEGER DEMO
================================================================================
*/

class AtomicCounterDemo {

    public static void main(String[] args) throws InterruptedException {

        AtomicCounter resource = new AtomicCounter();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 200; i++) {
                resource.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 200; i++) {
                resource.increment();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Atomic Counter Result: " + resource.get());
        // Always correct: 400
    }
}

/*
================================================================================
9. IMPORTANT AtomicInteger METHODS
================================================================================

✔ get()                  → returns current value
✔ set(int newValue)      → sets value
✔ incrementAndGet()      → ++value
✔ getAndIncrement()      → value++
✔ decrementAndGet()
✔ addAndGet(int delta)
✔ compareAndSet(expect, update)

================================================================================
*/

/*
================================================================================
10. compareAndSet() EXAMPLE
================================================================================
*/

class CompareAndSetDemo {

    public static void main(String[] args) {

        AtomicInteger value = new AtomicInteger(10);

        boolean updated = value.compareAndSet(10, 20);

        System.out.println("Updated: " + updated);
        System.out.println("Value  : " + value.get());
        // Output:
        // Updated: true
        // Value  : 20
    }
}

/*
================================================================================
11. PERFORMANCE COMPARISON
================================================================================

synchronized:
-------------
✔ Simple
❌ Blocking
❌ Context switching
❌ Slower under high contention

AtomicInteger:
--------------
✔ Non-blocking
✔ Lock-free
✔ High throughput
✔ Scales well

================================================================================
*/

/*
================================================================================
12. WHEN TO USE AtomicInteger?
================================================================================

✔ Counters
✔ Statistics
✔ Metrics
✔ Sequence numbers
✔ Flags
✔ High-performance systems

================================================================================
*/

/*
================================================================================
13. WHEN NOT TO USE AtomicInteger?
================================================================================

❌ Multiple variables together
❌ Complex business logic
❌ Transaction-like operations

Use:
✔ synchronized
✔ Locks
✔ ReadWriteLock

================================================================================
*/

/*
================================================================================
14. INTERVIEW QUESTIONS
================================================================================

Q1. Is AtomicInteger thread-safe?
Answer:
Yes, it provides atomic operations using CAS.

Q2. Is AtomicInteger faster than synchronized?
Answer:
Yes, under high contention because it avoids blocking.

Q3. Does AtomicInteger use locks?
Answer:
No. It uses lock-free CAS.

Q4. Can AtomicInteger replace synchronized always?
Answer:
No. Only suitable for single-variable atomic operations.

Q5. What happens if CAS fails?
Answer:
The thread retries until it succeeds.

================================================================================
*/

/*
================================================================================
15. KEY TAKEAWAYS
================================================================================

✔ AtomicInteger solves race conditions
✔ Uses CAS internally
✔ Lock-free and high performance
✔ Best for counters & metrics
✔ Not a replacement for all synchronization

================================================================================
END OF FILE
================================================================================
*/
