package CONCURRENCY.I_LOCKS_BASED_MECHANISM;

/*
================================================================================
                     SEMAPHORE – COMPLETE DETAILED NOTES
================================================================================
*/

/*
================================================================================
1. WHY SEMAPHORE WAS INTRODUCED?
================================================================================

Problem before Semaphore:
-------------------------
- synchronized / ReentrantLock allow ONLY ONE thread at a time.
- But some real-world resources allow LIMITED concurrent access.

Examples:
---------
✔ Database connection pool (max 5 connections)
✔ Parking slots (10 cars allowed)
✔ Printer pool
✔ Thread pool

We need:
--------
✔ Control HOW MANY threads can access a resource
✔ Not just mutual exclusion (1 thread)

Solution:
---------
➡ SEMAPHORE

================================================================================
*/

/*
================================================================================
2. WHAT IS A SEMAPHORE?
================================================================================

Definition:
-----------
A Semaphore is a concurrency control mechanism that:
✔ Maintains a fixed number of permits
✔ Allows multiple threads to access a shared resource
✔ Blocks threads when permits are exhausted

Package:
--------
java.util.concurrent

Class:
------
java.util.concurrent.Semaphore

================================================================================
*/

/*
================================================================================
3. REAL-WORLD ANALOGY
================================================================================

Parking Lot Example:
-------------------
- Parking lot has 3 slots (permits = 3)
- Only 3 cars can park at the same time
- 4th car must WAIT

Semaphore behaves exactly like this.

================================================================================
*/

/*
================================================================================
4. KEY TERMINOLOGY
================================================================================

Permit:
-------
✔ A token representing permission to access resource

Acquire:
--------
✔ Thread requests a permit
✔ If permit available → proceed
✔ If not → thread BLOCKS

Release:
--------
✔ Thread releases permit
✔ Wakes up waiting thread (if any)

================================================================================
*/

import java.util.concurrent.Semaphore;

/*
================================================================================
5. SEMAPHORE TYPES
================================================================================

1️⃣ Binary Semaphore
--------------------
- Permits = 1
- Similar to Lock
- Mutual exclusion

2️⃣ Counting Semaphore
----------------------
- Permits > 1
- Allows N threads

================================================================================
*/

/*
================================================================================
6. CONSTRUCTOR VARIANTS
================================================================================

Semaphore(int permits)
Semaphore(int permits, boolean fair)

Fairness:
---------
✔ true  → FIFO (fair scheduling)
✔ false → performance optimized (default)

================================================================================
*/

/*
================================================================================
7. BASIC SYNTAX
================================================================================

Semaphore semaphore = new Semaphore(2);

// Acquire permit
semaphore.acquire();

// Release permit
semaphore.release();

================================================================================
*/

/*
================================================================================
8. SIMPLE EXAMPLE – MULTIPLE THREAD ACCESS
================================================================================
*/

class SharedResource {

    // 2 permits → only 2 threads allowed simultaneously
    private final Semaphore semaphore = new Semaphore(2);

    public void accessResource() {
        try {
            System.out.println(Thread.currentThread().getName()
                    + " waiting to acquire permit");

            semaphore.acquire();   // BLOCKS if no permit

            System.out.println(Thread.currentThread().getName()
                    + " acquired permit");

            // Simulate work
            Thread.sleep(3000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
            System.out.println(Thread.currentThread().getName()
                    + " released permit");
        }
    }
}

/*
================================================================================
9. MAIN CLASS – EXECUTION
================================================================================
*/


public class _4_SemaphoreLock {

    public static void main(String[] args) {

        SharedResource resource = new SharedResource();

        Runnable task = resource::accessResource;

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");
        Thread t3 = new Thread(task, "Thread-3");
        Thread t4 = new Thread(task, "Thread-4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

/*
================================================================================
10. EXECUTION FLOW EXPLANATION
================================================================================

Assume permits = 2

Step-by-step:
-------------
1️⃣ Thread-1 → acquire() → permit granted
2️⃣ Thread-2 → acquire() → permit granted
3️⃣ Thread-3 → acquire() → BLOCKED
4️⃣ Thread-4 → acquire() → BLOCKED
5️⃣ Thread-1 releases → Thread-3 wakes up
6️⃣ Thread-2 releases → Thread-4 wakes up

At no point more than 2 threads execute critical section.

================================================================================
*/

/*
================================================================================
11. IMPORTANT METHODS
================================================================================

acquire()           → blocks until permit available
release()           → releases permit
tryAcquire()        → non-blocking attempt
availablePermits()  → remaining permits
drainPermits()      → remove all permits

================================================================================
*/

/*
================================================================================
12. tryAcquire() EXAMPLE
================================================================================
*/

class TryAcquireExample {

    private final Semaphore semaphore = new Semaphore(1);

    public void doWork() {
        if (semaphore.tryAcquire()) {
            try {
                System.out.println(Thread.currentThread().getName()
                        + " acquired lock");
            } finally {
                semaphore.release();
            }
        } else {
            System.out.println(Thread.currentThread().getName()
                    + " could not acquire lock");
        }
    }
}

/*
================================================================================
13. SEMAPHORE vs LOCK
================================================================================

Feature              Semaphore                Lock
---------------------------------------------------
Access limit         N threads               1 thread
Use case             Resource pool           Mutual exclusion
Fairness option      ✔ Yes                   ✔ Yes
Ownership            ❌ Not owner-based       ✔ Owner-based
Complexity           Moderate                Simple

================================================================================
*/

/*
================================================================================
14. SEMAPHORE vs synchronized
================================================================================

Feature            Semaphore          synchronized
---------------------------------------------------
Multiple permits   ✔ Yes              ❌ No
Non-blocking try   ✔ Yes              ❌ No
Explicit control   ✔ Yes              ❌ No
Ease of use        ❌ Harder           ✔ Easier

================================================================================
*/

/*
================================================================================
15. COMMON INTERVIEW QUESTIONS
================================================================================

Q1: What is Semaphore?
A: A concurrency utility controlling access using permits.

Q2: Difference between Semaphore and Lock?
A: Semaphore allows multiple threads; Lock allows one.

Q3: What is Binary Semaphore?
A: Semaphore with 1 permit.

Q4: Does Semaphore guarantee order?
A: Only if fairness = true.

Q5: Is Semaphore reentrant?
A: No.

================================================================================
*/

/*
================================================================================
16. COMMON MISTAKES
================================================================================

❌ Forgetting release()
❌ Acquiring without finally block
❌ Using Semaphore instead of Lock unnecessarily
❌ Not handling InterruptedException

================================================================================
*/

/*
================================================================================
17. BEST PRACTICES
================================================================================

✔ Always release in finally block
✔ Use fairness only when required
✔ Prefer Lock for simple mutual exclusion
✔ Use Semaphore for resource pooling

================================================================================
*/

/*
================================================================================
18. ONE-LINE INTERVIEW SUMMARY
================================================================================

"A Semaphore controls access to a resource by limiting the number of threads
that can access it concurrently using permits."

================================================================================
END OF FILE
================================================================================
*/
