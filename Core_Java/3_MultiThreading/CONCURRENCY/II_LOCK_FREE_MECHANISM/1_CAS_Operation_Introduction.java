package CONCURRENCY.II_LOCK_FREE_MECHANISM;
/*
================================================================================
FILE NAME  : 1_CAS_Operation_Introduction.java
PACKAGE    : concurrency.lock_free_mechanism
TOPIC      : CAS (Compare-And-Swap) – Lock Free Mechanism Foundation
LEVEL      : Beginner → Advanced → Interview Ready
================================================================================

This file explains:
✔ What Lock-Free mechanism is
✔ Why CAS is needed
✔ How CAS works internally
✔ Difference between Lock-based vs Lock-free
✔ Atomicity concept
✔ ABA Problem (IMPORTANT)
✔ Interview questions

NOTE:
-----
This file focuses ONLY on CAS.
AtomicInteger, AtomicBoolean etc. will be in SEPARATE files.

================================================================================
*/

/*
================================================================================
1. WHAT IS LOCK-FREE MECHANISM?
================================================================================

Lock-Free Mechanism is a concurrency approach where:

✔ Threads DO NOT block each other
✔ No explicit locking (synchronized / Lock)
✔ Threads retry instead of waiting
✔ At least one thread always makes progress

This improves:
✔ Performance
✔ Scalability
✔ CPU utilization

--------------------------------------------------------------------------------
CONTRAST:
--------------------------------------------------------------------------------
LOCK-BASED:
- synchronized
- ReentrantLock
- Semaphore
❌ Blocking
❌ Context switching
❌ Deadlock risk

LOCK-FREE:
- CAS
- Atomic classes
✔ No blocking
✔ High throughput
✔ No deadlock

================================================================================
*/

/*
================================================================================
2. WHAT IS CAS (COMPARE-AND-SWAP)?
================================================================================

CAS is a LOW-LEVEL, HARDWARE-SUPPORTED atomic operation.

CAS means:
---------
"Compare the current value with expected value,
if equal → swap with new value"

CAS is the CORE building block of:
✔ AtomicInteger
✔ AtomicBoolean
✔ AtomicLong
✔ AtomicReference

================================================================================
*/

/*
================================================================================
3. CAS INVOLVES 3 PARAMETERS (VERY IMPORTANT)
================================================================================

CAS(memoryLocation, expectedValue, newValue)

1️⃣ Memory Location
   - Where variable is stored in memory

2️⃣ Expected Value
   - Value we THINK is currently present

3️⃣ New Value
   - Value we want to update

--------------------------------------------------------------------------------
CAS LOGIC:
--------------------------------------------------------------------------------

IF (memoryValue == expectedValue)
    memoryValue = newValue   ✅ SUCCESS
ELSE
    do nothing               ❌ FAIL (retry)

✔ Entire operation is ATOMIC
✔ No other thread can interrupt

================================================================================
*/

/*
================================================================================
4. WHY CAS IS ATOMIC?
================================================================================

✔ CAS is implemented using CPU instructions
✔ CPU locks the memory bus for that operation
✔ No OS-level locking
✔ Happens in a single CPU cycle

Hence:
✔ No partial update
✔ No race condition

================================================================================
*/

/*
================================================================================
5. WHAT DOES "ATOMIC" MEAN?
================================================================================

Atomic means:
-------------
✔ Single
✔ Indivisible
✔ All-or-Nothing

Atomic operation guarantees:
- Either COMPLETES fully
- Or DOES NOT HAPPEN at all

No intermediate state visible to other threads.

================================================================================
*/

/*
================================================================================
6. PROBLEM WITH NORMAL VARIABLE (NO CAS)
================================================================================

counter++ LOOKS simple but internally it is:

1. Read counter
2. Increment value
3. Write back

⚠ Multiple threads can interleave these steps
⚠ Result becomes incorrect

================================================================================
*/

class NormalCounter {

    int counter = 0;

    public void increment() {
        counter++;   // NOT ATOMIC
    }

    public int get() {
        return counter;
    }
}

/*
================================================================================
7. DEMO: RACE CONDITION WITHOUT CAS
================================================================================
*/

class RaceConditionDemo {

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

        System.out.println("Result without CAS: " + resource.get());
        // Expected: 400
        // Actual: ❌ unpredictable (e.g. 365, 372)
    }
}

/*
================================================================================
8. HOW CAS SOLVES THIS PROBLEM?
================================================================================

Instead of:
counter++

CAS does:
---------
loop:
    oldValue = read counter
    newValue = oldValue + 1
    if CAS(counter, oldValue, newValue) SUCCESS
        break
    else
        retry

✔ No blocking
✔ Safe under concurrency

================================================================================
*/

/*
================================================================================
9. ABA PROBLEM (VERY IMPORTANT INTERVIEW QUESTION)
================================================================================

Scenario:
---------
Initial value = A

Thread T1 reads A
Thread T2 changes A → B → A
Thread T1 performs CAS expecting A → succeeds ❌

Problem:
--------
CAS thinks value unchanged, but it WAS modified

This is called ABA Problem.

--------------------------------------------------------------------------------
SOLUTION:
--------------------------------------------------------------------------------
✔ Use version / stamp
✔ AtomicStampedReference
✔ AtomicMarkableReference

(We will cover this in AtomicReference file)

================================================================================
*/

/*
================================================================================
10. WHEN TO USE CAS?
================================================================================

✔ High-performance systems
✔ Counters
✔ Metrics
✔ Flags
✔ Lock-free data structures
✔ Concurrent collections internally use CAS

================================================================================
*/

/*
================================================================================
11. WHEN NOT TO USE CAS?
================================================================================

❌ Complex multi-step business logic
❌ Multiple shared variables together
❌ Transaction-like operations

Use:
✔ synchronized
✔ Lock
✔ ReadWriteLock

================================================================================
*/

/*
================================================================================
12. INTERVIEW QUESTIONS
================================================================================

Q1. What is CAS?
Answer:
Compare-And-Swap is a low-level atomic operation that updates memory
only if the expected value matches the current value.

Q2. Is CAS lock-free?
Answer:
Yes. CAS does not block threads.

Q3. Does CAS guarantee fairness?
Answer:
No. Threads may retry multiple times (starvation possible).

Q4. What is ABA problem?
Answer:
A value changes A → B → A, misleading CAS.

Q5. How is ABA solved?
Answer:
Using versioning via AtomicStampedReference.

================================================================================
*/

/*
================================================================================
13. KEY TAKEAWAYS
================================================================================

✔ CAS is the foundation of lock-free programming
✔ CAS is atomic and hardware-supported
✔ Atomic classes internally use CAS
✔ Faster than synchronized for simple operations
✔ Not suitable for complex logic

================================================================================
END OF FILE
================================================================================
*/
