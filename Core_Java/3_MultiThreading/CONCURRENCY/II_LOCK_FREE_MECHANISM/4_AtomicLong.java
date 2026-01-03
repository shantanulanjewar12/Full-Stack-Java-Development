package CONCURRENCY.II_LOCK_FREE_MECHANISM;

import java.util.concurrent.atomic.AtomicLong;

/*
================================================================================
FILE NAME  : 4_AtomicLong.java
PACKAGE    : concurrency.lock_free_mechanism
TOPIC      : AtomicLong – Lock-Free Long Operations using CAS
LEVEL      : Beginner → Advanced → Interview Ready
================================================================================

PURPOSE OF THIS FILE
-------------------
This file explains AtomicLong in COMPLETE depth:

✔ Why AtomicLong is required
✔ Problems with normal long in multithreading
✔ Why volatile is NOT enough
✔ How AtomicLong works internally (CAS)
✔ AtomicLong methods explained
✔ Real-world use cases
✔ Comparison with synchronized & LongAdder
✔ Interview questions & best practices

================================================================================
*/

/*
================================================================================
1. WHY DO WE NEED AtomicLong?
================================================================================

Problem:
--------
A normal `long` variable is NOT thread-safe.

Example scenarios:
------------------
✔ Counters (requests, hits, likes)
✔ Sequence generators
✔ Metrics (memory, traffic, events)
✔ IDs in concurrent systems

Issues with normal long:
------------------------
❌ Race condition
❌ Lost updates
❌ Non-atomic read/write (64-bit on some platforms)

================================================================================
*/

/*
================================================================================
2. WHAT IS AtomicLong?
================================================================================

AtomicLong is a class from:
    java.util.concurrent.atomic

It provides:
✔ Thread-safe operations on long values
✔ Lock-free (non-blocking) behavior
✔ Atomic updates using CAS

Internal working:
-----------------
✔ Uses Compare-And-Swap (CAS)
✔ Uses CPU-level atomic instructions
✔ No synchronized / no locks

================================================================================
*/

/*
================================================================================
3. PROBLEM WITH NORMAL long (RACE CONDITION)
================================================================================
*/

class NormalCounter {

    long counter = 0;

    public void increment() {
        counter++;   // NOT atomic
    }

    public long get() {
        return counter;
    }
}

/*
================================================================================
4. PROBLEM DEMO (WRONG OUTPUT)
================================================================================
*/

class NormalCounterDemo {

    public static void main(String[] args) throws Exception {

        NormalCounter counter = new NormalCounter();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                counter.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                counter.increment();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(counter.get()); // ❌ NOT guaranteed 200000
    }
}

/*
================================================================================
5. WHY volatile long IS NOT ENOUGH
================================================================================

volatile long:
--------------
✔ Guarantees visibility
❌ Does NOT guarantee atomic increment

Reason:
-------
counter++ = read + modify + write (3 steps)

================================================================================
*/

/*
================================================================================
6. SOLUTION USING synchronized (BLOCKING)
================================================================================
*/

class SynchronizedCounter {

    private long counter = 0;

    public synchronized void increment() {
        counter++;
    }

    public synchronized long get() {
        return counter;
    }
}

/*
================================================================================
7. SOLUTION USING AtomicLong (LOCK-FREE)
================================================================================
*/

class AtomicCounter {

    AtomicLong counter = new AtomicLong(0);

    public void increment() {
        counter.incrementAndGet();
    }

    public long get() {
        return counter.get();
    }
}

/*
================================================================================
8. ATOMICLONG DEMO (CORRECT OUTPUT)
================================================================================
*/

class AtomicLongDemo {

    public static void main(String[] args) throws Exception {

        AtomicCounter counter = new AtomicCounter();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                counter.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                counter.increment();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(counter.get()); // ✅ Always 200000
    }
}

/*
================================================================================
9. IMPORTANT AtomicLong METHODS
================================================================================

✔ get()                    → returns value
✔ set(long value)          → sets value
✔ incrementAndGet()        → ++value
✔ getAndIncrement()        → value++
✔ decrementAndGet()
✔ addAndGet(long delta)
✔ compareAndSet(exp, new)
✔ getAndSet(newValue)

================================================================================
*/

/*
================================================================================
10. compareAndSet() EXAMPLE
================================================================================
*/

class AtomicLongCASDemo {

    public static void main(String[] args) {

        AtomicLong value = new AtomicLong(10);

        boolean success = value.compareAndSet(10, 20);

        System.out.println("CAS Success : " + success);
        System.out.println("Value       : " + value.get());

        // Output:
        // CAS Success : true
        // Value       : 20
    }
}

/*
================================================================================
11. HOW AtomicLong WORKS INTERNALLY
================================================================================

Pseudo logic:
-------------
do {
    expected = value;
    newValue = expected + 1;
} while (!CAS(expected, newValue));

✔ Retry until successful
✔ No thread blocking
✔ Extremely fast under low contention

================================================================================
*/

/*
================================================================================
12. REAL-WORLD USE CASES
================================================================================

✔ Request counters
✔ Rate limiting
✔ Metrics & monitoring
✔ Sequence numbers
✔ Concurrent ID generation

================================================================================
*/

/*
================================================================================
13. AtomicLong vs synchronized
================================================================================

AtomicLong:
-----------
✔ Lock-free
✔ Faster under low contention
✔ No thread blocking

synchronized:
-------------
❌ Blocking
❌ Context switching
✔ Easier for complex logic

================================================================================
*/

/*
================================================================================
14. AtomicLong vs LongAdder (IMPORTANT)
================================================================================

AtomicLong:
-----------
✔ Best for low contention
✔ Accurate value always

LongAdder:
----------
✔ Best for HIGH contention
✔ Uses internal counters
❌ Slight delay in exact value

Interview Tip:
--------------
High traffic counter → LongAdder
Simple counter       → AtomicLong

================================================================================
*/

/*
================================================================================
15. WHEN TO USE AtomicLong?
================================================================================

✔ Single numeric value
✔ Frequent updates
✔ Lock-free performance required

================================================================================
*/

/*
================================================================================
16. WHEN NOT TO USE AtomicLong?
================================================================================

❌ Multiple variables update together
❌ Business logic needs locking
❌ Transactional behavior required

================================================================================
*/

/*
================================================================================
17. INTERVIEW QUESTIONS
================================================================================

Q1. Is AtomicLong thread-safe?
Answer:
Yes, it uses CAS internally.

Q2. Does AtomicLong use synchronized?
Answer:
No, it is lock-free.

Q3. AtomicLong vs volatile long?
Answer:
volatile gives visibility, AtomicLong gives atomicity.

Q4. AtomicLong vs LongAdder?
Answer:
LongAdder is better for high contention.

Q5. Is CAS blocking?
Answer:
No, CAS is non-blocking.

================================================================================
*/

/*
================================================================================
18. KEY TAKEAWAYS
================================================================================

✔ AtomicLong provides lock-free atomic operations
✔ Uses CAS internally
✔ Faster than synchronized
✔ Ideal for counters and metrics
✔ Prefer LongAdder for heavy contention

================================================================================
END OF FILE
================================================================================
*/
